package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reportarcalculosnousados extends GXProcedure
{
   public reportarcalculosnousados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reportarcalculosnousados.class ), "" );
   }

   public reportarcalculosnousados( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      reportarcalculosnousados.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      /* Using cursor P01L72 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A537OpeCodForMay = P01L72_A537OpeCodForMay[0] ;
         A74idOperando = P01L72_A74idOperando[0] ;
         A46PaiCod = P01L72_A46PaiCod[0] ;
         AV10OpeCodForMay = A537OpeCodForMay ;
         /* Execute user subroutine: 'CONCEPTOS' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! AV11usado )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "NO USADO: ", "")+A74idOperando) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'CONCEPTOS' Routine */
      returnInSub = false ;
      AV11usado = false ;
      AV16GXLvl14 = (byte)(0) ;
      /* Using cursor P01L73 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P01L73_A3CliCod[0] ;
         A148ConFormula = P01L73_A148ConFormula[0] ;
         n148ConFormula = P01L73_n148ConFormula[0] ;
         A26ConCodigo = P01L73_A26ConCodigo[0] ;
         AV16GXLvl14 = (byte)(1) ;
         if ( GXutil.strSearch( GXutil.upper( A148ConFormula), GXutil.trim( AV10OpeCodForMay), 1) != 0 )
         {
            AV11usado = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV16GXLvl14 == 0 )
      {
      }
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
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P01L72_A537OpeCodForMay = new String[] {""} ;
      P01L72_A74idOperando = new String[] {""} ;
      P01L72_A46PaiCod = new short[1] ;
      A537OpeCodForMay = "" ;
      A74idOperando = "" ;
      AV10OpeCodForMay = "" ;
      AV15Pgmname = "" ;
      A148ConFormula = "" ;
      P01L73_A3CliCod = new int[1] ;
      P01L73_A148ConFormula = new String[] {""} ;
      P01L73_n148ConFormula = new boolean[] {false} ;
      P01L73_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.reportarcalculosnousados__default(),
         new Object[] {
             new Object[] {
            P01L72_A537OpeCodForMay, P01L72_A74idOperando, P01L72_A46PaiCod
            }
            , new Object[] {
            P01L73_A3CliCod, P01L73_A148ConFormula, P01L73_n148ConFormula, P01L73_A26ConCodigo
            }
         }
      );
      AV15Pgmname = "reportarCalculosNoUsados" ;
      /* GeneXus formulas. */
      AV15Pgmname = "reportarCalculosNoUsados" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16GXLvl14 ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A537OpeCodForMay ;
   private String A74idOperando ;
   private String AV10OpeCodForMay ;
   private String AV15Pgmname ;
   private String A26ConCodigo ;
   private boolean returnInSub ;
   private boolean AV11usado ;
   private boolean n148ConFormula ;
   private String A148ConFormula ;
   private IDataStoreProvider pr_default ;
   private String[] P01L72_A537OpeCodForMay ;
   private String[] P01L72_A74idOperando ;
   private short[] P01L72_A46PaiCod ;
   private int[] P01L73_A3CliCod ;
   private String[] P01L73_A148ConFormula ;
   private boolean[] P01L73_n148ConFormula ;
   private String[] P01L73_A26ConCodigo ;
}

final  class reportarcalculosnousados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01L72", "SELECT OpeCodForMay, idOperando, PaiCod FROM calculo ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01L73", "SELECT CliCod, ConFormula, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

