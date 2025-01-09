package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioimportes extends GXProcedure
{
   public newconvenioimportes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioimportes.class ), "" );
   }

   public newconvenioimportes( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        java.math.BigDecimal aP5 ,
                        int aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             java.math.BigDecimal aP5 ,
                             int aP6 )
   {
      newconvenioimportes.this.AV8CliCod = aP0;
      newconvenioimportes.this.AV9CliPaiConve = aP1;
      newconvenioimportes.this.AV10CliConvenio = aP2;
      newconvenioimportes.this.AV11CliConveImpVig = aP3;
      newconvenioimportes.this.AV12CliConveImpTipo = aP4;
      newconvenioimportes.this.AV13CliConveImporte = aP5;
      newconvenioimportes.this.AV14CliConveImpRelSec = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE clienteConvenio_importes

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A1587CliConveImpVig = AV11CliConveImpVig ;
      A1588CliConveImpTipo = AV12CliConveImpTipo ;
      A1589CliConveImporte = AV13CliConveImporte ;
      A1896CliConveImpRelSec = AV14CliConveImpRelSec ;
      /* Using cursor P01T92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte, Integer.valueOf(A1896CliConveImpRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
      if ( (pr_default.getStatus(0) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioimportes");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1565CliConvenio = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioimportes__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14CliConveImpRelSec ;
   private int GX_INS218 ;
   private int A3CliCod ;
   private int A1896CliConveImpRelSec ;
   private java.math.BigDecimal AV13CliConveImporte ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private String AV10CliConvenio ;
   private String AV12CliConveImpTipo ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private String Gx_emsg ;
   private java.util.Date AV11CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioimportes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01T92", "SAVEPOINT gxupdate;INSERT INTO clienteConvenio_importes(CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

