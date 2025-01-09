package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validareliminacionimpconcepto extends GXProcedure
{
   public validareliminacionimpconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validareliminacionimpconcepto.class ), "" );
   }

   public validareliminacionimpconcepto( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              String[] aP3 )
   {
      validareliminacionimpconcepto.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      validareliminacionimpconcepto.this.AV11CliCod = aP0;
      validareliminacionimpconcepto.this.AV8EmpCod = aP1;
      validareliminacionimpconcepto.this.AV9ImpLiqSec = aP2;
      validareliminacionimpconcepto.this.aP3 = aP3;
      validareliminacionimpconcepto.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00O32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV9ImpLiqSec), AV12ImpLiqConExtCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89ImpLiqConExtCod = P00O32_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P00O32_A88ImpLiqSec[0] ;
         A1EmpCod = P00O32_A1EmpCod[0] ;
         A3CliCod = P00O32_A3CliCod[0] ;
         A641ImpLiqConSisCod = P00O32_A641ImpLiqConSisCod[0] ;
         if ( (GXutil.strcmp("", A641ImpLiqConSisCod)==0) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            /* Execute user subroutine: 'DETALLE' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'DETALLE' Routine */
      returnInSub = false ;
      /* Using cursor P00O33 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV9ImpLiqSec), AV12ImpLiqConExtCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A666ImpLiqDetConCod = P00O33_A666ImpLiqDetConCod[0] ;
         A88ImpLiqSec = P00O33_A88ImpLiqSec[0] ;
         A1EmpCod = P00O33_A1EmpCod[0] ;
         A3CliCod = P00O33_A3CliCod[0] ;
         A90ImpLiqDetSec = P00O33_A90ImpLiqDetSec[0] ;
         AV14errorEs = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = validareliminacionimpconcepto.this.AV12ImpLiqConExtCod;
      this.aP4[0] = validareliminacionimpconcepto.this.AV14errorEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ImpLiqConExtCod = "" ;
      scmdbuf = "" ;
      P00O32_A89ImpLiqConExtCod = new String[] {""} ;
      P00O32_A88ImpLiqSec = new short[1] ;
      P00O32_A1EmpCod = new short[1] ;
      P00O32_A3CliCod = new int[1] ;
      P00O32_A641ImpLiqConSisCod = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      A641ImpLiqConSisCod = "" ;
      P00O33_A666ImpLiqDetConCod = new String[] {""} ;
      P00O33_A88ImpLiqSec = new short[1] ;
      P00O33_A1EmpCod = new short[1] ;
      P00O33_A3CliCod = new int[1] ;
      P00O33_A90ImpLiqDetSec = new short[1] ;
      A666ImpLiqDetConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validareliminacionimpconcepto__default(),
         new Object[] {
             new Object[] {
            P00O32_A89ImpLiqConExtCod, P00O32_A88ImpLiqSec, P00O32_A1EmpCod, P00O32_A3CliCod, P00O32_A641ImpLiqConSisCod
            }
            , new Object[] {
            P00O33_A666ImpLiqDetConCod, P00O33_A88ImpLiqSec, P00O33_A1EmpCod, P00O33_A3CliCod, P00O33_A90ImpLiqDetSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV9ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV12ImpLiqConExtCod ;
   private String scmdbuf ;
   private String A89ImpLiqConExtCod ;
   private String A641ImpLiqConSisCod ;
   private String A666ImpLiqDetConCod ;
   private boolean AV14errorEs ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private boolean[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00O32_A89ImpLiqConExtCod ;
   private short[] P00O32_A88ImpLiqSec ;
   private short[] P00O32_A1EmpCod ;
   private int[] P00O32_A3CliCod ;
   private String[] P00O32_A641ImpLiqConSisCod ;
   private String[] P00O33_A666ImpLiqDetConCod ;
   private short[] P00O33_A88ImpLiqSec ;
   private short[] P00O33_A1EmpCod ;
   private int[] P00O33_A3CliCod ;
   private short[] P00O33_A90ImpLiqDetSec ;
}

final  class validareliminacionimpconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O32", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConSisCod FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00O33", "SELECT ImpLiqDetConCod, ImpLiqSec, EmpCod, CliCod, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE (CliCod = ? and EmpCod = ? and ImpLiqSec = ?) AND (ImpLiqDetConCod = ( ?)) ORDER BY CliCod, EmpCod, ImpLiqSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

