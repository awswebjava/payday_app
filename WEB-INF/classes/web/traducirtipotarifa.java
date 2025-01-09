package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirtipotarifa extends GXProcedure
{
   public traducirtipotarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirtipotarifa.class ), "" );
   }

   public traducirtipotarifa( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int[] aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirtipotarifa.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int[] aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int[] aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirtipotarifa.this.AV10CliCod = aP0[0];
      this.aP0 = aP0;
      traducirtipotarifa.this.AV15MigrLegTipoTarifa = aP1;
      traducirtipotarifa.this.aP2 = aP2;
      traducirtipotarifa.this.AV13errores = aP3[0];
      this.aP3 = aP3;
      traducirtipotarifa.this.aP4 = aP4;
      traducirtipotarifa.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV15MigrLegTipoTarifa ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV10CliCod, GXv_char2) ;
      traducirtipotarifa.this.GXt_char1 = GXv_char2[0] ;
      AV15MigrLegTipoTarifa = GXutil.strReplace( AV15MigrLegTipoTarifa, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV15MigrLegTipoTarifa)==0) )
      {
         AV21GXV2 = 1 ;
         AV20GXV1 = web.gxdomaintipo_tarifa.getValues() ;
         while ( AV21GXV2 <= AV20GXV1.size() )
         {
            AV16tipo_tarifa = (String)AV20GXV1.elementAt(-1+AV21GXV2) ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV16tipo_tarifa), ""))), GXutil.upper( GXutil.trim( AV15MigrLegTipoTarifa))) == 0 )
            {
               AV17LegTipoTarifa = AV16tipo_tarifa ;
               AV11encontro = true ;
               if (true) break;
            }
            if ( ! AV11encontro && ( GXutil.len( GXutil.trim( AV15MigrLegTipoTarifa)) == 1 ) )
            {
               if ( GXutil.strcmp(GXutil.substring( GXutil.upper( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV16tipo_tarifa), "")), 1, 1), GXutil.upper( GXutil.trim( AV15MigrLegTipoTarifa))) == 0 )
               {
                  AV17LegTipoTarifa = AV16tipo_tarifa ;
                  AV11encontro = true ;
                  if (true) break;
               }
            }
            AV21GXV2 = (int)(AV21GXV2+1) ;
         }
         if ( ! AV11encontro )
         {
            GXt_char1 = AV12error ;
            GXv_char2[0] = GXt_char1 ;
            new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "Tipo de tarifa", ""), AV15MigrLegTipoTarifa, (short)(1), GXv_char2) ;
            traducirtipotarifa.this.GXt_char1 = GXv_char2[0] ;
            AV12error = GXt_char1 ;
            AV13errores.add(AV12error, 0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = traducirtipotarifa.this.AV10CliCod;
      this.aP2[0] = traducirtipotarifa.this.AV17LegTipoTarifa;
      this.aP3[0] = traducirtipotarifa.this.AV13errores;
      this.aP4[0] = traducirtipotarifa.this.AV12error;
      this.aP5[0] = traducirtipotarifa.this.AV11encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17LegTipoTarifa = "" ;
      AV12error = "" ;
      AV20GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16tipo_tarifa = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int AV21GXV2 ;
   private String AV17LegTipoTarifa ;
   private String AV16tipo_tarifa ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV11encontro ;
   private String AV15MigrLegTipoTarifa ;
   private String AV12error ;
   private boolean[] aP5 ;
   private int[] aP0 ;
   private String[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV20GXV1 ;
   private GXSimpleCollection<String> AV13errores ;
}

