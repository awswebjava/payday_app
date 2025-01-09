package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importararchivolsd extends GXProcedure
{
   public importararchivolsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importararchivolsd.class ), "" );
   }

   public importararchivolsd( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              String aP3 ,
                              String aP4 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 )
   {
      importararchivolsd.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        String aP4 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 ,
                             boolean[] aP6 )
   {
      importararchivolsd.this.AV9CliCod = aP0;
      importararchivolsd.this.AV11EmpCod = aP1;
      importararchivolsd.this.AV14ImpLiqSec = aP2;
      importararchivolsd.this.AV25parm_ImpLiqLSDFile = aP3;
      importararchivolsd.this.AV24path = aP4;
      importararchivolsd.this.aP5 = aP5;
      importararchivolsd.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18OK = true ;
      /* Using cursor P00O92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Short.valueOf(AV14ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00O92_A3CliCod[0] ;
         A1EmpCod = P00O92_A1EmpCod[0] ;
         A88ImpLiqSec = P00O92_A88ImpLiqSec[0] ;
         A704ImpLiqLSDSec = P00O92_A704ImpLiqLSDSec[0] ;
         AV21ImpLiqLSDSec = A704ImpLiqLSDSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV21ImpLiqLSDSec = (short)(AV21ImpLiqLSDSec+1) ;
      if ( (GXutil.strcmp("", AV25parm_ImpLiqLSDFile)==0) )
      {
         AV23file.setSource( AV24path );
         AV22ImpLiqLSDFile = AV23file.getURI() ;
         AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( AV22ImpLiqLSDFile );
      }
      else
      {
         AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( AV25parm_ImpLiqLSDFile );
      }
      AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod( AV9CliCod );
      AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod( AV11EmpCod );
      AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( AV14ImpLiqSec );
      AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( AV21ImpLiqLSDSec );
      AV20importacion_liquidacion_lsd.Save();
      if ( AV20importacion_liquidacion_lsd.Success() )
      {
         GXv_objcol_svchar1[0] = AV12errores ;
         GXv_int2[0] = AV8altas ;
         new web.procesouploadarchlsd_reg3(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV14ImpLiqSec, AV21ImpLiqLSDSec, GXv_objcol_svchar1, GXv_int2) ;
         AV12errores = GXv_objcol_svchar1[0] ;
         importararchivolsd.this.AV8altas = GXv_int2[0] ;
         if ( AV12errores.size() == 0 )
         {
         }
         else
         {
            AV18OK = false ;
            AV10e = (short)(1) ;
            while ( AV10e <= AV12errores.size() )
            {
               AV16Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
               AV16Message.setgxTv_SdtMessages_Message_Description( (String)AV12errores.elementAt(-1+AV10e) );
               AV16Message.setgxTv_SdtMessages_Message_Id( GXutil.trim( GXutil.str( AV10e, 4, 0)) );
               AV16Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
               AV17Messages.add(AV16Message, 0);
               AV10e = (short)(AV10e+1) ;
            }
            AV20importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( "" );
         }
      }
      else
      {
         AV17Messages = AV20importacion_liquidacion_lsd.GetMessages() ;
         AV18OK = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = importararchivolsd.this.AV17Messages;
      this.aP6[0] = importararchivolsd.this.AV18OK;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      scmdbuf = "" ;
      P00O92_A3CliCod = new int[1] ;
      P00O92_A1EmpCod = new short[1] ;
      P00O92_A88ImpLiqSec = new short[1] ;
      P00O92_A704ImpLiqLSDSec = new short[1] ;
      AV23file = new com.genexus.util.GXFile();
      AV22ImpLiqLSDFile = "" ;
      AV20importacion_liquidacion_lsd = new web.Sdtimportacion_liquidacion_lsd(remoteHandle);
      AV12errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar1 = new GXSimpleCollection[1] ;
      GXv_int2 = new short[1] ;
      AV16Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importararchivolsd__default(),
         new Object[] {
             new Object[] {
            P00O92_A3CliCod, P00O92_A1EmpCod, P00O92_A88ImpLiqSec, P00O92_A704ImpLiqLSDSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV14ImpLiqSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short A704ImpLiqLSDSec ;
   private short AV21ImpLiqLSDSec ;
   private short AV8altas ;
   private short GXv_int2[] ;
   private short AV10e ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV18OK ;
   private String AV25parm_ImpLiqLSDFile ;
   private String AV22ImpLiqLSDFile ;
   private String AV24path ;
   private com.genexus.util.GXFile AV23file ;
   private web.Sdtimportacion_liquidacion_lsd AV20importacion_liquidacion_lsd ;
   private boolean[] aP6 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00O92_A3CliCod ;
   private short[] P00O92_A1EmpCod ;
   private short[] P00O92_A88ImpLiqSec ;
   private short[] P00O92_A704ImpLiqLSDSec ;
   private GXSimpleCollection<String> AV12errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV17Messages ;
   private com.genexus.SdtMessages_Message AV16Message ;
}

final  class importararchivolsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O92", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

