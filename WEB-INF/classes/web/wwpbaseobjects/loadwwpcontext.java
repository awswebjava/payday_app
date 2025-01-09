package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadwwpcontext extends GXProcedure
{
   public loadwwpcontext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadwwpcontext.class ), "" );
   }

   public loadwwpcontext( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.SdtWWPContext executeUdp( )
   {
      loadwwpcontext.this.aP0 = new web.wwpbaseobjects.SdtWWPContext[] {new web.wwpbaseobjects.SdtWWPContext()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( web.wwpbaseobjects.SdtWWPContext[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPContext[] aP0 )
   {
      loadwwpcontext.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Context.fromxml(AV9Session.getValue("wwpcontext"), null, null);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = loadwwpcontext.this.AV8Context;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Context = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      AV9Session = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private web.wwpbaseobjects.SdtWWPContext[] aP0 ;
   private web.wwpbaseobjects.SdtWWPContext AV8Context ;
}

