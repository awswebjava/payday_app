package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabalinks3recibo extends GXProcedure
{
   public grabalinks3recibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabalinks3recibo.class ), "" );
   }

   public grabalinks3recibo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      grabalinks3recibo.this.AV8CliCod = aP0;
      grabalinks3recibo.this.AV9EmpCod = aP1;
      grabalinks3recibo.this.AV13LiqNro = aP2;
      grabalinks3recibo.this.AV11LegNumero = aP3;
      grabalinks3recibo.this.AV12tipoRecibo = aP4;
      grabalinks3recibo.this.AV10LegLinkS3Html = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV16Pgmname, httpContext.getMessage( "&Clicod = ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( ", &EmpCod = ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( ", &LiqNro = ", "")+GXutil.trim( GXutil.str( AV13LiqNro, 8, 0))+httpContext.getMessage( ", &LegNumero = ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))+httpContext.getMessage( ", &tipoRecibo = ", "")+GXutil.trim( AV12tipoRecibo)+httpContext.getMessage( ", &LegLinkS3Html = ", "")+GXutil.trim( AV10LegLinkS3Html)) ;
      /*
         INSERT RECORD ON TABLE LiquidacionLegajoLinkPdf

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A31LiqNro = AV13LiqNro ;
      A2285LinkLegNumero = AV11LegNumero ;
      A2277LegLinkTiporec = AV12tipoRecibo ;
      A2278LegLinkS3Html = AV10LegLinkS3Html ;
      /* Using cursor P02AN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A2285LinkLegNumero), A2277LegLinkTiporec, A2278LegLinkS3Html});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajoLinkPdf");
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
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV16Pgmname, httpContext.getMessage( "fin", "")) ;
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
      AV16Pgmname = "" ;
      A2277LegLinkTiporec = "" ;
      A2278LegLinkS3Html = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabalinks3recibo__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV16Pgmname = "grabaLinkS3Recibo" ;
      /* GeneXus formulas. */
      AV16Pgmname = "grabaLinkS3Recibo" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13LiqNro ;
   private int AV11LegNumero ;
   private int GX_INS290 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A2285LinkLegNumero ;
   private String AV12tipoRecibo ;
   private String AV16Pgmname ;
   private String A2277LegLinkTiporec ;
   private String Gx_emsg ;
   private String AV10LegLinkS3Html ;
   private String A2278LegLinkS3Html ;
   private IDataStoreProvider pr_default ;
}

final  class grabalinks3recibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02AN2", "SAVEPOINT gxupdate;INSERT INTO LiquidacionLegajoLinkPdf(CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec, LegLinkS3Html) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               return;
      }
   }

}

