package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdesculeydatos extends GXProcedure
{
   public getdesculeydatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdesculeydatos.class ), "" );
   }

   public getdesculeydatos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              String[] aP3 )
   {
      getdesculeydatos.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getdesculeydatos.this.AV12CliCod = aP0;
      getdesculeydatos.this.AV9idOperando = aP1;
      getdesculeydatos.this.aP2 = aP2;
      getdesculeydatos.this.aP3 = aP3;
      getdesculeydatos.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8cuotaSindicalEs = false ;
      if ( GXutil.strcmp(AV9idOperando, "[jubilacion]") == 0 )
      {
         GXt_char1 = AV10baseConCodigo ;
         GXt_char2 = AV10baseConCodigo ;
         GXv_char3[0] = GXt_char2 ;
         new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).execute( GXv_char3) ;
         getdesculeydatos.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char2, GXv_char4) ;
         getdesculeydatos.this.GXt_char1 = GXv_char4[0] ;
         AV10baseConCodigo = GXt_char1 ;
         AV11auxOpeCliId = "[apo_jub_ali]" ;
      }
      else if ( GXutil.strcmp(AV9idOperando, "[obra_social]") == 0 )
      {
         GXt_char2 = AV10baseConCodigo ;
         GXt_char1 = AV10baseConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_baseimponible4(remoteHandle, context).execute( GXv_char4) ;
         getdesculeydatos.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
         getdesculeydatos.this.GXt_char2 = GXv_char3[0] ;
         AV10baseConCodigo = GXt_char2 ;
         AV11auxOpeCliId = "[apo_OS_ali]" ;
      }
      else if ( GXutil.strcmp(AV9idOperando, "[ley_19032]") == 0 )
      {
         GXt_char2 = AV10baseConCodigo ;
         GXt_char1 = AV10baseConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_baseimponible5(remoteHandle, context).execute( GXv_char4) ;
         getdesculeydatos.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
         getdesculeydatos.this.GXt_char2 = GXv_char3[0] ;
         AV10baseConCodigo = GXt_char2 ;
         AV11auxOpeCliId = "[apo_INSSJyP_ali]" ;
      }
      else
      {
         GXt_char2 = AV10baseConCodigo ;
         GXt_char1 = AV10baseConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).execute( GXv_char4) ;
         getdesculeydatos.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
         getdesculeydatos.this.GXt_char2 = GXv_char3[0] ;
         AV10baseConCodigo = GXt_char2 ;
         AV11auxOpeCliId = "" ;
         AV8cuotaSindicalEs = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdesculeydatos.this.AV10baseConCodigo;
      this.aP3[0] = getdesculeydatos.this.AV11auxOpeCliId;
      this.aP4[0] = getdesculeydatos.this.AV8cuotaSindicalEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10baseConCodigo = "" ;
      AV11auxOpeCliId = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12CliCod ;
   private String AV9idOperando ;
   private String AV10baseConCodigo ;
   private String AV11auxOpeCliId ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private boolean AV8cuotaSindicalEs ;
   private boolean[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
}

