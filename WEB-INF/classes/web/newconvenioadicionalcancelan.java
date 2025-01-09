package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioadicionalcancelan extends GXProcedure
{
   public newconvenioadicionalcancelan( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioadicionalcancelan.class ), "" );
   }

   public newconvenioadicionalcancelan( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        int aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             int aP5 )
   {
      newconvenioadicionalcancelan.this.AV12CliCod = aP0;
      newconvenioadicionalcancelan.this.AV11CliPaiConve = aP1;
      newconvenioadicionalcancelan.this.AV10CliConvenio = aP2;
      newconvenioadicionalcancelan.this.AV13ConveAdicod = aP3;
      newconvenioadicionalcancelan.this.AV9ConveAdiSitCancela = aP4;
      newconvenioadicionalcancelan.this.AV8ConveAdiSitCanRelSec = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE convenio_adicionalCancela

      */
      A3CliCod = AV12CliCod ;
      A1564CliPaiConve = AV11CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A996ConveAdicod = AV13ConveAdicod ;
      A1824ConveAdiSitCancela = AV9ConveAdiSitCancela ;
      A1898ConveAdiSitCanRelSec = AV8ConveAdiSitCanRelSec ;
      A2048ConveAdiSitCanRelRef = "" ;
      A2050ConveAdiSitCanOld = "" ;
      /* Using cursor P01TA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, Integer.valueOf(A1898ConveAdiSitCanRelSec), A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioadicionalcancelan");
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
      A1824ConveAdiSitCancela = "" ;
      A2048ConveAdiSitCanRelRef = "" ;
      A2050ConveAdiSitCanOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioadicionalcancelan__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV8ConveAdiSitCanRelSec ;
   private int GX_INS245 ;
   private int A3CliCod ;
   private int A1898ConveAdiSitCanRelSec ;
   private String AV10CliConvenio ;
   private String AV13ConveAdicod ;
   private String AV9ConveAdiSitCancela ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private String Gx_emsg ;
   private String A2050ConveAdiSitCanOld ;
   private String A2048ConveAdiSitCanRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioadicionalcancelan__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01TA2", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelSec, ConveAdiSitCanRelRef, ConveAdiSitCanOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(5, (String)parms[4], 4);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
      }
   }

}

