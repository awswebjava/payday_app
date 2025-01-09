package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipodeconceptogeneral", "/web.tipodeconceptogeneral"})
public final  class tipodeconceptogeneral extends GXWebObjectStub
{
   public tipodeconceptogeneral( )
   {
   }

   public tipodeconceptogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipodeconceptogeneral.class ));
   }

   public tipodeconceptogeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipodeconceptogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipodeconceptogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo De Concepto General";
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

