package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadocategoria extends GXProcedure
{
   public empleadocategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadocategoria.class ), "" );
   }

   public empleadocategoria( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      empleadocategoria.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 )
   {
      empleadocategoria.this.AV11CliCod = aP0;
      empleadocategoria.this.AV12EmpCod = aP1;
      empleadocategoria.this.AV16LiqNro = aP2;
      empleadocategoria.this.AV8LegNumero = aP3;
      empleadocategoria.this.AV9CatCodigo = aP4;
      empleadocategoria.this.AV14ConveCodigo = aP5;
      empleadocategoria.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV13nuloPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.caracternulo(remoteHandle, context).execute( AV11CliCod, GXv_char2) ;
      empleadocategoria.this.GXt_char1 = GXv_char2[0] ;
      AV13nuloPalabra = GXt_char1 ;
      GXv_char2[0] = AV15LegCatCodigo ;
      GXv_char3[0] = "" ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV16LiqNro, AV8LegNumero, GXv_char2, GXv_char3) ;
      empleadocategoria.this.AV15LegCatCodigo = GXv_char2[0] ;
      if ( GXutil.strcmp(AV9CatCodigo, AV13nuloPalabra) == 0 )
      {
         if ( (GXutil.strcmp("", AV15LegCatCodigo)==0) )
         {
            AV10tieneCategoria = "1" ;
         }
         else
         {
            AV10tieneCategoria = "0" ;
         }
      }
      else
      {
         if ( GXutil.strcmp(AV15LegCatCodigo, AV9CatCodigo) == 0 )
         {
            AV10tieneCategoria = "1" ;
         }
         else
         {
            AV10tieneCategoria = "0" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = empleadocategoria.this.AV10tieneCategoria;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10tieneCategoria = "" ;
      AV13nuloPalabra = "" ;
      GXt_char1 = "" ;
      AV15LegCatCodigo = "" ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV16LiqNro ;
   private int AV8LegNumero ;
   private String AV9CatCodigo ;
   private String AV14ConveCodigo ;
   private String AV10tieneCategoria ;
   private String AV13nuloPalabra ;
   private String GXt_char1 ;
   private String AV15LegCatCodigo ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String[] aP6 ;
}

