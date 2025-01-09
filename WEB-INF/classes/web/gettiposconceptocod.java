package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettiposconceptocod extends GXProcedure
{
   public gettiposconceptocod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettiposconceptocod.class ), "" );
   }

   public gettiposconceptocod( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      gettiposconceptocod.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      gettiposconceptocod.this.AV8CliCod = aP0;
      gettiposconceptocod.this.aP1 = aP1;
      gettiposconceptocod.this.aP2 = aP2;
      gettiposconceptocod.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV9PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int1) ;
      gettiposconceptocod.this.AV9PaiCod = GXv_int1[0] ;
      GXt_char2 = AV10remuTipoConCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV9PaiCod, "REM", GXv_char3) ;
      gettiposconceptocod.this.GXt_char2 = GXv_char3[0] ;
      AV10remuTipoConCod = GXt_char2 ;
      GXt_char2 = AV11noRemuTipoConCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV9PaiCod, "NRE", GXv_char3) ;
      gettiposconceptocod.this.GXt_char2 = GXv_char3[0] ;
      AV11noRemuTipoConCod = GXt_char2 ;
      GXt_char2 = AV12descuTipoConCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV9PaiCod, "DES", GXv_char3) ;
      gettiposconceptocod.this.GXt_char2 = GXv_char3[0] ;
      AV12descuTipoConCod = GXt_char2 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gettiposconceptocod.this.AV10remuTipoConCod;
      this.aP2[0] = gettiposconceptocod.this.AV11noRemuTipoConCod;
      this.aP3[0] = gettiposconceptocod.this.AV12descuTipoConCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10remuTipoConCod = "" ;
      AV11noRemuTipoConCod = "" ;
      AV12descuTipoConCod = "" ;
      GXv_int1 = new short[1] ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV10remuTipoConCod ;
   private String AV11noRemuTipoConCod ;
   private String AV12descuTipoConCod ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String[] aP3 ;
   private String[] aP1 ;
   private String[] aP2 ;
}

