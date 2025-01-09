package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condiciones_conceptoview", "/web.condiciones_conceptoview"})
public final  class condiciones_conceptoview extends GXWebObjectStub
{
   public condiciones_conceptoview( )
   {
   }

   public condiciones_conceptoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condiciones_conceptoview.class ));
   }

   public condiciones_conceptoview( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condiciones_conceptoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condiciones_conceptoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condiciones_concepto View";
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

