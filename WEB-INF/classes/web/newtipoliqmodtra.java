package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newtipoliqmodtra extends GXProcedure
{
   public newtipoliqmodtra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newtipoliqmodtra.class ), "" );
   }

   public newtipoliqmodtra( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             String aP4 )
   {
      newtipoliqmodtra.this.AV8CliCod = aP0;
      newtipoliqmodtra.this.AV10TLiqCod = aP1;
      newtipoliqmodtra.this.AV9TLiqModTra = aP2;
      newtipoliqmodtra.this.AV11TLiqFrecPag = aP3;
      newtipoliqmodtra.this.AV12TLiqDescAuxFrec = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "!&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "&TLiqCod ", "")+GXutil.trim( AV10TLiqCod)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "&TLiqModTra ", "")+GXutil.trim( AV9TLiqModTra)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "&TLiqFrecPag ", "")+GXutil.trim( GXutil.str( AV11TLiqFrecPag, 1, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "&TLiqDescAuxFrec ", "")+GXutil.trim( AV12TLiqDescAuxFrec)) ;
      /*
         INSERT RECORD ON TABLE TipoLiquidacionmodo_frec

      */
      A3CliCod = AV8CliCod ;
      A32TLiqCod = AV10TLiqCod ;
      A2408TLiqModTra = AV9TLiqModTra ;
      A2412TLiqFrecPag = AV11TLiqFrecPag ;
      A2413TLiqDescAuxFrec = AV12TLiqDescAuxFrec ;
      /* Using cursor P02KZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag), A2413TLiqDescAuxFrec});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
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
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "fin", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newtipoliqmodtra");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Pgmname = "" ;
      A32TLiqCod = "" ;
      A2408TLiqModTra = "" ;
      A2413TLiqDescAuxFrec = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newtipoliqmodtra__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV15Pgmname = "newTipoLiqModTra" ;
      /* GeneXus formulas. */
      AV15Pgmname = "newTipoLiqModTra" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11TLiqFrecPag ;
   private byte A2412TLiqFrecPag ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GX_INS300 ;
   private int A3CliCod ;
   private String AV10TLiqCod ;
   private String AV9TLiqModTra ;
   private String AV15Pgmname ;
   private String A32TLiqCod ;
   private String A2408TLiqModTra ;
   private String Gx_emsg ;
   private String AV12TLiqDescAuxFrec ;
   private String A2413TLiqDescAuxFrec ;
   private IDataStoreProvider pr_default ;
}

final  class newtipoliqmodtra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02KZ2", "SAVEPOINT gxupdate;INSERT INTO TipoLiquidacionmodo_frec(CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setVarchar(5, (String)parms[4], 30, false);
               return;
      }
   }

}

