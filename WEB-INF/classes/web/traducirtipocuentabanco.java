package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirtipocuentabanco extends GXProcedure
{
   public traducirtipocuentabanco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirtipocuentabanco.class ), "" );
   }

   public traducirtipocuentabanco( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirtipocuentabanco.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirtipocuentabanco.this.AV15CliCod = aP0;
      traducirtipocuentabanco.this.AV8MigrLegBanTipCuen = aP1;
      traducirtipocuentabanco.this.aP2 = aP2;
      traducirtipocuentabanco.this.AV13errores = aP3[0];
      this.aP3 = aP3;
      traducirtipocuentabanco.this.aP4 = aP4;
      traducirtipocuentabanco.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8MigrLegBanTipCuen ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV15CliCod, GXv_char2) ;
      traducirtipocuentabanco.this.GXt_char1 = GXv_char2[0] ;
      AV8MigrLegBanTipCuen = GXutil.strReplace( AV8MigrLegBanTipCuen, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV8MigrLegBanTipCuen)==0) )
      {
         AV19GXV2 = 1 ;
         AV18GXV1 = web.gxdomaintipocuentabanco.getValues() ;
         while ( AV19GXV2 <= AV18GXV1.size() )
         {
            AV12tipoCuentaBanco = (String)AV18GXV1.elementAt(-1+AV19GXV2) ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( httpContext.getMessage( web.gxdomaintipocuentabanco.getDescription(httpContext,(String)AV12tipoCuentaBanco), ""))), GXutil.upper( GXutil.trim( AV8MigrLegBanTipCuen))) == 0 )
            {
               AV11LegBanTipCuen = AV12tipoCuentaBanco ;
               AV9encontro = true ;
               if (true) break;
            }
            if ( ! AV9encontro )
            {
               AV14tipoDeCuentaValor = AV12tipoCuentaBanco ;
               if ( GXutil.strcmp(GXutil.upper( AV14tipoDeCuentaValor), GXutil.upper( GXutil.trim( AV8MigrLegBanTipCuen))) == 0 )
               {
                  AV11LegBanTipCuen = AV12tipoCuentaBanco ;
                  AV9encontro = true ;
                  if (true) break;
               }
            }
            AV19GXV2 = (int)(AV19GXV2+1) ;
         }
         if ( ! AV9encontro )
         {
            GXt_char1 = AV10error ;
            GXv_char2[0] = GXt_char1 ;
            new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV15CliCod, httpContext.getMessage( "Tipo Cuenta Banco", ""), AV8MigrLegBanTipCuen, (short)(1), GXv_char2) ;
            traducirtipocuentabanco.this.GXt_char1 = GXv_char2[0] ;
            AV10error = GXt_char1 ;
            AV13errores.add(AV10error, 0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = traducirtipocuentabanco.this.AV11LegBanTipCuen;
      this.aP3[0] = traducirtipocuentabanco.this.AV13errores;
      this.aP4[0] = traducirtipocuentabanco.this.AV10error;
      this.aP5[0] = traducirtipocuentabanco.this.AV9encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegBanTipCuen = "" ;
      AV10error = "" ;
      AV18GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12tipoCuentaBanco = "" ;
      AV14tipoDeCuentaValor = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15CliCod ;
   private int AV19GXV2 ;
   private String AV11LegBanTipCuen ;
   private String AV12tipoCuentaBanco ;
   private String AV14tipoDeCuentaValor ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV9encontro ;
   private String AV8MigrLegBanTipCuen ;
   private String AV10error ;
   private boolean[] aP5 ;
   private String[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV18GXV1 ;
   private GXSimpleCollection<String> AV13errores ;
}

