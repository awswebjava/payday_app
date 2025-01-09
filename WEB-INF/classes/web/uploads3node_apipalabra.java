package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class uploads3node_apipalabra extends GXProcedure
{
   public uploads3node_apipalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( uploads3node_apipalabra.class ), "" );
   }

   public uploads3node_apipalabra( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      uploads3node_apipalabra.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      uploads3node_apipalabra.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = httpContext.getMessage( "uploadFileS3", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = uploads3node_apipalabra.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8palabra ;
   private String[] aP0 ;
}

