package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustarordenconceptos extends GXProcedure
{
   public ajustarordenconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustarordenconceptos.class ), "" );
   }

   public ajustarordenconceptos( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      ajustarordenconceptos.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV15LiquidaSACConCodigo ;
      GXt_char2 = AV15LiquidaSACConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      AV15LiquidaSACConCodigo = GXt_char1 ;
      GXt_char2 = AV16sueldoBrutoConCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.conceptosueldobruto(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char4[0] ;
      AV16sueldoBrutoConCodigo = GXt_char2 ;
      GXt_char2 = AV17sueldoBrutoSinSacConCodigo ;
      GXt_char1 = AV17sueldoBrutoSinSacConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV17sueldoBrutoSinSacConCodigo = GXt_char2 ;
      GXt_char2 = AV18AlcanzaGananciasConCodigo ;
      GXt_char1 = AV18AlcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV18AlcanzaGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV19SueldoBrutoPromUltTramoConCodigo ;
      GXt_char1 = AV19SueldoBrutoPromUltTramoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_brutopromedio_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV19SueldoBrutoPromUltTramoConCodigo = GXt_char2 ;
      GXt_char2 = AV20SueldoBrutoGananciaMinimoConCodigo ;
      GXt_char1 = AV20SueldoBrutoGananciaMinimoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_brutoimponible_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV20SueldoBrutoGananciaMinimoConCodigo = GXt_char2 ;
      GXt_char2 = AV21SACConCodigo ;
      GXt_char1 = AV21SACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV21SACConCodigo = GXt_char2 ;
      GXt_char2 = AV22SACProporConCodigo ;
      GXt_char1 = AV22SACProporConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV22SACProporConCodigo = GXt_char2 ;
      GXt_char2 = AV23haberesSACConCodigo ;
      GXt_char1 = AV23haberesSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_haberessac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV23haberesSACConCodigo = GXt_char2 ;
      GXt_char2 = AV24calculoSACConCodigo ;
      GXt_char1 = AV24calculoSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_calculosac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV24calculoSACConCodigo = GXt_char2 ;
      GXt_char2 = AV25devolucionGananciasConCodigo ;
      GXt_char1 = AV25devolucionGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_devolucionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV25devolucionGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV67topeDiasConCodigo ;
      GXt_char1 = AV67topeDiasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV67topeDiasConCodigo = GXt_char2 ;
      GXt_char2 = AV70topeDiasSACConCodigo ;
      GXt_char1 = AV70topeDiasSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_diasproporsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV70topeDiasSACConCodigo = GXt_char2 ;
      GXt_char2 = AV32retencionGananciasConCodigo ;
      GXt_char1 = AV32retencionGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV32retencionGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV26importeARetenerConCodigo ;
      GXt_char1 = AV26importeARetenerConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.importearetener_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV26importeARetenerConCodigo = GXt_char2 ;
      GXt_char2 = AV27sueldoBrutoMenosDescuentosDeLeyConCodigo ;
      GXt_char1 = AV27sueldoBrutoMenosDescuentosDeLeyConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldobrutomenosley_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV27sueldoBrutoMenosDescuentosDeLeyConCodigo = GXt_char2 ;
      GXt_char2 = AV28calculoRetencionGananciasConCodigo ;
      GXt_char1 = AV28calculoRetencionGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.retencionbruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV28calculoRetencionGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV29pagosACuentaConCodigo ;
      GXt_char1 = AV29pagosACuentaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV29pagosACuentaConCodigo = GXt_char2 ;
      GXt_char2 = AV31gananciasFormulaAFIPConCodigo ;
      GXt_char1 = AV31gananciasFormulaAFIPConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.gananciasformulaafip_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV31gananciasFormulaAFIPConCodigo = GXt_char2 ;
      GXt_char2 = AV34otroEmplhorasExtrasGravadasCodigo ;
      GXt_char1 = AV34otroEmplhorasExtrasGravadasCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroemplhorasextrasgravadas_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV34otroEmplhorasExtrasGravadasCodigo = GXt_char2 ;
      GXt_char2 = AV35gnsiConCodigo ;
      GXt_char1 = AV35gnsiConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.gannetsujimpmenosdedinc_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV35gnsiConCodigo = GXt_char2 ;
      GXt_char2 = AV36gnsiSinDeiConCodigo ;
      GXt_char1 = AV36gnsiSinDeiConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.gannetsujimp_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV36gnsiSinDeiConCodigo = GXt_char2 ;
      GXt_char2 = AV37dedEspIncConcodigo ;
      GXt_char1 = AV37dedEspIncConcodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_deduccionespecialincrementada_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV37dedEspIncConcodigo = GXt_char2 ;
      GXt_char2 = AV38gananciaNetaConCodigo ;
      GXt_char1 = AV38gananciaNetaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.ganancianeta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV38gananciaNetaConCodigo = GXt_char2 ;
      GXt_char2 = AV39dedArt30ConCodigo ;
      GXt_char1 = AV39dedArt30ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.dedart30_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV39dedArt30ConCodigo = GXt_char2 ;
      GXt_char2 = AV40dedGralAnuConCodigo ;
      GXt_char1 = AV40dedGralAnuConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_dedgeneralesanualesparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV40dedGralAnuConCodigo = GXt_char2 ;
      GXt_char2 = AV41remuneracionGravadaConCodigo ;
      GXt_char1 = AV41remuneracionGravadaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.remuneraciongravada_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV41remuneracionGravadaConCodigo = GXt_char2 ;
      GXt_char2 = AV42otrosEmpleosRemuGravadaConCodigo ;
      GXt_char1 = AV42otrosEmpleosRemuGravadaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroemplremugrav_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV42otrosEmpleosRemuGravadaConCodigo = GXt_char2 ;
      GXt_char2 = AV43dedGralMensConCodigo ;
      GXt_char1 = AV43dedGralMensConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.dedgenmens_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV43dedGralMensConCodigo = GXt_char2 ;
      GXt_char2 = AV46suelBruSinSacMasBonoConCodigo ;
      GXt_char1 = AV46suelBruSinSacMasBonoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldobrutogravado_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV46suelBruSinSacMasBonoConCodigo = GXt_char2 ;
      GXt_char2 = AV47anticipoDeSacConCodigo ;
      GXt_char1 = AV47anticipoDeSacConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV47anticipoDeSacConCodigo = GXt_char2 ;
      GXt_char2 = AV33horasExtrasExentasConCodigo ;
      GXt_char1 = AV33horasExtrasExentasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_horasextrasexentas_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV33horasExtrasExentasConCodigo = GXt_char2 ;
      GXt_char2 = AV48MovViaExenConCodigo ;
      GXt_char1 = AV48MovViaExenConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_movviaexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV48MovViaExenConCodigo = GXt_char2 ;
      GXt_char2 = AV55sacExentoConCodigo ;
      GXt_char1 = AV55sacExentoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacexento_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV55sacExentoConCodigo = GXt_char2 ;
      GXt_char2 = AV59sacGravadoConCodigo ;
      GXt_char1 = AV59sacGravadoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacgravado_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV59sacGravadoConCodigo = GXt_char2 ;
      GXt_char2 = AV49DocenteExenConCodigo ;
      GXt_char1 = AV49DocenteExenConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_perdocmatexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV49DocenteExenConCodigo = GXt_char2 ;
      GXt_char2 = AV51DescuContemplaSACConCOdigo ;
      GXt_char1 = AV51DescuContemplaSACConCOdigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_descuentosleymasdescsobreanticiposac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV51DescuContemplaSACConCOdigo = GXt_char2 ;
      GXt_char2 = AV58DescuNoContemplaSACConCOdigo ;
      GXt_char1 = AV58DescuNoContemplaSACConCOdigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_descuentossobregravados_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV58DescuNoContemplaSACConCOdigo = GXt_char2 ;
      GXt_char2 = AV52bonosExentosConCodigo ;
      GXt_char1 = AV52bonosExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV52bonosExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV60fallosCajaExentosConCodigo ;
      GXt_char1 = AV60fallosCajaExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_falloscajaexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV60fallosCajaExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV61simNatExentosConCodigo ;
      GXt_char1 = AV61simNatExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_simnatexenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV61simNatExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV53calculoSacProximoEstimadoConCodigo ;
      GXt_char1 = AV53calculoSacProximoEstimadoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacproximo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV53calculoSacProximoEstimadoConCodigo = GXt_char2 ;
      GXt_char2 = AV54sacLiquidadoPeriodoConCodigo ;
      GXt_char1 = AV54sacLiquidadoPeriodoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacliquidadoperiodo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV54sacLiquidadoPeriodoConCodigo = GXt_char2 ;
      GXt_char2 = AV56otrosEmpleosGanBruConCodigo ;
      GXt_char1 = AV56otrosEmpleosGanBruConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV56otrosEmpleosGanBruConCodigo = GXt_char2 ;
      GXt_char2 = AV57otrosEmpleosSacConCodigo ;
      GXt_char1 = AV57otrosEmpleosSacConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroemplsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV57otrosEmpleosSacConCodigo = GXt_char2 ;
      GXt_char2 = AV76horasNormalesConCodigo ;
      GXt_char1 = AV76horasNormalesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV76horasNormalesConCodigo = GXt_char2 ;
      GXt_char2 = AV77sueldoConCodigo ;
      GXt_char1 = AV77sueldoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
      AV77sueldoConCodigo = GXt_char2 ;
      /* Using cursor P00U12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P00U12_A37TipoConCod[0] ;
         A3CliCod = P00U12_A3CliCod[0] ;
         A895ConTipoOrden = P00U12_A895ConTipoOrden[0] ;
         A26ConCodigo = P00U12_A26ConCodigo[0] ;
         A510ConOrdEjec = P00U12_A510ConOrdEjec[0] ;
         A41ConDescrip = P00U12_A41ConDescrip[0] ;
         A895ConTipoOrden = (short)(1) ;
         if ( ( GXutil.strcmp(A26ConCodigo, AV21SACConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV22SACProporConCodigo) == 0 ) )
         {
            A510ConOrdEjec = 3200000 ;
         }
         else
         {
            GXt_char2 = AV62MaternidadConCodigo ;
            GXt_char1 = AV62MaternidadConCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.concepto_licenciapormaternidad_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
            ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
            AV62MaternidadConCodigo = GXt_char2 ;
            GXt_char2 = AV63MaternidadDescuentoConCodigo ;
            GXt_char1 = AV63MaternidadDescuentoConCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.concepto_licenciapormaterdescu_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            ajustarordenconceptos.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
            ajustarordenconceptos.this.GXt_char2 = GXv_char3[0] ;
            AV63MaternidadDescuentoConCodigo = GXt_char2 ;
            if ( ( GXutil.strcmp(A26ConCodigo, AV62MaternidadConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV63MaternidadDescuentoConCodigo) == 0 ) )
            {
               A510ConOrdEjec = 4010000 ;
            }
            else
            {
               if ( ( GXutil.strcmp(A26ConCodigo, AV76horasNormalesConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV77sueldoConCodigo) == 0 ) )
               {
                  A510ConOrdEjec = (long)(2000000-3) ;
               }
               else
               {
                  if ( GXutil.strSearch( GXutil.upper( A41ConDescrip), httpContext.getMessage( "HORAS EXTRAS", ""), 1) != 0 )
                  {
                     A510ConOrdEjec = (long)(2000000-2) ;
                  }
                  else
                  {
                     if ( ( GXutil.strSearch( GXutil.upper( A41ConDescrip), httpContext.getMessage( "FERIADOS", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( A41ConDescrip), httpContext.getMessage( "NO LABORA", ""), 1) != 0 ) )
                     {
                        A510ConOrdEjec = (long)(2000000-1) ;
                     }
                     else
                     {
                        A510ConOrdEjec = 2000000 ;
                     }
                  }
               }
            }
         }
         /* Using cursor P00U13 */
         pr_default.execute(1, new Object[] {Short.valueOf(A895ConTipoOrden), Long.valueOf(A510ConOrdEjec), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P00U14 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A37TipoConCod = P00U14_A37TipoConCod[0] ;
         A3CliCod = P00U14_A3CliCod[0] ;
         A895ConTipoOrden = P00U14_A895ConTipoOrden[0] ;
         A26ConCodigo = P00U14_A26ConCodigo[0] ;
         A510ConOrdEjec = P00U14_A510ConOrdEjec[0] ;
         A895ConTipoOrden = (short)(2) ;
         if ( GXutil.strcmp(A26ConCodigo, AV25devolucionGananciasConCodigo) != 0 )
         {
            A510ConOrdEjec = 2000000 ;
         }
         else
         {
            A510ConOrdEjec = 5200000 ;
         }
         /* Using cursor P00U15 */
         pr_default.execute(3, new Object[] {Short.valueOf(A895ConTipoOrden), Long.valueOf(A510ConOrdEjec), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /* Using cursor P00U16 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A37TipoConCod = P00U16_A37TipoConCod[0] ;
         A3CliCod = P00U16_A3CliCod[0] ;
         A895ConTipoOrden = P00U16_A895ConTipoOrden[0] ;
         A38SubTipoConCod1 = P00U16_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00U16_n38SubTipoConCod1[0] ;
         A510ConOrdEjec = P00U16_A510ConOrdEjec[0] ;
         A26ConCodigo = P00U16_A26ConCodigo[0] ;
         A895ConTipoOrden = (short)(3) ;
         GXv_boolean5[0] = AV30SubTDescuLey ;
         new web.gettipodescuentoley(remoteHandle, context).execute( A37TipoConCod, A38SubTipoConCod1, GXv_boolean5) ;
         ajustarordenconceptos.this.AV30SubTDescuLey = GXv_boolean5[0] ;
         if ( AV30SubTDescuLey )
         {
            A510ConOrdEjec = 4180000 ;
         }
         else
         {
            if ( ( GXutil.strcmp(A26ConCodigo, AV32retencionGananciasConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV25devolucionGananciasConCodigo) == 0 ) )
            {
               A510ConOrdEjec = 5100000 ;
            }
            else
            {
               A510ConOrdEjec = 5000000 ;
            }
         }
         /* Using cursor P00U17 */
         pr_default.execute(5, new Object[] {Short.valueOf(A895ConTipoOrden), Long.valueOf(A510ConOrdEjec), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(4);
      }
      pr_default.close(4);
      /* Using cursor P00U18 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A37TipoConCod = P00U18_A37TipoConCod[0] ;
         A3CliCod = P00U18_A3CliCod[0] ;
         A895ConTipoOrden = P00U18_A895ConTipoOrden[0] ;
         A26ConCodigo = P00U18_A26ConCodigo[0] ;
         A38SubTipoConCod1 = P00U18_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00U18_n38SubTipoConCod1[0] ;
         A510ConOrdEjec = P00U18_A510ConOrdEjec[0] ;
         A39SubTipoConCod2 = P00U18_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P00U18_n39SubTipoConCod2[0] ;
         A895ConTipoOrden = (short)(4) ;
         if ( ( GXutil.strcmp(A38SubTipoConCod1, new web.subtipocalculobaseimp(remoteHandle, context).executeUdp( )) == 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( A26ConCodigo)), GXutil.upper( GXutil.trim( AV67topeDiasConCodigo))) != 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            A510ConOrdEjec = 4100000 ;
         }
         else
         {
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( A26ConCodigo)), GXutil.upper( GXutil.trim( AV23haberesSACConCodigo))) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A26ConCodigo)), GXutil.upper( GXutil.trim( AV67topeDiasConCodigo))) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A26ConCodigo)), GXutil.upper( GXutil.trim( AV70topeDiasSACConCodigo))) == 0 ) )
            {
               A510ConOrdEjec = 3000000 ;
            }
            else
            {
               if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A26ConCodigo)), GXutil.upper( GXutil.trim( AV24calculoSACConCodigo))) == 0 )
               {
                  A510ConOrdEjec = 3100000 ;
               }
               else
               {
                  if ( GXutil.strcmp(A26ConCodigo, AV15LiquidaSACConCodigo) == 0 )
                  {
                     A510ConOrdEjec = 1000000 ;
                  }
                  else
                  {
                     if ( ( GXutil.strcmp(A26ConCodigo, AV56otrosEmpleosGanBruConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV57otrosEmpleosSacConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV16sueldoBrutoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV17sueldoBrutoSinSacConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV19SueldoBrutoPromUltTramoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV20SueldoBrutoGananciaMinimoConCodigo) == 0 ) )
                     {
                        if ( ( GXutil.strcmp(A26ConCodigo, AV56otrosEmpleosGanBruConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV57otrosEmpleosSacConCodigo) == 0 ) )
                        {
                           A510ConOrdEjec = 3950000 ;
                        }
                        else
                        {
                           A510ConOrdEjec = 4000000 ;
                        }
                     }
                     else
                     {
                        if ( ( GXutil.strcmp(A26ConCodigo, AV26importeARetenerConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV27sueldoBrutoMenosDescuentosDeLeyConCodigo) == 0 ) )
                        {
                           A510ConOrdEjec = 4900000 ;
                        }
                        else
                        {
                           if ( ( GXutil.strcmp(A26ConCodigo, AV28calculoRetencionGananciasConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV29pagosACuentaConCodigo) == 0 ) )
                           {
                              A510ConOrdEjec = 4800000 ;
                           }
                           else
                           {
                              if ( GXutil.strcmp(A26ConCodigo, AV31gananciasFormulaAFIPConCodigo) == 0 )
                              {
                                 A510ConOrdEjec = 4700000 ;
                              }
                              else
                              {
                                 if ( ( GXutil.strcmp(A26ConCodigo, AV34otroEmplhorasExtrasGravadasCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV35gnsiConCodigo) == 0 ) )
                                 {
                                    A510ConOrdEjec = 4600000 ;
                                 }
                                 else
                                 {
                                    if ( ( GXutil.strcmp(A26ConCodigo, AV36gnsiSinDeiConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV37dedEspIncConcodigo) == 0 ) )
                                    {
                                       A510ConOrdEjec = 4500000 ;
                                    }
                                    else
                                    {
                                       if ( ( GXutil.strcmp(A26ConCodigo, AV38gananciaNetaConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV39dedArt30ConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV40dedGralAnuConCodigo) == 0 ) )
                                       {
                                          A510ConOrdEjec = 4400000 ;
                                       }
                                       else
                                       {
                                          if ( ( GXutil.strcmp(A26ConCodigo, AV41remuneracionGravadaConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV42otrosEmpleosRemuGravadaConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV43dedGralMensConCodigo) == 0 ) || ( GXutil.strcmp(A39SubTipoConCod2, new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).executeUdp( )) == 0 ) )
                                          {
                                             Cond_result = true ;
                                          }
                                          else
                                          {
                                             Cond_result = false ;
                                          }
                                          if ( Cond_result )
                                          {
                                             A510ConOrdEjec = 4300000 ;
                                          }
                                          else
                                          {
                                             if ( ( GXutil.strcmp(A26ConCodigo, AV46suelBruSinSacMasBonoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV47anticipoDeSacConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV33horasExtrasExentasConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV51DescuContemplaSACConCOdigo) == 0 ) || ( GXutil.strcmp(A39SubTipoConCod2, new web.subtipo2deduccionesgenerales(remoteHandle, context).executeUdp( )) == 0 ) )
                                             {
                                                Cond_result = true ;
                                             }
                                             else
                                             {
                                                Cond_result = false ;
                                             }
                                             if ( Cond_result )
                                             {
                                                if ( ( GXutil.strcmp(A26ConCodigo, AV33horasExtrasExentasConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV46suelBruSinSacMasBonoConCodigo) == 0 ) )
                                                {
                                                   A510ConOrdEjec = 4180000 ;
                                                }
                                                else
                                                {
                                                   A510ConOrdEjec = 4200000 ;
                                                }
                                             }
                                             else
                                             {
                                                if ( ( GXutil.strcmp(A26ConCodigo, AV59sacGravadoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV52bonosExentosConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV53calculoSacProximoEstimadoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV54sacLiquidadoPeriodoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV55sacExentoConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV48MovViaExenConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV49DocenteExenConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV60fallosCajaExentosConCodigo) == 0 ) || ( GXutil.strcmp(A26ConCodigo, AV61simNatExentosConCodigo) == 0 ) )
                                                {
                                                   A510ConOrdEjec = 4100000 ;
                                                }
                                                else
                                                {
                                                   if ( GXutil.strcmp(A26ConCodigo, AV18AlcanzaGananciasConCodigo) == 0 )
                                                   {
                                                      GXt_int6 = A510ConOrdEjec ;
                                                      GXv_int7[0] = GXt_int6 ;
                                                      new web.ordenejecalcanzaganancias(remoteHandle, context).execute( GXv_int7) ;
                                                      ajustarordenconceptos.this.GXt_int6 = GXv_int7[0] ;
                                                      A510ConOrdEjec = GXt_int6 ;
                                                   }
                                                   else
                                                   {
                                                      if ( GXutil.strcmp(A26ConCodigo, AV58DescuNoContemplaSACConCOdigo) == 0 )
                                                      {
                                                         A510ConOrdEjec = 4190000 ;
                                                      }
                                                      else
                                                      {
                                                         A510ConOrdEjec = 5300000 ;
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
         /* Using cursor P00U19 */
         pr_default.execute(7, new Object[] {Short.valueOf(A895ConTipoOrden), Long.valueOf(A510ConOrdEjec), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(6);
      }
      pr_default.close(6);
      GXv_int8[0] = AV10Intervalo ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int8) ;
      ajustarordenconceptos.this.AV10Intervalo = (short)((short)(GXv_int8[0])) ;
      AV9ConOrden = 0 ;
      /* Using cursor P00U110 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A3CliCod = P00U110_A3CliCod[0] ;
         A40ConOrden = P00U110_A40ConOrden[0] ;
         A41ConDescrip = P00U110_A41ConDescrip[0] ;
         A37TipoConCod = P00U110_A37TipoConCod[0] ;
         A922ConUsado = P00U110_A922ConUsado[0] ;
         A26ConCodigo = P00U110_A26ConCodigo[0] ;
         A895ConTipoOrden = P00U110_A895ConTipoOrden[0] ;
         A40ConOrden = AV9ConOrden ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "CÁLCULO SAC PRÓXIMO ESTIMADO", "")) == 0 )
         {
            AV64sacproximoestimadoConOrden = A40ConOrden ;
         }
         AV9ConOrden = (int)(AV9ConOrden+AV10Intervalo) ;
         GXt_boolean9 = AV14esConceptoImprimible ;
         GXv_boolean5[0] = GXt_boolean9 ;
         new web.esconceptoimprimible(remoteHandle, context).execute( A37TipoConCod, GXv_boolean5) ;
         ajustarordenconceptos.this.GXt_boolean9 = GXv_boolean5[0] ;
         AV14esConceptoImprimible = GXt_boolean9 ;
         if ( AV14esConceptoImprimible )
         {
            A922ConUsado = true ;
         }
         else
         {
            GXv_boolean5[0] = AV13seUsa ;
            GXv_boolean10[0] = false ;
            GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem11[0] = AV12sdt_conceptos ;
            GXv_boolean12[0] = false ;
            new web.analizarconceptosuso(remoteHandle, context).execute( A3CliCod, (short)(0), 0, 0, A26ConCodigo, AV66TipoConCod, httpContext.getMessage( "TODOS", ""), true, true, false, GXv_boolean5, GXv_boolean10, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem11, GXv_boolean12) ;
            ajustarordenconceptos.this.AV13seUsa = GXv_boolean5[0] ;
            AV12sdt_conceptos = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem11[0] ;
            if ( AV13seUsa )
            {
               A922ConUsado = true ;
            }
         }
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "VACACIONES", "")) == 0 )
         {
            AV68vacConOrden = A40ConOrden ;
         }
         else
         {
            if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 )
            {
               AV69descuConOrden = A40ConOrden ;
            }
            else
            {
               if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 )
               {
                  AV74feriadoOrden = (short)(A40ConOrden) ;
               }
               else
               {
                  if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "NO LABORABLES NO TRABAJADOS", "")) == 0 )
                  {
                     AV75noLaboralOrden = (short)(A40ConOrden) ;
                  }
               }
            }
         }
         /* Using cursor P00U111 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A40ConOrden), Boolean.valueOf(A922ConUsado), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(8);
      }
      pr_default.close(8);
      /* Using cursor P00U112 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A3CliCod = P00U112_A3CliCod[0] ;
         A41ConDescrip = P00U112_A41ConDescrip[0] ;
         A40ConOrden = P00U112_A40ConOrden[0] ;
         A26ConCodigo = P00U112_A26ConCodigo[0] ;
         if ( GXutil.like( A41ConDescrip , GXutil.padr( httpContext.getMessage( "LICENCIA POR", "") , 400 , "%"),  ' ' ) )
         {
            AV73ultimaLicencia = (short)(A40ConOrden) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(10);
      }
      pr_default.close(10);
      GXt_char2 = AV65SAClIQCondescrip ;
      GXv_char4[0] = GXt_char2 ;
      new web.sacliquidadoperiodo(remoteHandle, context).execute( GXv_char4) ;
      ajustarordenconceptos.this.GXt_char2 = GXv_char4[0] ;
      AV65SAClIQCondescrip = GXt_char2 ;
      /* Using cursor P00U113 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV8CliCod), AV65SAClIQCondescrip});
      while ( (pr_default.getStatus(11) != 101) )
      {
         A41ConDescrip = P00U113_A41ConDescrip[0] ;
         A3CliCod = P00U113_A3CliCod[0] ;
         A40ConOrden = P00U113_A40ConOrden[0] ;
         A26ConCodigo = P00U113_A26ConCodigo[0] ;
         A40ConOrden = (int)(AV64sacproximoestimadoConOrden-1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00U114 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         if (true) break;
         /* Using cursor P00U115 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(11);
      }
      pr_default.close(11);
      /* Using cursor P00U116 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A41ConDescrip = P00U116_A41ConDescrip[0] ;
         A3CliCod = P00U116_A3CliCod[0] ;
         A40ConOrden = P00U116_A40ConOrden[0] ;
         A26ConCodigo = P00U116_A26ConCodigo[0] ;
         if ( ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "VACACIONES", "")) == 0 ) || ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 ) )
         {
            if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "VACACIONES", "")) == 0 )
            {
               A40ConOrden = AV69descuConOrden ;
            }
            else
            {
               A40ConOrden = AV68vacConOrden ;
            }
            /* Using cursor P00U117 */
            pr_default.execute(15, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         }
         pr_default.readNext(14);
      }
      pr_default.close(14);
      /* Using cursor P00U118 */
      pr_default.execute(16, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(16) != 101) )
      {
         A41ConDescrip = P00U118_A41ConDescrip[0] ;
         A3CliCod = P00U118_A3CliCod[0] ;
         A40ConOrden = P00U118_A40ConOrden[0] ;
         A26ConCodigo = P00U118_A26ConCodigo[0] ;
         if ( ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR VACACIONES", "")) == 0 ) || ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR LICENCIA", "")) == 0 ) || ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR FERIADO", "")) == 0 ) || ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR NO LABORABLES", "")) == 0 ) )
         {
            if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR VACACIONES", "")) == 0 )
            {
               A40ConOrden = (int)(AV68vacConOrden+1) ;
            }
            else
            {
               if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR LICENCIA", "")) == 0 )
               {
                  A40ConOrden = (int)(AV73ultimaLicencia+1) ;
               }
               else
               {
                  if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DIAS NO TRABAJADOS POR FERIADO", "")) == 0 )
                  {
                     A40ConOrden = (int)(AV74feriadoOrden+1) ;
                  }
                  else
                  {
                     A40ConOrden = (int)(AV75noLaboralOrden+1) ;
                  }
               }
            }
            /* Using cursor P00U119 */
            pr_default.execute(17, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         }
         pr_default.readNext(16);
      }
      pr_default.close(16);
      /* Using cursor P00U120 */
      pr_default.execute(18, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(18) != 101) )
      {
         A3CliCod = P00U120_A3CliCod[0] ;
         A1471ConNumero = P00U120_A1471ConNumero[0] ;
         A26ConCodigo = P00U120_A26ConCodigo[0] ;
         AV71ConNumero = (byte)(AV71ConNumero+1) ;
         A1471ConNumero = AV71ConNumero ;
         /* Using cursor P00U121 */
         pr_default.execute(19, new Object[] {Byte.valueOf(A1471ConNumero), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(18);
      }
      pr_default.close(18);
      AV72ConOrdEjec = 0 ;
      /* Using cursor P00U122 */
      pr_default.execute(20, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(20) != 101) )
      {
         A3CliCod = P00U122_A3CliCod[0] ;
         A40ConOrden = P00U122_A40ConOrden[0] ;
         A510ConOrdEjec = P00U122_A510ConOrdEjec[0] ;
         A26ConCodigo = P00U122_A26ConCodigo[0] ;
         AV72ConOrdEjec = (long)(AV72ConOrdEjec+1) ;
         A510ConOrdEjec = AV72ConOrdEjec ;
         /* Using cursor P00U123 */
         pr_default.execute(21, new Object[] {Long.valueOf(A510ConOrdEjec), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(20);
      }
      pr_default.close(20);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ajustarordenconceptos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LiquidaSACConCodigo = "" ;
      AV16sueldoBrutoConCodigo = "" ;
      AV17sueldoBrutoSinSacConCodigo = "" ;
      AV18AlcanzaGananciasConCodigo = "" ;
      AV19SueldoBrutoPromUltTramoConCodigo = "" ;
      AV20SueldoBrutoGananciaMinimoConCodigo = "" ;
      AV21SACConCodigo = "" ;
      AV22SACProporConCodigo = "" ;
      AV23haberesSACConCodigo = "" ;
      AV24calculoSACConCodigo = "" ;
      AV25devolucionGananciasConCodigo = "" ;
      AV67topeDiasConCodigo = "" ;
      AV70topeDiasSACConCodigo = "" ;
      AV32retencionGananciasConCodigo = "" ;
      AV26importeARetenerConCodigo = "" ;
      AV27sueldoBrutoMenosDescuentosDeLeyConCodigo = "" ;
      AV28calculoRetencionGananciasConCodigo = "" ;
      AV29pagosACuentaConCodigo = "" ;
      AV31gananciasFormulaAFIPConCodigo = "" ;
      AV34otroEmplhorasExtrasGravadasCodigo = "" ;
      AV35gnsiConCodigo = "" ;
      AV36gnsiSinDeiConCodigo = "" ;
      AV37dedEspIncConcodigo = "" ;
      AV38gananciaNetaConCodigo = "" ;
      AV39dedArt30ConCodigo = "" ;
      AV40dedGralAnuConCodigo = "" ;
      AV41remuneracionGravadaConCodigo = "" ;
      AV42otrosEmpleosRemuGravadaConCodigo = "" ;
      AV43dedGralMensConCodigo = "" ;
      AV46suelBruSinSacMasBonoConCodigo = "" ;
      AV47anticipoDeSacConCodigo = "" ;
      AV33horasExtrasExentasConCodigo = "" ;
      AV48MovViaExenConCodigo = "" ;
      AV55sacExentoConCodigo = "" ;
      AV59sacGravadoConCodigo = "" ;
      AV49DocenteExenConCodigo = "" ;
      AV51DescuContemplaSACConCOdigo = "" ;
      AV58DescuNoContemplaSACConCOdigo = "" ;
      AV52bonosExentosConCodigo = "" ;
      AV60fallosCajaExentosConCodigo = "" ;
      AV61simNatExentosConCodigo = "" ;
      AV53calculoSacProximoEstimadoConCodigo = "" ;
      AV54sacLiquidadoPeriodoConCodigo = "" ;
      AV56otrosEmpleosGanBruConCodigo = "" ;
      AV57otrosEmpleosSacConCodigo = "" ;
      AV76horasNormalesConCodigo = "" ;
      AV77sueldoConCodigo = "" ;
      scmdbuf = "" ;
      P00U12_A37TipoConCod = new String[] {""} ;
      P00U12_A3CliCod = new int[1] ;
      P00U12_A895ConTipoOrden = new short[1] ;
      P00U12_A26ConCodigo = new String[] {""} ;
      P00U12_A510ConOrdEjec = new long[1] ;
      P00U12_A41ConDescrip = new String[] {""} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      AV62MaternidadConCodigo = "" ;
      AV63MaternidadDescuentoConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      P00U14_A37TipoConCod = new String[] {""} ;
      P00U14_A3CliCod = new int[1] ;
      P00U14_A895ConTipoOrden = new short[1] ;
      P00U14_A26ConCodigo = new String[] {""} ;
      P00U14_A510ConOrdEjec = new long[1] ;
      P00U16_A37TipoConCod = new String[] {""} ;
      P00U16_A3CliCod = new int[1] ;
      P00U16_A895ConTipoOrden = new short[1] ;
      P00U16_A38SubTipoConCod1 = new String[] {""} ;
      P00U16_n38SubTipoConCod1 = new boolean[] {false} ;
      P00U16_A510ConOrdEjec = new long[1] ;
      P00U16_A26ConCodigo = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      P00U18_A37TipoConCod = new String[] {""} ;
      P00U18_A3CliCod = new int[1] ;
      P00U18_A895ConTipoOrden = new short[1] ;
      P00U18_A26ConCodigo = new String[] {""} ;
      P00U18_A38SubTipoConCod1 = new String[] {""} ;
      P00U18_n38SubTipoConCod1 = new boolean[] {false} ;
      P00U18_A510ConOrdEjec = new long[1] ;
      P00U18_A39SubTipoConCod2 = new String[] {""} ;
      P00U18_n39SubTipoConCod2 = new boolean[] {false} ;
      A39SubTipoConCod2 = "" ;
      GXv_int7 = new long[1] ;
      GXv_int8 = new int[1] ;
      P00U110_A3CliCod = new int[1] ;
      P00U110_A40ConOrden = new int[1] ;
      P00U110_A41ConDescrip = new String[] {""} ;
      P00U110_A37TipoConCod = new String[] {""} ;
      P00U110_A922ConUsado = new boolean[] {false} ;
      P00U110_A26ConCodigo = new String[] {""} ;
      P00U110_A895ConTipoOrden = new short[1] ;
      AV66TipoConCod = "" ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV12sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem11 = new GXBaseCollection[1] ;
      GXv_boolean12 = new boolean[1] ;
      P00U112_A3CliCod = new int[1] ;
      P00U112_A41ConDescrip = new String[] {""} ;
      P00U112_A40ConOrden = new int[1] ;
      P00U112_A26ConCodigo = new String[] {""} ;
      AV65SAClIQCondescrip = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      P00U113_A41ConDescrip = new String[] {""} ;
      P00U113_A3CliCod = new int[1] ;
      P00U113_A40ConOrden = new int[1] ;
      P00U113_A26ConCodigo = new String[] {""} ;
      P00U116_A41ConDescrip = new String[] {""} ;
      P00U116_A3CliCod = new int[1] ;
      P00U116_A40ConOrden = new int[1] ;
      P00U116_A26ConCodigo = new String[] {""} ;
      P00U118_A41ConDescrip = new String[] {""} ;
      P00U118_A3CliCod = new int[1] ;
      P00U118_A40ConOrden = new int[1] ;
      P00U118_A26ConCodigo = new String[] {""} ;
      P00U120_A3CliCod = new int[1] ;
      P00U120_A1471ConNumero = new byte[1] ;
      P00U120_A26ConCodigo = new String[] {""} ;
      P00U122_A3CliCod = new int[1] ;
      P00U122_A40ConOrden = new int[1] ;
      P00U122_A510ConOrdEjec = new long[1] ;
      P00U122_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustarordenconceptos__default(),
         new Object[] {
             new Object[] {
            P00U12_A37TipoConCod, P00U12_A3CliCod, P00U12_A895ConTipoOrden, P00U12_A26ConCodigo, P00U12_A510ConOrdEjec, P00U12_A41ConDescrip
            }
            , new Object[] {
            }
            , new Object[] {
            P00U14_A37TipoConCod, P00U14_A3CliCod, P00U14_A895ConTipoOrden, P00U14_A26ConCodigo, P00U14_A510ConOrdEjec
            }
            , new Object[] {
            }
            , new Object[] {
            P00U16_A37TipoConCod, P00U16_A3CliCod, P00U16_A895ConTipoOrden, P00U16_A38SubTipoConCod1, P00U16_n38SubTipoConCod1, P00U16_A510ConOrdEjec, P00U16_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00U18_A37TipoConCod, P00U18_A3CliCod, P00U18_A895ConTipoOrden, P00U18_A26ConCodigo, P00U18_A38SubTipoConCod1, P00U18_n38SubTipoConCod1, P00U18_A510ConOrdEjec, P00U18_A39SubTipoConCod2, P00U18_n39SubTipoConCod2
            }
            , new Object[] {
            }
            , new Object[] {
            P00U110_A3CliCod, P00U110_A40ConOrden, P00U110_A41ConDescrip, P00U110_A37TipoConCod, P00U110_A922ConUsado, P00U110_A26ConCodigo, P00U110_A895ConTipoOrden
            }
            , new Object[] {
            }
            , new Object[] {
            P00U112_A3CliCod, P00U112_A41ConDescrip, P00U112_A40ConOrden, P00U112_A26ConCodigo
            }
            , new Object[] {
            P00U113_A41ConDescrip, P00U113_A3CliCod, P00U113_A40ConOrden, P00U113_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00U116_A41ConDescrip, P00U116_A3CliCod, P00U116_A40ConOrden, P00U116_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00U118_A41ConDescrip, P00U118_A3CliCod, P00U118_A40ConOrden, P00U118_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00U120_A3CliCod, P00U120_A1471ConNumero, P00U120_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00U122_A3CliCod, P00U122_A40ConOrden, P00U122_A510ConOrdEjec, P00U122_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1471ConNumero ;
   private byte AV71ConNumero ;
   private short A895ConTipoOrden ;
   private short AV10Intervalo ;
   private short AV74feriadoOrden ;
   private short AV75noLaboralOrden ;
   private short AV73ultimaLicencia ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GXv_int8[] ;
   private int AV9ConOrden ;
   private int A40ConOrden ;
   private int AV64sacproximoestimadoConOrden ;
   private int AV68vacConOrden ;
   private int AV69descuConOrden ;
   private long A510ConOrdEjec ;
   private long GXt_int6 ;
   private long GXv_int7[] ;
   private long AV72ConOrdEjec ;
   private String AV15LiquidaSACConCodigo ;
   private String AV16sueldoBrutoConCodigo ;
   private String AV17sueldoBrutoSinSacConCodigo ;
   private String AV18AlcanzaGananciasConCodigo ;
   private String AV19SueldoBrutoPromUltTramoConCodigo ;
   private String AV20SueldoBrutoGananciaMinimoConCodigo ;
   private String AV21SACConCodigo ;
   private String AV22SACProporConCodigo ;
   private String AV23haberesSACConCodigo ;
   private String AV24calculoSACConCodigo ;
   private String AV25devolucionGananciasConCodigo ;
   private String AV67topeDiasConCodigo ;
   private String AV70topeDiasSACConCodigo ;
   private String AV32retencionGananciasConCodigo ;
   private String AV26importeARetenerConCodigo ;
   private String AV27sueldoBrutoMenosDescuentosDeLeyConCodigo ;
   private String AV28calculoRetencionGananciasConCodigo ;
   private String AV29pagosACuentaConCodigo ;
   private String AV31gananciasFormulaAFIPConCodigo ;
   private String AV34otroEmplhorasExtrasGravadasCodigo ;
   private String AV35gnsiConCodigo ;
   private String AV36gnsiSinDeiConCodigo ;
   private String AV37dedEspIncConcodigo ;
   private String AV38gananciaNetaConCodigo ;
   private String AV39dedArt30ConCodigo ;
   private String AV40dedGralAnuConCodigo ;
   private String AV41remuneracionGravadaConCodigo ;
   private String AV42otrosEmpleosRemuGravadaConCodigo ;
   private String AV43dedGralMensConCodigo ;
   private String AV46suelBruSinSacMasBonoConCodigo ;
   private String AV47anticipoDeSacConCodigo ;
   private String AV33horasExtrasExentasConCodigo ;
   private String AV48MovViaExenConCodigo ;
   private String AV55sacExentoConCodigo ;
   private String AV59sacGravadoConCodigo ;
   private String AV49DocenteExenConCodigo ;
   private String AV51DescuContemplaSACConCOdigo ;
   private String AV58DescuNoContemplaSACConCOdigo ;
   private String AV52bonosExentosConCodigo ;
   private String AV60fallosCajaExentosConCodigo ;
   private String AV61simNatExentosConCodigo ;
   private String AV53calculoSacProximoEstimadoConCodigo ;
   private String AV54sacLiquidadoPeriodoConCodigo ;
   private String AV56otrosEmpleosGanBruConCodigo ;
   private String AV57otrosEmpleosSacConCodigo ;
   private String AV76horasNormalesConCodigo ;
   private String AV77sueldoConCodigo ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String AV62MaternidadConCodigo ;
   private String AV63MaternidadDescuentoConCodigo ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String AV66TipoConCod ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private boolean n38SubTipoConCod1 ;
   private boolean AV30SubTDescuLey ;
   private boolean n39SubTipoConCod2 ;
   private boolean Cond_result ;
   private boolean A922ConUsado ;
   private boolean AV14esConceptoImprimible ;
   private boolean GXt_boolean9 ;
   private boolean AV13seUsa ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean12[] ;
   private String A41ConDescrip ;
   private String AV65SAClIQCondescrip ;
   private IDataStoreProvider pr_default ;
   private String[] P00U12_A37TipoConCod ;
   private int[] P00U12_A3CliCod ;
   private short[] P00U12_A895ConTipoOrden ;
   private String[] P00U12_A26ConCodigo ;
   private long[] P00U12_A510ConOrdEjec ;
   private String[] P00U12_A41ConDescrip ;
   private String[] P00U14_A37TipoConCod ;
   private int[] P00U14_A3CliCod ;
   private short[] P00U14_A895ConTipoOrden ;
   private String[] P00U14_A26ConCodigo ;
   private long[] P00U14_A510ConOrdEjec ;
   private String[] P00U16_A37TipoConCod ;
   private int[] P00U16_A3CliCod ;
   private short[] P00U16_A895ConTipoOrden ;
   private String[] P00U16_A38SubTipoConCod1 ;
   private boolean[] P00U16_n38SubTipoConCod1 ;
   private long[] P00U16_A510ConOrdEjec ;
   private String[] P00U16_A26ConCodigo ;
   private String[] P00U18_A37TipoConCod ;
   private int[] P00U18_A3CliCod ;
   private short[] P00U18_A895ConTipoOrden ;
   private String[] P00U18_A26ConCodigo ;
   private String[] P00U18_A38SubTipoConCod1 ;
   private boolean[] P00U18_n38SubTipoConCod1 ;
   private long[] P00U18_A510ConOrdEjec ;
   private String[] P00U18_A39SubTipoConCod2 ;
   private boolean[] P00U18_n39SubTipoConCod2 ;
   private int[] P00U110_A3CliCod ;
   private int[] P00U110_A40ConOrden ;
   private String[] P00U110_A41ConDescrip ;
   private String[] P00U110_A37TipoConCod ;
   private boolean[] P00U110_A922ConUsado ;
   private String[] P00U110_A26ConCodigo ;
   private short[] P00U110_A895ConTipoOrden ;
   private int[] P00U112_A3CliCod ;
   private String[] P00U112_A41ConDescrip ;
   private int[] P00U112_A40ConOrden ;
   private String[] P00U112_A26ConCodigo ;
   private String[] P00U113_A41ConDescrip ;
   private int[] P00U113_A3CliCod ;
   private int[] P00U113_A40ConOrden ;
   private String[] P00U113_A26ConCodigo ;
   private String[] P00U116_A41ConDescrip ;
   private int[] P00U116_A3CliCod ;
   private int[] P00U116_A40ConOrden ;
   private String[] P00U116_A26ConCodigo ;
   private String[] P00U118_A41ConDescrip ;
   private int[] P00U118_A3CliCod ;
   private int[] P00U118_A40ConOrden ;
   private String[] P00U118_A26ConCodigo ;
   private int[] P00U120_A3CliCod ;
   private byte[] P00U120_A1471ConNumero ;
   private String[] P00U120_A26ConCodigo ;
   private int[] P00U122_A3CliCod ;
   private int[] P00U122_A40ConOrden ;
   private long[] P00U122_A510ConOrdEjec ;
   private String[] P00U122_A26ConCodigo ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV12sdt_conceptos ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem11[] ;
}

final  class ajustarordenconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00U12", "SELECT TipoConCod, CliCod, ConTipoOrden, ConCodigo, ConOrdEjec, ConDescrip FROM Concepto WHERE CliCod = ? and TipoConCod = ( 'REM_ARG') ORDER BY CliCod, TipoConCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U13", "SAVEPOINT gxupdate;UPDATE Concepto SET ConTipoOrden=?, ConOrdEjec=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U14", "SELECT TipoConCod, CliCod, ConTipoOrden, ConCodigo, ConOrdEjec FROM Concepto WHERE CliCod = ? and TipoConCod = ( 'NRE_ARG') ORDER BY CliCod, TipoConCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U15", "SAVEPOINT gxupdate;UPDATE Concepto SET ConTipoOrden=?, ConOrdEjec=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U16", "SELECT TipoConCod, CliCod, ConTipoOrden, SubTipoConCod1, ConOrdEjec, ConCodigo FROM Concepto WHERE CliCod = ? and TipoConCod = ( 'DES_ARG') ORDER BY CliCod, TipoConCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U17", "SAVEPOINT gxupdate;UPDATE Concepto SET ConTipoOrden=?, ConOrdEjec=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U18", "SELECT TipoConCod, CliCod, ConTipoOrden, ConCodigo, SubTipoConCod1, ConOrdEjec, SubTipoConCod2 FROM Concepto WHERE CliCod = ? and TipoConCod = ( 'CAL_ARG') ORDER BY CliCod, TipoConCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U19", "SAVEPOINT gxupdate;UPDATE Concepto SET ConTipoOrden=?, ConOrdEjec=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U110", "SELECT CliCod, ConOrden, ConDescrip, TipoConCod, ConUsado, ConCodigo, ConTipoOrden FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConTipoOrden, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U111", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?, ConUsado=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U112", "SELECT CliCod, ConDescrip, ConOrden, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConOrden DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00U113", "SELECT ConDescrip, CliCod, ConOrden, ConCodigo FROM Concepto WHERE CliCod = ? and ConDescrip = ( ?) ORDER BY CliCod, ConDescrip  LIMIT 1 FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00U114", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00U115", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U116", "SELECT ConDescrip, CliCod, ConOrden, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U117", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U118", "SELECT ConDescrip, CliCod, ConOrden, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U119", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U120", "SELECT CliCod, ConNumero, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U121", "SAVEPOINT gxupdate;UPDATE Concepto SET ConNumero=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00U122", "SELECT CliCod, ConOrden, ConOrdEjec, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConOrdEjec, ConOrden  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00U123", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrdEjec=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 19 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

