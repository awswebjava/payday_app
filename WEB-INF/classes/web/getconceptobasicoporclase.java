package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptobasicoporclase extends GXProcedure
{
   public getconceptobasicoporclase( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptobasicoporclase.class ), "" );
   }

   public getconceptobasicoporclase( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getconceptobasicoporclase.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getconceptobasicoporclase.this.AV11CliCod = aP0;
      getconceptobasicoporclase.this.AV13tipo_tarifa = aP1;
      getconceptobasicoporclase.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV13tipo_tarifa, "H") == 0 )
      {
         GXv_char1[0] = AV10ConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         getconceptobasicoporclase.this.AV10ConCodigo = GXv_char1[0] ;
         if ( (GXutil.strcmp("", AV10ConCodigo)==0) )
         {
            AV10ConCodigo = httpContext.getMessage( "REM001", "") ;
         }
      }
      else
      {
         GXv_char1[0] = AV10ConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         getconceptobasicoporclase.this.AV10ConCodigo = GXv_char1[0] ;
         if ( (GXutil.strcmp("", AV10ConCodigo)==0) )
         {
            AV10ConCodigo = httpContext.getMessage( "REM002", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptobasicoporclase.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV13tipo_tarifa ;
   private String AV10ConCodigo ;
   private String GXv_char1[] ;
   private String[] aP2 ;
}

