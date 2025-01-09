package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getaumentoporzona extends GXProcedure
{
   public getaumentoporzona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getaumentoporzona.class ), "" );
   }

   public getaumentoporzona( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      getaumentoporzona.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getaumentoporzona.this.AV8CliCod = aP0;
      getaumentoporzona.this.AV9EmpCod = aP1;
      getaumentoporzona.this.AV10LegNumero = aP2;
      getaumentoporzona.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00WF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00WF2_A6LegNumero[0] ;
         A1EmpCod = P00WF2_A1EmpCod[0] ;
         A3CliCod = P00WF2_A3CliCod[0] ;
         A20ZonCod = P00WF2_A20ZonCod[0] ;
         n20ZonCod = P00WF2_n20ZonCod[0] ;
         AV11ZonCod = A20ZonCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P00WF3 */
      pr_default.execute(1, new Object[] {AV11ZonCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A20ZonCod = P00WF3_A20ZonCod[0] ;
         n20ZonCod = P00WF3_n20ZonCod[0] ;
         A880ZonPorcAumenDed = P00WF3_A880ZonPorcAumenDed[0] ;
         AV12ZonPorcAumenDed = A880ZonPorcAumenDed ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV12ZonPorcAumenDed)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV12ZonPorcAumenDed = DecimalUtil.doubleToDec(1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getaumentoporzona.this.AV12ZonPorcAumenDed;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ZonPorcAumenDed = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00WF2_A6LegNumero = new int[1] ;
      P00WF2_A1EmpCod = new short[1] ;
      P00WF2_A3CliCod = new int[1] ;
      P00WF2_A20ZonCod = new String[] {""} ;
      P00WF2_n20ZonCod = new boolean[] {false} ;
      A20ZonCod = "" ;
      AV11ZonCod = "" ;
      P00WF3_A20ZonCod = new String[] {""} ;
      P00WF3_n20ZonCod = new boolean[] {false} ;
      P00WF3_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A880ZonPorcAumenDed = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getaumentoporzona__default(),
         new Object[] {
             new Object[] {
            P00WF2_A6LegNumero, P00WF2_A1EmpCod, P00WF2_A3CliCod, P00WF2_A20ZonCod, P00WF2_n20ZonCod
            }
            , new Object[] {
            P00WF3_A20ZonCod, P00WF3_A880ZonPorcAumenDed
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12ZonPorcAumenDed ;
   private java.math.BigDecimal A880ZonPorcAumenDed ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private String AV11ZonCod ;
   private boolean n20ZonCod ;
   private boolean Cond_result ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00WF2_A6LegNumero ;
   private short[] P00WF2_A1EmpCod ;
   private int[] P00WF2_A3CliCod ;
   private String[] P00WF2_A20ZonCod ;
   private boolean[] P00WF2_n20ZonCod ;
   private String[] P00WF3_A20ZonCod ;
   private boolean[] P00WF3_n20ZonCod ;
   private java.math.BigDecimal[] P00WF3_A880ZonPorcAumenDed ;
}

final  class getaumentoporzona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00WF2", "SELECT LegNumero, EmpCod, CliCod, ZonCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00WF3", "SELECT ZonCod, ZonPorcAumenDed FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

