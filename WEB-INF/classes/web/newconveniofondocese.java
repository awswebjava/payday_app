package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconveniofondocese extends GXProcedure
{
   public newconveniofondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconveniofondocese.class ), "" );
   }

   public newconveniofondocese( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        short aP4 ,
                        short aP5 ,
                        java.math.BigDecimal aP6 ,
                        boolean aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        int aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             short aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             int aP10 )
   {
      newconveniofondocese.this.AV18CliCod = aP0;
      newconveniofondocese.this.AV17CliPaiConve = aP1;
      newconveniofondocese.this.AV16CliConvenio = aP2;
      newconveniofondocese.this.AV15CliConveVig = aP3;
      newconveniofondocese.this.AV13CliConveFondoSec = aP4;
      newconveniofondocese.this.AV14CliConveFondoMeses = aP5;
      newconveniofondocese.this.AV12CliConveFondoPrc = aP6;
      newconveniofondocese.this.AV11CliConveFondoRem = aP7;
      newconveniofondocese.this.AV10CliConveFondoNre = aP8;
      newconveniofondocese.this.AV9CliConveFondoDes = aP9;
      newconveniofondocese.this.AV8CliConveFondoRelSec = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Clientecct_fondocese

      */
      A3CliCod = AV18CliCod ;
      A1564CliPaiConve = AV17CliPaiConve ;
      A1565CliConvenio = AV16CliConvenio ;
      A1575CliConveVig = AV15CliConveVig ;
      A2147CliConveFondoSec = AV13CliConveFondoSec ;
      A2148CliConveFondoMeses = AV14CliConveFondoMeses ;
      A2150CliConveFondoPrc = AV12CliConveFondoPrc ;
      A2151CliConveFondoRem = AV11CliConveFondoRem ;
      A2152CliConveFondoNre = AV10CliConveFondoNre ;
      A2153CliConveFondoDes = AV9CliConveFondoDes ;
      A2154CliConveFondoRelSec = AV8CliConveFondoRelSec ;
      A2155CliConveFondoRelRef = "" ;
      A2156CliConveFondoOld = "" ;
      /* Using cursor P02232 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec), Short.valueOf(A2148CliConveFondoMeses), A2150CliConveFondoPrc, Boolean.valueOf(A2151CliConveFondoRem), Boolean.valueOf(A2152CliConveFondoNre), Boolean.valueOf(A2153CliConveFondoDes), Integer.valueOf(A2154CliConveFondoRelSec), A2155CliConveFondoRelRef, A2156CliConveFondoOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Clientecct_fondocese");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconveniofondocese");
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
      A1575CliConveVig = GXutil.nullDate() ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      A2155CliConveFondoRelRef = "" ;
      A2156CliConveFondoOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconveniofondocese__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17CliPaiConve ;
   private short AV13CliConveFondoSec ;
   private short AV14CliConveFondoMeses ;
   private short A1564CliPaiConve ;
   private short A2147CliConveFondoSec ;
   private short A2148CliConveFondoMeses ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV8CliConveFondoRelSec ;
   private int GX_INS271 ;
   private int A3CliCod ;
   private int A2154CliConveFondoRelSec ;
   private java.math.BigDecimal AV12CliConveFondoPrc ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private String AV16CliConvenio ;
   private String A1565CliConvenio ;
   private String Gx_emsg ;
   private java.util.Date AV15CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV11CliConveFondoRem ;
   private boolean AV10CliConveFondoNre ;
   private boolean AV9CliConveFondoDes ;
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private String A2156CliConveFondoOld ;
   private String A2155CliConveFondoRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconveniofondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02232", "SAVEPOINT gxupdate;INSERT INTO Clientecct_fondocese(CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec, CliConveFondoMeses, CliConveFondoPrc, CliConveFondoRem, CliConveFondoNre, CliConveFondoDes, CliConveFondoRelSec, CliConveFondoRelRef, CliConveFondoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setVarchar(12, (String)parms[11], 40, false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               return;
      }
   }

}

