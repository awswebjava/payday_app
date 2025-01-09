package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class monacocolortokenconceptos_codigoparam extends GXProcedure
{
   public monacocolortokenconceptos_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( monacocolortokenconceptos_codigoparam.class ), "" );
   }

   public monacocolortokenconceptos_codigoparam( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      monacocolortokenconceptos_codigoparam.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      monacocolortokenconceptos_codigoparam.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8parmcod = httpContext.getMessage( "monaco_colorTokenConc", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = monacocolortokenconceptos_codigoparam.this.AV8parmcod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8parmcod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8parmcod ;
   private String[] aP0 ;
}
