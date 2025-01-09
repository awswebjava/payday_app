package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getusulogged extends GXProcedure
{
   public getusulogged( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getusulogged.class ), "" );
   }

   public getusulogged( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      getusulogged.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      getusulogged.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8usuario = AV9websession.getValue(httpContext.getMessage( "SecUserName", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getusulogged.this.AV8usuario;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8usuario = "" ;
      AV9websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8usuario ;
   private com.genexus.webpanels.WebSession AV9websession ;
   private String[] aP0 ;
}

