package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condiciones_conceptoww", "/web.condiciones_conceptoww"})
public final  class condiciones_conceptoww extends GXWebObjectStub
{
   public condiciones_conceptoww( )
   {
   }

   public condiciones_conceptoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condiciones_conceptoww.class ));
   }

   public condiciones_conceptoww( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condiciones_conceptoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condiciones_conceptoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Condiciones_concepto";
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

