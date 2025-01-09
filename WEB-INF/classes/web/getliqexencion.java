package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqexencion extends GXProcedure
{
   public getliqexencion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqexencion.class ), "" );
   }

   public getliqexencion( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           short aP5 ,
                                           String aP6 )
   {
      getliqexencion.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        short aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             short aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      getliqexencion.this.AV11CliCod = aP0;
      getliqexencion.this.AV12EmpCod = aP1;
      getliqexencion.this.AV13LiqExAnio = aP2;
      getliqexencion.this.AV9LiqNro = aP3;
      getliqexencion.this.AV14LegNumero = aP4;
      getliqexencion.this.AV15LiqExAplIIGG = aP5;
      getliqexencion.this.AV8LiqExenConCodigo = aP6;
      getliqexencion.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P017Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV13LiqExAnio), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV14LegNumero), AV8LiqExenConCodigo, Short.valueOf(AV15LiqExAplIIGG)});
      c1126LiqExenImp = P017Q2_A1126LiqExenImp[0] ;
      pr_default.close(0);
      AV10LiqExenImp = AV10LiqExenImp.add(c1126LiqExenImp) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getliqexencion.this.AV10LiqExenImp;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqExenImp = DecimalUtil.ZERO ;
      c1126LiqExenImp = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P017Q2_A1126LiqExenImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqexencion__default(),
         new Object[] {
             new Object[] {
            P017Q2_A1126LiqExenImp
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV13LiqExAnio ;
   private short AV15LiqExAplIIGG ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV10LiqExenImp ;
   private java.math.BigDecimal c1126LiqExenImp ;
   private String AV8LiqExenConCodigo ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P017Q2_A1126LiqExenImp ;
}

final  class getliqexencion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017Q2", "SELECT SUM(LiqExenImp) FROM liquidacion_exencion WHERE CliCod = ? and EmpCod = ? and LiqExAnio = ? and LiqNro = ? and LegNumero = ? and LiqExenConCodigo = ( ?) and LiqExAplIIGG = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
      }
   }

}

