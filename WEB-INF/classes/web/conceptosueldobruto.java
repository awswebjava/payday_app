package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptosueldobruto extends GXProcedure
{
   public conceptosueldobruto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosueldobruto.class ), "" );
   }

   public conceptosueldobruto( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      conceptosueldobruto.this.aP1 = new String[] {""};
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
      conceptosueldobruto.this.AV10CliCod = aP0;
      conceptosueldobruto.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8sueldoBrutoConCodigo ;
      GXt_char2 = AV8sueldoBrutoConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      conceptosueldobruto.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      conceptosueldobruto.this.GXt_char1 = GXv_char4[0] ;
      AV8sueldoBrutoConCodigo = GXt_char1 ;
      if ( (GXutil.strcmp("", AV8sueldoBrutoConCodigo)==0) )
      {
         AV8sueldoBrutoConCodigo = httpContext.getMessage( "CAL014", "") ;
      }
      new web.codigosfijosrevisar(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = conceptosueldobruto.this.AV8sueldoBrutoConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sueldoBrutoConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8sueldoBrutoConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String[] aP1 ;
}

