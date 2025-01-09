package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class maternidad_descuento_descripcion_fija extends GXProcedure
{
   public maternidad_descuento_descripcion_fija( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( maternidad_descuento_descripcion_fija.class ), "" );
   }

   public maternidad_descuento_descripcion_fija( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      maternidad_descuento_descripcion_fija.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      maternidad_descuento_descripcion_fija.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ConDescrip = httpContext.getMessage( "LICENCIA POR MATERNIDAD (DESCUENTO)", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = maternidad_descuento_descripcion_fija.this.AV9ConDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConDescrip = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9ConDescrip ;
   private String[] aP0 ;
}

