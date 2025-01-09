package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioadicionalimporte extends GXProcedure
{
   public newconvenioadicionalimporte( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioadicionalimporte.class ), "" );
   }

   public newconvenioadicionalimporte( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal aP5 ,
                        int aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             int aP6 )
   {
      newconvenioadicionalimporte.this.AV8CliCod = aP0;
      newconvenioadicionalimporte.this.AV10CliPaiConve = aP1;
      newconvenioadicionalimporte.this.AV9CliConvenio = aP2;
      newconvenioadicionalimporte.this.AV11ConveAdicod = aP3;
      newconvenioadicionalimporte.this.AV12ConveAdiVig = aP4;
      newconvenioadicionalimporte.this.AV13ConveAdiImporte = aP5;
      newconvenioadicionalimporte.this.AV14ConveAdiImpRelSec = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE convenio_adicionalimportes

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV10CliPaiConve ;
      A1565CliConvenio = AV9CliConvenio ;
      A996ConveAdicod = AV11ConveAdicod ;
      A999ConveAdiVig = AV12ConveAdiVig ;
      A1000ConveAdiImporte = AV13ConveAdiImporte ;
      A1899ConveAdiImpRelSec = AV14ConveAdiImpRelSec ;
      A2049ConveAdiImpOld = "" ;
      A2059ConveAdiImpRelRef = "" ;
      /* Using cursor P01PA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig, A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), A2059ConveAdiImpRelRef, A2049ConveAdiImpOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioadicionalimporte");
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
      A996ConveAdicod = "" ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A2049ConveAdiImpOld = "" ;
      A2059ConveAdiImpRelRef = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioadicionalimporte__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14ConveAdiImpRelSec ;
   private int GX_INS208 ;
   private int A3CliCod ;
   private int A1899ConveAdiImpRelSec ;
   private java.math.BigDecimal AV13ConveAdiImporte ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private String AV9CliConvenio ;
   private String AV11ConveAdicod ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String Gx_emsg ;
   private java.util.Date AV12ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private String A2049ConveAdiImpOld ;
   private String A2059ConveAdiImpRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioadicionalimporte__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01PA2", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalimportes(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, ConveAdiImpRelRef, ConveAdiImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               return;
      }
   }

}

