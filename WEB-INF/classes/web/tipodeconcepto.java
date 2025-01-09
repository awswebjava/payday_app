package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipodeconcepto", "/web.tipodeconcepto"})
public final  class tipodeconcepto extends GXWebObjectStub
{
   public tipodeconcepto( )
   {
   }

   public tipodeconcepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipodeconcepto.class ));
   }

   public tipodeconcepto( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipodeconcepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipodeconcepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo De Concepto";
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

