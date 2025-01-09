package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabarhistorico extends GXProcedure
{
   public grabarhistorico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabarhistorico.class ), "" );
   }

   public grabarhistorico( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        long aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             long aP4 ,
                             boolean aP5 )
   {
      grabarhistorico.this.AV16CliCod = aP0;
      grabarhistorico.this.AV8ConCodigo = aP1;
      grabarhistorico.this.AV9ForHisAntes = aP2;
      grabarhistorico.this.AV10ForHisDespues = aP3;
      grabarhistorico.this.AV12ImpSec = aP4;
      grabarhistorico.this.AV13registroNuevo = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV11ForHisNum ;
      GXv_int2[0] = GXt_int1 ;
      new web.getnexthis(remoteHandle, context).execute( AV8ConCodigo, GXv_int2) ;
      grabarhistorico.this.GXt_int1 = GXv_int2[0] ;
      AV11ForHisNum = GXt_int1 ;
      if ( AV11ForHisNum == 1 )
      {
         GXt_boolean3 = AV14tieneHistorico ;
         GXv_boolean4[0] = GXt_boolean3 ;
         new web.hayhistorico(remoteHandle, context).execute( AV16CliCod, AV8ConCodigo, GXv_boolean4) ;
         grabarhistorico.this.GXt_boolean3 = GXv_boolean4[0] ;
         AV14tieneHistorico = GXt_boolean3 ;
         /* Using cursor P003C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), AV8ConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A145ConFchModFor = P003C2_A145ConFchModFor[0] ;
            n145ConFchModFor = P003C2_n145ConFchModFor[0] ;
            A148ConFormula = P003C2_A148ConFormula[0] ;
            n148ConFormula = P003C2_n148ConFormula[0] ;
            A156ConUsuModFor = P003C2_A156ConUsuModFor[0] ;
            n156ConUsuModFor = P003C2_n156ConUsuModFor[0] ;
            A26ConCodigo = P003C2_A26ConCodigo[0] ;
            A3CliCod = P003C2_A3CliCod[0] ;
            W3CliCod = A3CliCod ;
            W26ConCodigo = A26ConCodigo ;
            if ( ! AV14tieneHistorico )
            {
               /*
                  INSERT RECORD ON TABLE FormulaHistorico

               */
               W3CliCod = A3CliCod ;
               W26ConCodigo = A26ConCodigo ;
               A3CliCod = AV16CliCod ;
               A26ConCodigo = AV8ConCodigo ;
               A51ForHisNum = AV11ForHisNum ;
               A223ForHisFecha = A145ConFchModFor ;
               A221ForHisAntes = "" ;
               n221ForHisAntes = false ;
               n221ForHisAntes = true ;
               A222ForHisDespues = GXutil.trim( A148ConFormula) ;
               A224ForHisUsuario = A156ConUsuModFor ;
               A52ImpSec = 0 ;
               n52ImpSec = false ;
               n52ImpSec = true ;
               /* Using cursor P003C3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum), A223ForHisFecha, Boolean.valueOf(n221ForHisAntes), A221ForHisAntes, A222ForHisDespues, A224ForHisUsuario, Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
               if ( (pr_default.getStatus(1) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               A3CliCod = W3CliCod ;
               A26ConCodigo = W26ConCodigo ;
               /* End Insert */
               AV11ForHisNum = (short)(AV11ForHisNum+1) ;
            }
            A3CliCod = W3CliCod ;
            A26ConCodigo = W26ConCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      if ( ! (GXutil.strcmp("", AV10ForHisDespues)==0) || ( AV11ForHisNum > 2 ) )
      {
         /*
            INSERT RECORD ON TABLE FormulaHistorico

         */
         A3CliCod = AV16CliCod ;
         A26ConCodigo = AV8ConCodigo ;
         A51ForHisNum = AV11ForHisNum ;
         A223ForHisFecha = GXutil.serverNow( context, remoteHandle, pr_default) ;
         if ( AV13registroNuevo )
         {
            A221ForHisAntes = "" ;
            n221ForHisAntes = false ;
            n221ForHisAntes = true ;
         }
         else
         {
            A221ForHisAntes = GXutil.trim( AV9ForHisAntes) ;
            n221ForHisAntes = false ;
         }
         A222ForHisDespues = GXutil.trim( AV10ForHisDespues) ;
         GXt_char5 = A224ForHisUsuario ;
         GXv_char6[0] = GXt_char5 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char6) ;
         grabarhistorico.this.GXt_char5 = GXv_char6[0] ;
         A224ForHisUsuario = GXt_char5 ;
         if ( ! (0==AV12ImpSec) )
         {
            A52ImpSec = AV12ImpSec ;
            n52ImpSec = false ;
         }
         else
         {
            A52ImpSec = 0 ;
            n52ImpSec = false ;
            n52ImpSec = true ;
         }
         /* Using cursor P003C4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum), A223ForHisFecha, Boolean.valueOf(n221ForHisAntes), A221ForHisAntes, A222ForHisDespues, A224ForHisUsuario, Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      GXv_boolean4 = new boolean[1] ;
      scmdbuf = "" ;
      P003C2_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003C2_n145ConFchModFor = new boolean[] {false} ;
      P003C2_A148ConFormula = new String[] {""} ;
      P003C2_n148ConFormula = new boolean[] {false} ;
      P003C2_A156ConUsuModFor = new String[] {""} ;
      P003C2_n156ConUsuModFor = new boolean[] {false} ;
      P003C2_A26ConCodigo = new String[] {""} ;
      P003C2_A3CliCod = new int[1] ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A148ConFormula = "" ;
      A156ConUsuModFor = "" ;
      A26ConCodigo = "" ;
      W26ConCodigo = "" ;
      A223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      A221ForHisAntes = "" ;
      A222ForHisDespues = "" ;
      A224ForHisUsuario = "" ;
      Gx_emsg = "" ;
      GXt_char5 = "" ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabarhistorico__default(),
         new Object[] {
             new Object[] {
            P003C2_A145ConFchModFor, P003C2_n145ConFchModFor, P003C2_A148ConFormula, P003C2_n148ConFormula, P003C2_A156ConUsuModFor, P003C2_n156ConUsuModFor, P003C2_A26ConCodigo, P003C2_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11ForHisNum ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A51ForHisNum ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int A3CliCod ;
   private int W3CliCod ;
   private int GX_INS16 ;
   private long AV12ImpSec ;
   private long A52ImpSec ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A156ConUsuModFor ;
   private String A26ConCodigo ;
   private String W26ConCodigo ;
   private String Gx_emsg ;
   private String GXt_char5 ;
   private String GXv_char6[] ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date A223ForHisFecha ;
   private boolean AV13registroNuevo ;
   private boolean AV14tieneHistorico ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean n145ConFchModFor ;
   private boolean n148ConFormula ;
   private boolean n156ConUsuModFor ;
   private boolean n221ForHisAntes ;
   private boolean n52ImpSec ;
   private String AV9ForHisAntes ;
   private String AV10ForHisDespues ;
   private String A148ConFormula ;
   private String A221ForHisAntes ;
   private String A222ForHisDespues ;
   private String A224ForHisUsuario ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P003C2_A145ConFchModFor ;
   private boolean[] P003C2_n145ConFchModFor ;
   private String[] P003C2_A148ConFormula ;
   private boolean[] P003C2_n148ConFormula ;
   private String[] P003C2_A156ConUsuModFor ;
   private boolean[] P003C2_n156ConUsuModFor ;
   private String[] P003C2_A26ConCodigo ;
   private int[] P003C2_A3CliCod ;
}

final  class grabarhistorico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003C2", "SELECT ConFchModFor, ConFormula, ConUsuModFor, ConCodigo, CliCod FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P003C3", "SAVEPOINT gxupdate;INSERT INTO FormulaHistorico(CliCod, ConCodigo, ForHisNum, ForHisFecha, ForHisAntes, ForHisDespues, ForHisUsuario, ImpSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003C4", "SAVEPOINT gxupdate;INSERT INTO FormulaHistorico(CliCod, ConCodigo, ForHisNum, ForHisFecha, ForHisAntes, ForHisDespues, ForHisUsuario, ImpSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 10);
               ((int[]) buf[7])[0] = rslt.getInt(5);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[5]);
               }
               stmt.setNLongVarchar(6, (String)parms[6], false);
               stmt.setVarchar(7, (String)parms[7], 100, false);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(8, ((Number) parms[9]).longValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[5]);
               }
               stmt.setNLongVarchar(6, (String)parms[6], false);
               stmt.setVarchar(7, (String)parms[7], 100, false);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(8, ((Number) parms[9]).longValue());
               }
               return;
      }
   }

}

