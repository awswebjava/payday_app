package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class test_sueldos_1 extends GXProcedure
{
   public test_sueldos_1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( test_sueldos_1.class ), "" );
   }

   public test_sueldos_1( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<java.util.Date> aP3 ,
                        GXSimpleCollection<java.math.BigDecimal> aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<java.util.Date> aP3 ,
                             GXSimpleCollection<java.math.BigDecimal> aP4 )
   {
      test_sueldos_1.this.AV8CliCod = aP0;
      test_sueldos_1.this.AV9EmpCod = aP1;
      test_sueldos_1.this.AV10LegNumero = aP2;
      test_sueldos_1.this.AV13LegSuelFecha = aP3;
      test_sueldos_1.this.AV12LegSueldoImporte = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P01N62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
      /* End optimized DELETE. */
      AV11i = (short)(1) ;
      while ( AV11i <= AV12LegSueldoImporte.size() )
      {
         new web.newlegajo_sueldo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, (java.util.Date)AV13LegSuelFecha.elementAt(-1+AV11i), AV12LegSueldoImporte.elementAt(-1+AV11i), "Bruto") ;
         AV11i = (short)(AV11i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "test_sueldos_1");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.test_sueldos_1__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<java.math.BigDecimal> AV12LegSueldoImporte ;
   private GXSimpleCollection<java.util.Date> AV13LegSuelFecha ;
}

final  class test_sueldos_1__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01N62", "DELETE FROM legajo_sueldos  WHERE CliCod = ? and EmpCod = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

