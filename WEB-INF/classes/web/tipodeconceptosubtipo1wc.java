package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipodeconceptosubtipo1wc", "/web.tipodeconceptosubtipo1wc"})
public final  class tipodeconceptosubtipo1wc extends GXWebObjectStub
{
   public tipodeconceptosubtipo1wc( )
   {
   }

   public tipodeconceptosubtipo1wc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipodeconceptosubtipo1wc.class ));
   }

   public tipodeconceptosubtipo1wc( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipodeconceptosubtipo1wc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipodeconceptosubtipo1wc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo De Concepto Subtipo1 WC";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

