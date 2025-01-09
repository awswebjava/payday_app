package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcular_es_base extends GXProcedure
{
   public calcular_es_base( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcular_es_base.class ), "" );
   }

   public calcular_es_base( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              byte[] aP3 )
   {
      calcular_es_base.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte[] aP3 ,
                             boolean[] aP4 )
   {
      calcular_es_base.this.AV17CliCod = aP0;
      calcular_es_base.this.AV9DConCodigo = aP1;
      calcular_es_base.this.AV8que = aP2;
      calcular_es_base.this.aP3 = aP3;
      calcular_es_base.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV8que, httpContext.getMessage( "PRESENTISMO", "")) == 0 ) || ( GXutil.strcmp(AV8que, httpContext.getMessage( "ANTIGUEDAD", "")) == 0 ) )
      {
         GXv_int1[0] = AV10ConBaseAnt ;
         GXv_int2[0] = AV11ConBasePres ;
         new web.getconceptobaseconfpresant(remoteHandle, context).execute( AV17CliCod, AV9DConCodigo, GXv_int1, GXv_int2) ;
         calcular_es_base.this.AV10ConBaseAnt = GXv_int1[0] ;
         calcular_es_base.this.AV11ConBasePres = GXv_int2[0] ;
      }
      else
      {
         GXv_int2[0] = AV12ConBaseLic ;
         GXv_int1[0] = AV13ConBaseFer ;
         GXv_int3[0] = AV14ConBaseHorExt ;
         GXv_int4[0] = AV18ConBaseAus ;
         new web.getconceptobaseconf(remoteHandle, context).execute( AV17CliCod, AV9DConCodigo, GXv_int2, GXv_int1, GXv_int3, GXv_int4) ;
         calcular_es_base.this.AV12ConBaseLic = GXv_int2[0] ;
         calcular_es_base.this.AV13ConBaseFer = GXv_int1[0] ;
         calcular_es_base.this.AV14ConBaseHorExt = GXv_int3[0] ;
         calcular_es_base.this.AV18ConBaseAus = GXv_int4[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "DCONCODIGO ", "")+GXutil.trim( AV9DConCodigo)) ;
      if ( GXutil.strcmp(AV8que, httpContext.getMessage( "PRESENTISMO", "")) == 0 )
      {
         AV15es_base = AV11ConBasePres ;
         if ( AV11ConBasePres > 0 )
         {
            AV16agregar = true ;
         }
      }
      else
      {
         if ( GXutil.strcmp(AV8que, httpContext.getMessage( "ANTIGUEDAD", "")) == 0 )
         {
            AV15es_base = AV10ConBaseAnt ;
            if ( AV10ConBaseAnt > 0 )
            {
               AV16agregar = true ;
            }
         }
         else
         {
            if ( GXutil.strcmp(AV8que, httpContext.getMessage( "LICENCIA", "")) == 0 )
            {
               AV15es_base = AV12ConBaseLic ;
               if ( AV12ConBaseLic > 0 )
               {
                  AV16agregar = true ;
               }
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "es base de feriado", "")) ;
               if ( GXutil.strcmp(AV8que, httpContext.getMessage( "FERIADO", "")) == 0 )
               {
                  AV15es_base = AV13ConBaseFer ;
                  if ( AV13ConBaseFer > 0 )
                  {
                     AV16agregar = true ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV8que, httpContext.getMessage( "AUSENCIA", "")) == 0 )
                  {
                     AV15es_base = AV18ConBaseAus ;
                     if ( AV18ConBaseAus > 0 )
                     {
                        AV16agregar = true ;
                     }
                  }
                  else
                  {
                     AV15es_base = AV14ConBaseHorExt ;
                     if ( AV14ConBaseHorExt > 0 )
                     {
                        AV16agregar = true ;
                     }
                  }
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = calcular_es_base.this.AV15es_base;
      this.aP4[0] = calcular_es_base.this.AV16agregar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new byte[1] ;
      GXv_int1 = new byte[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      AV21Pgmname = "" ;
      AV21Pgmname = "calcular_es_base" ;
      /* GeneXus formulas. */
      AV21Pgmname = "calcular_es_base" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15es_base ;
   private byte AV10ConBaseAnt ;
   private byte AV11ConBasePres ;
   private byte AV12ConBaseLic ;
   private byte GXv_int2[] ;
   private byte AV13ConBaseFer ;
   private byte GXv_int1[] ;
   private byte AV14ConBaseHorExt ;
   private byte GXv_int3[] ;
   private byte AV18ConBaseAus ;
   private byte GXv_int4[] ;
   private short Gx_err ;
   private int AV17CliCod ;
   private String AV9DConCodigo ;
   private String AV8que ;
   private String AV21Pgmname ;
   private boolean AV16agregar ;
   private boolean[] aP4 ;
   private byte[] aP3 ;
}

