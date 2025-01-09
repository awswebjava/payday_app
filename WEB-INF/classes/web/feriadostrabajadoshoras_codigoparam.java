package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriadostrabajadoshoras_codigoparam extends GXProcedure
{
   public feriadostrabajadoshoras_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriadostrabajadoshoras_codigoparam.class ), "" );
   }

   public feriadostrabajadoshoras_codigoparam( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      feriadostrabajadoshoras_codigoparam.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      feriadostrabajadoshoras_codigoparam.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ParmCod = httpContext.getMessage( "CONC_FERIA_TRAB_HOR", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = feriadostrabajadoshoras_codigoparam.this.AV8ParmCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ParmCod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ParmCod ;
   private String[] aP0 ;
}

