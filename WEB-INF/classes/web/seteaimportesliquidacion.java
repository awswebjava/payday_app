package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class seteaimportesliquidacion extends GXProcedure
{
   public seteaimportesliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seteaimportesliquidacion.class ), "" );
   }

   public seteaimportesliquidacion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        short aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             short aP5 )
   {
      seteaimportesliquidacion.this.AV13CliCod = aP0;
      seteaimportesliquidacion.this.AV12EmpCod = aP1;
      seteaimportesliquidacion.this.AV11LiqNro = aP2;
      seteaimportesliquidacion.this.AV10LiqImpNeto = aP3;
      seteaimportesliquidacion.this.AV9LiqImpBruto = aP4;
      seteaimportesliquidacion.this.AV8LiqCntLeg = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00OQ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8LiqCntLeg), AV9LiqImpBruto, AV10LiqImpNeto, Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      if ( false )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "compilar commit no", ""));
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
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seteaimportesliquidacion__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV8LiqCntLeg ;
   private short A495LiqCntLeg ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private java.math.BigDecimal AV10LiqImpNeto ;
   private java.math.BigDecimal AV9LiqImpBruto ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private IDataStoreProvider pr_default ;
}

final  class seteaimportesliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00OQ2", "UPDATE Liquidacion SET LiqCntLeg=?, LiqImpBruto=?, LiqImpNeto=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

