package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class concepto_lsd_baseimponible4 extends GXProcedure
{
   public concepto_lsd_baseimponible4( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( concepto_lsd_baseimponible4.class ), "" );
   }

   public concepto_lsd_baseimponible4( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      concepto_lsd_baseimponible4.this.aP1 = new String[] {""};
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
      concepto_lsd_baseimponible4.this.AV9CliCod = aP0;
      concepto_lsd_baseimponible4.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8ConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "CONC_LSDBASE4", ""), GXv_char1) ;
      concepto_lsd_baseimponible4.this.AV8ConCodigo = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = concepto_lsd_baseimponible4.this.AV8ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConCodigo = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8ConCodigo ;
   private String GXv_char1[] ;
   private String[] aP1 ;
}

