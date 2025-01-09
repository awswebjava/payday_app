package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descripcionnovedadconceptoslarga extends GXProcedure
{
   public descripcionnovedadconceptoslarga( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descripcionnovedadconceptoslarga.class ), "" );
   }

   public descripcionnovedadconceptoslarga( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      descripcionnovedadconceptoslarga.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      descripcionnovedadconceptoslarga.this.AV9CliCod = aP0;
      descripcionnovedadconceptoslarga.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Descripcion = httpContext.getMessage( " Horas trabajadas y conceptos adicionales", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = descripcionnovedadconceptoslarga.this.AV8Descripcion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Descripcion = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8Descripcion ;
   private String[] aP1 ;
}

