package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class testsumatodo extends GXProcedure
{
   public testsumatodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( testsumatodo.class ), "" );
   }

   public testsumatodo( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      testsumatodo.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
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
      testsumatodo.this.AV11CliCod = aP0;
      testsumatodo.this.AV10EmpCod = aP1;
      testsumatodo.this.AV8LegNumero = aP2;
      testsumatodo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P01NI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      c275LiqDImpCalcu = P01NI2_A275LiqDImpCalcu[0] ;
      n275LiqDImpCalcu = P01NI2_n275LiqDImpCalcu[0] ;
      pr_default.close(0);
      AV9LiqDImpCalcu = AV9LiqDImpCalcu.add(c275LiqDImpCalcu) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = testsumatodo.this.AV9LiqDImpCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqDImpCalcu = DecimalUtil.ZERO ;
      c275LiqDImpCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01NI2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NI2_n275LiqDImpCalcu = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.testsumatodo__default(),
         new Object[] {
             new Object[] {
            P01NI2_A275LiqDImpCalcu, P01NI2_n275LiqDImpCalcu
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private java.math.BigDecimal AV9LiqDImpCalcu ;
   private java.math.BigDecimal c275LiqDImpCalcu ;
   private String scmdbuf ;
   private boolean n275LiqDImpCalcu ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01NI2_A275LiqDImpCalcu ;
   private boolean[] P01NI2_n275LiqDImpCalcu ;
}

final  class testsumatodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NI2", "SELECT SUM(LiqDImpCalcu) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (DTipoConCod <> ( 'CAL_ARG')) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
      }
   }

}

