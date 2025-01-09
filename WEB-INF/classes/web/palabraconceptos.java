package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class palabraconceptos extends GXProcedure
{
   public palabraconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( palabraconceptos.class ), "" );
   }

   public palabraconceptos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      palabraconceptos.this.aP1 = new String[] {""};
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
      palabraconceptos.this.AV8CliCod = aP0;
      palabraconceptos.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV8CliCod, "{conceptos}", false, true, GXv_char1) ;
      palabraconceptos.this.AV9palabra = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = palabraconceptos.this.AV9palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9palabra = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9palabra ;
   private String GXv_char1[] ;
   private String[] aP1 ;
}

