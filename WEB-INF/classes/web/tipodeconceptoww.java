package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipodeconceptoww", "/web.tipodeconceptoww"})
public final  class tipodeconceptoww extends GXWebObjectStub
{
   public tipodeconceptoww( )
   {
   }

   public tipodeconceptoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipodeconceptoww.class ));
   }

   public tipodeconceptoww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipodeconceptoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipodeconceptoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Tipo De Concepto";
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

