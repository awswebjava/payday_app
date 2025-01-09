package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paistipotrabajogetolddef extends GXProcedure
{
   public paistipotrabajogetolddef( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajogetolddef.class ), "" );
   }

   public paistipotrabajogetolddef( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.SdtPaisTipoTrabajo_old executeUdp( short aP0 ,
                                                 String aP1 )
   {
      paistipotrabajogetolddef.this.aP2 = new web.SdtPaisTipoTrabajo_old[] {new web.SdtPaisTipoTrabajo_old()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        web.SdtPaisTipoTrabajo_old[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             web.SdtPaisTipoTrabajo_old[] aP2 )
   {
      paistipotrabajogetolddef.this.AV9PaiCod = aP0;
      paistipotrabajogetolddef.this.AV10PaiTipoTraId = aP1;
      paistipotrabajogetolddef.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X42 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), AV10PaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01X42_A1294PaiTipoTraId[0] ;
         A46PaiCod = P01X42_A46PaiCod[0] ;
         A1976PaiTipoTraOldDefault = P01X42_A1976PaiTipoTraOldDefault[0] ;
         AV8PaisTipoTrabajo_old.fromJSonString(A1976PaiTipoTraOldDefault, null);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = paistipotrabajogetolddef.this.AV8PaisTipoTrabajo_old;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PaisTipoTrabajo_old = new web.SdtPaisTipoTrabajo_old(remoteHandle, context);
      scmdbuf = "" ;
      P01X42_A1294PaiTipoTraId = new String[] {""} ;
      P01X42_A46PaiCod = new short[1] ;
      P01X42_A1976PaiTipoTraOldDefault = new String[] {""} ;
      A1294PaiTipoTraId = "" ;
      A1976PaiTipoTraOldDefault = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajogetolddef__default(),
         new Object[] {
             new Object[] {
            P01X42_A1294PaiTipoTraId, P01X42_A46PaiCod, P01X42_A1976PaiTipoTraOldDefault
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV10PaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A1976PaiTipoTraOldDefault ;
   private web.SdtPaisTipoTrabajo_old[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01X42_A1294PaiTipoTraId ;
   private short[] P01X42_A46PaiCod ;
   private String[] P01X42_A1976PaiTipoTraOldDefault ;
   private web.SdtPaisTipoTrabajo_old AV8PaisTipoTrabajo_old ;
}

final  class paistipotrabajogetolddef__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X42", "SELECT PaiTipoTraId, PaiCod, PaiTipoTraOldDefault FROM PaisTipoTrabajo WHERE PaiCod = ? and PaiTipoTraId = ( ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

