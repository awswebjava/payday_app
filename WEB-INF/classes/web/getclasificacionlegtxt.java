package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclasificacionlegtxt extends GXProcedure
{
   public getclasificacionlegtxt( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclasificacionlegtxt.class ), "" );
   }

   public getclasificacionlegtxt( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getclasificacionlegtxt.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getclasificacionlegtxt.this.AV12CliCod = aP0;
      getclasificacionlegtxt.this.AV16EmpCod = aP1;
      getclasificacionlegtxt.this.AV15LegNumero = aP2;
      getclasificacionlegtxt.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV14SecCodigo ;
      GXv_char2[0] = AV8PuestoCodigo ;
      GXv_char3[0] = AV9PuestoDescrip ;
      new web.getlegajopuesto(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV15LegNumero, GXv_char1, GXv_char2, GXv_char3) ;
      getclasificacionlegtxt.this.AV14SecCodigo = GXv_char1[0] ;
      getclasificacionlegtxt.this.AV8PuestoCodigo = GXv_char2[0] ;
      getclasificacionlegtxt.this.AV9PuestoDescrip = GXv_char3[0] ;
      if ( ! (GXutil.strcmp("", AV8PuestoCodigo)==0) )
      {
         AV11Texto = GXutil.trim( AV9PuestoDescrip) ;
      }
      else
      {
         GXv_char3[0] = AV10CatCodigo ;
         GXv_char2[0] = AV17ConveCodigo ;
         new web.obtcategorialegajo(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, 0, AV15LegNumero, GXv_char3, GXv_char2) ;
         getclasificacionlegtxt.this.AV10CatCodigo = GXv_char3[0] ;
         getclasificacionlegtxt.this.AV17ConveCodigo = GXv_char2[0] ;
         if ( (GXutil.strcmp("", AV10CatCodigo)==0) )
         {
            GXt_char4 = AV11Texto ;
            GXv_char3[0] = GXt_char4 ;
            new web.textofueradeconvenio(remoteHandle, context).execute( AV12CliCod, GXv_char3) ;
            getclasificacionlegtxt.this.GXt_char4 = GXv_char3[0] ;
            AV11Texto = GXt_char4 ;
         }
         else
         {
            GXv_char3[0] = AV13CatDescrip ;
            GXv_boolean5[0] = false ;
            new web.getcategoria(remoteHandle, context).execute( AV12CliCod, AV12CliCod, AV17ConveCodigo, AV10CatCodigo, GXv_char3, GXv_boolean5) ;
            getclasificacionlegtxt.this.AV13CatDescrip = GXv_char3[0] ;
            AV11Texto = GXutil.trim( AV13CatDescrip) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getclasificacionlegtxt.this.AV11Texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Texto = "" ;
      AV14SecCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV8PuestoCodigo = "" ;
      AV9PuestoDescrip = "" ;
      AV10CatCodigo = "" ;
      AV17ConveCodigo = "" ;
      GXv_char2 = new String[1] ;
      GXt_char4 = "" ;
      AV13CatDescrip = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15LegNumero ;
   private String AV14SecCodigo ;
   private String GXv_char1[] ;
   private String AV8PuestoCodigo ;
   private String AV10CatCodigo ;
   private String AV17ConveCodigo ;
   private String GXv_char2[] ;
   private String GXt_char4 ;
   private String GXv_char3[] ;
   private boolean GXv_boolean5[] ;
   private String AV11Texto ;
   private String AV9PuestoDescrip ;
   private String AV13CatDescrip ;
   private String[] aP3 ;
}

