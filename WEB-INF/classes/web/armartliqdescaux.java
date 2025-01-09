package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armartliqdescaux extends GXProcedure
{
   public armartliqdescaux( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armartliqdescaux.class ), "" );
   }

   public armartliqdescaux( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 )
   {
      armartliqdescaux.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             String[] aP4 )
   {
      armartliqdescaux.this.AV9CliCod = aP0;
      armartliqdescaux.this.AV10TliqCod = aP1;
      armartliqdescaux.this.AV13TLiqModTra = aP2;
      armartliqdescaux.this.AV14TLiqFrecPag = aP3;
      armartliqdescaux.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11mensualTLiqCod ;
      GXt_char2 = AV11mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      armartliqdescaux.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      armartliqdescaux.this.GXt_char1 = GXv_char4[0] ;
      AV11mensualTLiqCod = GXt_char1 ;
      GXt_char2 = AV8TLiqDescAux ;
      GXv_char4[0] = GXt_char2 ;
      new web.gettipoliqdesc(remoteHandle, context).execute( AV9CliCod, AV10TliqCod, GXv_char4) ;
      armartliqdescaux.this.GXt_char2 = GXv_char4[0] ;
      AV8TLiqDescAux = GXt_char2 ;
      GXv_char4[0] = AV8TLiqDescAux ;
      new web.gettliqmodfrecdesc(remoteHandle, context).execute( AV9CliCod, AV10TliqCod, AV13TLiqModTra, AV14TLiqFrecPag, GXv_char4) ;
      armartliqdescaux.this.AV8TLiqDescAux = GXv_char4[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = armartliqdescaux.this.AV8TLiqDescAux;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TLiqDescAux = "" ;
      AV11mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14TLiqFrecPag ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10TliqCod ;
   private String AV13TLiqModTra ;
   private String AV11mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String AV8TLiqDescAux ;
   private String[] aP4 ;
}

