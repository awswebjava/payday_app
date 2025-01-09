package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getantiguedadporempresa extends GXProcedure
{
   public getantiguedadporempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getantiguedadporempresa.class ), "" );
   }

   public getantiguedadporempresa( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 )
   {
      getantiguedadporempresa.this.aP2 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.math.BigDecimal[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal[] aP2 )
   {
      getantiguedadporempresa.this.AV10CliCod = aP0;
      getantiguedadporempresa.this.AV9EmpCod = aP1;
      getantiguedadporempresa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P018Q2_A1EmpCod[0] ;
         A3CliCod = P018Q2_A3CliCod[0] ;
         A1140EmpAntiguedad = P018Q2_A1140EmpAntiguedad[0] ;
         AV8EmpAntiguedad = A1140EmpAntiguedad ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getantiguedadporempresa.this.AV8EmpAntiguedad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8EmpAntiguedad = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P018Q2_A1EmpCod = new short[1] ;
      P018Q2_A3CliCod = new int[1] ;
      P018Q2_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1140EmpAntiguedad = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getantiguedadporempresa__default(),
         new Object[] {
             new Object[] {
            P018Q2_A1EmpCod, P018Q2_A3CliCod, P018Q2_A1140EmpAntiguedad
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8EmpAntiguedad ;
   private java.math.BigDecimal A1140EmpAntiguedad ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P018Q2_A1EmpCod ;
   private int[] P018Q2_A3CliCod ;
   private java.math.BigDecimal[] P018Q2_A1140EmpAntiguedad ;
}

final  class getantiguedadporempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018Q2", "SELECT EmpCod, CliCod, EmpAntiguedad FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
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
               return;
      }
   }

}

