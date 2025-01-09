package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvecodsesion extends GXProcedure
{
   public getconvecodsesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvecodsesion.class ), "" );
   }

   public getconvecodsesion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      getconvecodsesion.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      getconvecodsesion.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ConveCodigo = AV9webSession.getValue(httpContext.getMessage( "ConveCodigo", "")) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+GXutil.trim( AV10ConveCodigo)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getconvecodsesion.this.AV10ConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConveCodigo = "" ;
      AV9webSession = httpContext.getWebSession();
      AV13Pgmname = "" ;
      AV13Pgmname = "getConveCodSesion" ;
      /* GeneXus formulas. */
      AV13Pgmname = "getConveCodSesion" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ConveCodigo ;
   private String AV13Pgmname ;
   private com.genexus.webpanels.WebSession AV9webSession ;
   private String[] aP0 ;
}

