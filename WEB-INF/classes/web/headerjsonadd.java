package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class headerjsonadd extends GXProcedure
{
   public headerjsonadd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( headerjsonadd.class ), "" );
   }

   public headerjsonadd( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdthttp_headers_http_headersItem> executeUdp( )
   {
      headerjsonadd.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdthttp_headers_http_headersItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP0 )
   {
      headerjsonadd.this.AV8http_headers = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9itemHeader = (web.Sdthttp_headers_http_headersItem)new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
      AV9itemHeader.setgxTv_Sdthttp_headers_http_headersItem_Name( httpContext.getMessage( "Content-Type", "") );
      AV9itemHeader.setgxTv_Sdthttp_headers_http_headersItem_Value( httpContext.getMessage( "application/json; charset=utf-8", "") );
      AV8http_headers.add(AV9itemHeader, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = headerjsonadd.this.AV8http_headers;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9itemHeader = new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP0 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV8http_headers ;
   private web.Sdthttp_headers_http_headersItem AV9itemHeader ;
}

