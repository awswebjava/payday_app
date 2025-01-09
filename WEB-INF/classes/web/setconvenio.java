package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setconvenio extends GXProcedure
{
   public setconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setconvenio.class ), "" );
   }

   public setconvenio( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      setconvenio.this.AV10ConveCodigo = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8websession.setValue(httpContext.getMessage( "ConveCodigo", ""), GXutil.trim( AV10ConveCodigo));
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
      AV8websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ConveCodigo ;
   private com.genexus.webpanels.WebSession AV8websession ;
}

