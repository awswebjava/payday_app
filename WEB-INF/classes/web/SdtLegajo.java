package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo extends GxSilentTrnSdt
{
   public SdtLegajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo.class));
   }

   public SdtLegajo( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo");
      initialize( remoteHandle) ;
   }

   public SdtLegajo( int remoteHandle ,
                     StructSdtLegajo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     int AV6LegNumero )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Legajo");
      metadata.set("BT", "Legajo");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\" ]");
      metadata.set("Levels", "[ \"Familia\",\"Propiedades\",\"Salario\",\"tipos_de_trabajo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ActCodigo\" ],\"FKMap\":[ \"LegActCodigo-ActCodigo\" ] },{ \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"BanCod\" ],\"FKMap\":[ \"LegBanCod-BanCod\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"SucCodigo\" ],\"FKMap\":[ \"LegSucCodigo-SucCodigo\" ] },{ \"FK\":[ \"CliCod\",\"LpgCodigo\" ],\"FKMap\":[ \"LegLpgCodigo-LpgCodigo\" ] },{ \"FK\":[ \"CliCod\",\"MegCodigo\" ],\"FKMap\":[ \"LegMegCodigo-MegCodigo\" ] },{ \"FK\":[ \"CliCod\",\"OsoCod\" ],\"FKMap\":[ \"LegOsoCod-OsoCod\" ] },{ \"FK\":[ \"CliCod\",\"SecCodigo\" ],\"FKMap\":[ \"LegSecCodigo-SecCodigo\" ] },{ \"FK\":[ \"CliCod\",\"SecCodigo\",\"PuestoCodigo\" ],\"FKMap\":[ \"LegSecCodigo-SecCodigo\",\"LegPuesCodigo-PuestoCodigo\" ] },{ \"FK\":[ \"CondiCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"EstaCivilCod\" ],\"FKMap\":[ \"LegEstadoCivil-EstaCivilCod\" ] },{ \"FK\":[ \"MprCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[ \"LegNacionCod-PaiCod\" ] },{ \"FK\":[ \"PaiCod\",\"ActLabNro\" ],\"FKMap\":[ \"LegPaiCod-PaiCod\",\"LegActClasNro-ActLabNro\" ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\" ],\"FKMap\":[ \"LegPaiCod-PaiCod\",\"LegProvCod-ProvCod\" ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\",\"LocCod\" ],\"FKMap\":[ \"LegPaiCod-PaiCod\",\"LegProvCod-ProvCod\",\"LegLocCod-LocCod\" ] },{ \"FK\":[ \"PaiCod\",\"SinCod\" ],\"FKMap\":[ \"LegPaiCod-PaiCod\",\"LegSinCod-SinCod\" ] },{ \"FK\":[ \"PueAfipCod\" ],\"FKMap\":[ \"LegPueAfiCod-PueAfipCod\" ] },{ \"FK\":[ \"SexoId\" ],\"FKMap\":[ \"LegSexo-SexoId\" ] },{ \"FK\":[ \"SinieCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SitRevCodigo\" ],\"FKMap\":[ \"LegSitRevEgreso-SitRevCodigo\" ] },{ \"FK\":[ \"ZonCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtLegajo_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLegajo_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtLegajo_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtLegajo_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido") )
            {
               gxTv_SdtLegajo_Legapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre") )
            {
               gxTv_SdtLegajo_Legnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFoto") )
            {
               gxTv_SdtLegajo_Legfoto=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Salario") )
            {
               if ( gxTv_SdtLegajo_Salario == null )
               {
                  gxTv_SdtLegajo_Salario = new GXBCLevelCollection<web.SdtLegajo_Salario>(web.SdtLegajo_Salario.class, "Legajo.Salario", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtLegajo_Salario.readxml(oReader, "Salario") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Salario") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Familia") )
            {
               if ( gxTv_SdtLegajo_Familia == null )
               {
                  gxTv_SdtLegajo_Familia = new GXBCLevelCollection<web.SdtLegajo_Familia>(web.SdtLegajo_Familia.class, "Legajo.Familia", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtLegajo_Familia.readxml(oReader, "Familia") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Familia") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFotoNom") )
            {
               gxTv_SdtLegajo_Legfotonom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFotoExt") )
            {
               gxTv_SdtLegajo_Legfotoext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipDoc") )
            {
               gxTv_SdtLegajo_Legtipdoc = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumDoc") )
            {
               gxTv_SdtLegajo_Legnumdoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSexo") )
            {
               gxTv_SdtLegajo_Legsexo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEstadoCivil") )
            {
               gxTv_SdtLegajo_Legestadocivil = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNacionCod") )
            {
               gxTv_SdtLegajo_Legnacioncod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNacionalidad") )
            {
               gxTv_SdtLegajo_Legnacionalidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCUIL") )
            {
               gxTv_SdtLegajo_Legcuil = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDiscapacidad") )
            {
               gxTv_SdtLegajo_Legdiscapacidad = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDomici") )
            {
               gxTv_SdtLegajo_Legdomici = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEmail") )
            {
               gxTv_SdtLegajo_Legemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCodPos") )
            {
               gxTv_SdtLegajo_Legcodpos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPaiCod") )
            {
               gxTv_SdtLegajo_Legpaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPaiNom") )
            {
               gxTv_SdtLegajo_Legpainom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegProvCod") )
            {
               gxTv_SdtLegajo_Legprovcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegProvNom") )
            {
               gxTv_SdtLegajo_Legprovnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLocCod") )
            {
               gxTv_SdtLegajo_Legloccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLocNom") )
            {
               gxTv_SdtLegajo_Leglocnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTelefono") )
            {
               gxTv_SdtLegajo_Legtelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecIngreso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecingreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecingreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecEgreso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecegreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecegreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegMegCodigo") )
            {
               gxTv_SdtLegajo_Legmegcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegDescrip") )
            {
               gxTv_SdtLegajo_Megdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatCodigo") )
            {
               gxTv_SdtLegajo_Legcatcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatPueCod") )
            {
               gxTv_SdtLegajo_Legcatpuecod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSecCodigo") )
            {
               gxTv_SdtLegajo_Legseccodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip") )
            {
               gxTv_SdtLegajo_Secdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLpgCodigo") )
            {
               gxTv_SdtLegajo_Leglpgcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LpgDescri") )
            {
               gxTv_SdtLegajo_Lpgdescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegClase") )
            {
               gxTv_SdtLegajo_Legclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBasico") )
            {
               gxTv_SdtLegajo_Legbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFormaPago") )
            {
               gxTv_SdtLegajo_Legformapago = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanCod") )
            {
               gxTv_SdtLegajo_Legbancod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanDes") )
            {
               gxTv_SdtLegajo_Legbandes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanSuc") )
            {
               gxTv_SdtLegajo_Legbansuc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanTipCuen") )
            {
               gxTv_SdtLegajo_Legbantipcuen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSinCod") )
            {
               gxTv_SdtLegajo_Legsincod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinDescrip") )
            {
               gxTv_SdtLegajo_Sindescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoCod") )
            {
               gxTv_SdtLegajo_Legosocod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoDes") )
            {
               gxTv_SdtLegajo_Legosodes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoAfipCod") )
            {
               gxTv_SdtLegajo_Legosoafipcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoDescrip") )
            {
               gxTv_SdtLegajo_Osodescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActCodigo") )
            {
               gxTv_SdtLegajo_Legactcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActDescri") )
            {
               gxTv_SdtLegajo_Legactdescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprCod") )
            {
               gxTv_SdtLegajo_Mprcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprDescrip") )
            {
               gxTv_SdtLegajo_Mprdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecUltMod") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecultmod = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecultmod = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCuentaBanc") )
            {
               gxTv_SdtLegajo_Legcuentabanc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicInicio") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Leglicinicio = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Leglicinicio = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFinal") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Leglicfinal = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Leglicfinal = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonCod") )
            {
               gxTv_SdtLegajo_Zoncod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonDescrip") )
            {
               gxTv_SdtLegajo_Zondescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonPorcReduc") )
            {
               gxTv_SdtLegajo_Zonporcreduc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCBU") )
            {
               gxTv_SdtLegajo_Legcbu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConvenio") )
            {
               gxTv_SdtLegajo_Legconvenio = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSCVO") )
            {
               gxTv_SdtLegajo_Legscvo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo") )
            {
               gxTv_SdtLegajo_Condicodigo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescri") )
            {
               gxTv_SdtLegajo_Condidescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinieCodigo") )
            {
               gxTv_SdtLegajo_Siniecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinieDescri") )
            {
               gxTv_SdtLegajo_Siniedescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActivo") )
            {
               gxTv_SdtLegajo_Legactivo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSueldoFuera") )
            {
               gxTv_SdtLegajo_Legsueldofuera = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId") )
            {
               gxTv_SdtLegajo_Legid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveCodigo") )
            {
               gxTv_SdtLegajo_Legconvecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe") )
            {
               gxTv_SdtLegajo_Legidnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod") )
            {
               gxTv_SdtLegajo_Tipemplecod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoC3992") )
            {
               gxTv_SdtLegajo_Osoc3992 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegObs") )
            {
               gxTv_SdtLegajo_Legobs = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNomApe") )
            {
               gxTv_SdtLegajo_Legnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecImportacion") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecimportacion = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLegajo_Legfecimportacion = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegAgenReten") )
            {
               gxTv_SdtLegajo_Legagenreten = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegContinua") )
            {
               gxTv_SdtLegajo_Legcontinua = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegRecalcLiq") )
            {
               gxTv_SdtLegajo_Legrecalcliq = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegJubilado") )
            {
               gxTv_SdtLegajo_Legjubilado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegHorasDia") )
            {
               gxTv_SdtLegajo_Leghorasdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegHorasSem") )
            {
               gxTv_SdtLegajo_Leghorassem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegReligion") )
            {
               gxTv_SdtLegajo_Legreligion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrigen") )
            {
               gxTv_SdtLegajo_Legorigen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPuesCodigo") )
            {
               gxTv_SdtLegajo_Legpuescodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSucCodigo") )
            {
               gxTv_SdtLegajo_Legsuccodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabLun") )
            {
               gxTv_SdtLegajo_Legtrablun = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabMar") )
            {
               gxTv_SdtLegajo_Legtrabmar = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabMie") )
            {
               gxTv_SdtLegajo_Legtrabmie = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabJue") )
            {
               gxTv_SdtLegajo_Legtrabjue = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabVie") )
            {
               gxTv_SdtLegajo_Legtrabvie = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabSa") )
            {
               gxTv_SdtLegajo_Legtrabsa = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabDo") )
            {
               gxTv_SdtLegajo_Legtrabdo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipos_de_trabajo") )
            {
               if ( gxTv_SdtLegajo_Tipos_de_trabajo == null )
               {
                  gxTv_SdtLegajo_Tipos_de_trabajo = new GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo>(web.SdtLegajo_tipos_de_trabajo.class, "Legajo.tipos_de_trabajo", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtLegajo_Tipos_de_trabajo.readxml(oReader, "tipos_de_trabajo") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "tipos_de_trabajo") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegVacPend") )
            {
               gxTv_SdtLegajo_Legvacpend = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecPreAviso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecpreaviso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecpreaviso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveVersionCli") )
            {
               gxTv_SdtLegajo_Legconveversioncli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitRevEgreso") )
            {
               gxTv_SdtLegajo_Legsitrevegreso = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPromDias") )
            {
               gxTv_SdtLegajo_Legpromdias = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTitulo") )
            {
               gxTv_SdtLegajo_Legtitulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEstado") )
            {
               gxTv_SdtLegajo_Legestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActClasNro") )
            {
               gxTv_SdtLegajo_Legactclasnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPueAfiCod") )
            {
               gxTv_SdtLegajo_Legpueaficod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegMigrWarn") )
            {
               gxTv_SdtLegajo_Legmigrwarn = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIncompleto") )
            {
               gxTv_SdtLegajo_Legincompleto = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLiqApo") )
            {
               gxTv_SdtLegajo_Legliqapo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Propiedades") )
            {
               if ( gxTv_SdtLegajo_Propiedades == null )
               {
                  gxTv_SdtLegajo_Propiedades = new GXBCLevelCollection<web.SdtLegajo_Propiedades>(web.SdtLegajo_Propiedades.class, "Legajo.Propiedades", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtLegajo_Propiedades.readxml(oReader, "Propiedades") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Propiedades") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegModTra") )
            {
               gxTv_SdtLegajo_Legmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipoTarifa") )
            {
               gxTv_SdtLegajo_Legtipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLegajo_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLegajo_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtLegajo_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtLegajo_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido_Z") )
            {
               gxTv_SdtLegajo_Legapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre_Z") )
            {
               gxTv_SdtLegajo_Legnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFotoNom_Z") )
            {
               gxTv_SdtLegajo_Legfotonom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFotoExt_Z") )
            {
               gxTv_SdtLegajo_Legfotoext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipDoc_Z") )
            {
               gxTv_SdtLegajo_Legtipdoc_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumDoc_Z") )
            {
               gxTv_SdtLegajo_Legnumdoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSexo_Z") )
            {
               gxTv_SdtLegajo_Legsexo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEstadoCivil_Z") )
            {
               gxTv_SdtLegajo_Legestadocivil_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNacionCod_Z") )
            {
               gxTv_SdtLegajo_Legnacioncod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNacionalidad_Z") )
            {
               gxTv_SdtLegajo_Legnacionalidad_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCUIL_Z") )
            {
               gxTv_SdtLegajo_Legcuil_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDiscapacidad_Z") )
            {
               gxTv_SdtLegajo_Legdiscapacidad_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDomici_Z") )
            {
               gxTv_SdtLegajo_Legdomici_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEmail_Z") )
            {
               gxTv_SdtLegajo_Legemail_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCodPos_Z") )
            {
               gxTv_SdtLegajo_Legcodpos_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPaiCod_Z") )
            {
               gxTv_SdtLegajo_Legpaicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPaiNom_Z") )
            {
               gxTv_SdtLegajo_Legpainom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegProvCod_Z") )
            {
               gxTv_SdtLegajo_Legprovcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegProvNom_Z") )
            {
               gxTv_SdtLegajo_Legprovnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLocCod_Z") )
            {
               gxTv_SdtLegajo_Legloccod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLocNom_Z") )
            {
               gxTv_SdtLegajo_Leglocnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTelefono_Z") )
            {
               gxTv_SdtLegajo_Legtelefono_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecIngreso_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecingreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecingreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecEgreso_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecegreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecegreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegMegCodigo_Z") )
            {
               gxTv_SdtLegajo_Legmegcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegDescrip_Z") )
            {
               gxTv_SdtLegajo_Megdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatCodigo_Z") )
            {
               gxTv_SdtLegajo_Legcatcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatPueCod_Z") )
            {
               gxTv_SdtLegajo_Legcatpuecod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSecCodigo_Z") )
            {
               gxTv_SdtLegajo_Legseccodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip_Z") )
            {
               gxTv_SdtLegajo_Secdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLpgCodigo_Z") )
            {
               gxTv_SdtLegajo_Leglpgcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LpgDescri_Z") )
            {
               gxTv_SdtLegajo_Lpgdescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegClase_Z") )
            {
               gxTv_SdtLegajo_Legclase_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBasico_Z") )
            {
               gxTv_SdtLegajo_Legbasico_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFormaPago_Z") )
            {
               gxTv_SdtLegajo_Legformapago_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanCod_Z") )
            {
               gxTv_SdtLegajo_Legbancod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanDes_Z") )
            {
               gxTv_SdtLegajo_Legbandes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanSuc_Z") )
            {
               gxTv_SdtLegajo_Legbansuc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanTipCuen_Z") )
            {
               gxTv_SdtLegajo_Legbantipcuen_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSinCod_Z") )
            {
               gxTv_SdtLegajo_Legsincod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinDescrip_Z") )
            {
               gxTv_SdtLegajo_Sindescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoCod_Z") )
            {
               gxTv_SdtLegajo_Legosocod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoDes_Z") )
            {
               gxTv_SdtLegajo_Legosodes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoAfipCod_Z") )
            {
               gxTv_SdtLegajo_Legosoafipcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoDescrip_Z") )
            {
               gxTv_SdtLegajo_Osodescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActCodigo_Z") )
            {
               gxTv_SdtLegajo_Legactcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActDescri_Z") )
            {
               gxTv_SdtLegajo_Legactdescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprCod_Z") )
            {
               gxTv_SdtLegajo_Mprcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprDescrip_Z") )
            {
               gxTv_SdtLegajo_Mprdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecUltMod_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecultmod_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecultmod_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCuentaBanc_Z") )
            {
               gxTv_SdtLegajo_Legcuentabanc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicInicio_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Leglicinicio_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Leglicinicio_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFinal_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Leglicfinal_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Leglicfinal_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonCod_Z") )
            {
               gxTv_SdtLegajo_Zoncod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonDescrip_Z") )
            {
               gxTv_SdtLegajo_Zondescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonPorcReduc_Z") )
            {
               gxTv_SdtLegajo_Zonporcreduc_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCBU_Z") )
            {
               gxTv_SdtLegajo_Legcbu_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConvenio_Z") )
            {
               gxTv_SdtLegajo_Legconvenio_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSCVO_Z") )
            {
               gxTv_SdtLegajo_Legscvo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo_Z") )
            {
               gxTv_SdtLegajo_Condicodigo_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescri_Z") )
            {
               gxTv_SdtLegajo_Condidescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinieCodigo_Z") )
            {
               gxTv_SdtLegajo_Siniecodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinieDescri_Z") )
            {
               gxTv_SdtLegajo_Siniedescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActivo_Z") )
            {
               gxTv_SdtLegajo_Legactivo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSueldoFuera_Z") )
            {
               gxTv_SdtLegajo_Legsueldofuera_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_Z") )
            {
               gxTv_SdtLegajo_Legid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveCodigo_Z") )
            {
               gxTv_SdtLegajo_Legconvecodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe_Z") )
            {
               gxTv_SdtLegajo_Legidnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_Z") )
            {
               gxTv_SdtLegajo_Tipemplecod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoC3992_Z") )
            {
               gxTv_SdtLegajo_Osoc3992_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNomApe_Z") )
            {
               gxTv_SdtLegajo_Legnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecImportacion_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecimportacion_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLegajo_Legfecimportacion_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegAgenReten_Z") )
            {
               gxTv_SdtLegajo_Legagenreten_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegContinua_Z") )
            {
               gxTv_SdtLegajo_Legcontinua_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegRecalcLiq_Z") )
            {
               gxTv_SdtLegajo_Legrecalcliq_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegJubilado_Z") )
            {
               gxTv_SdtLegajo_Legjubilado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegHorasDia_Z") )
            {
               gxTv_SdtLegajo_Leghorasdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegHorasSem_Z") )
            {
               gxTv_SdtLegajo_Leghorassem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegReligion_Z") )
            {
               gxTv_SdtLegajo_Legreligion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrigen_Z") )
            {
               gxTv_SdtLegajo_Legorigen_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPuesCodigo_Z") )
            {
               gxTv_SdtLegajo_Legpuescodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSucCodigo_Z") )
            {
               gxTv_SdtLegajo_Legsuccodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabLun_Z") )
            {
               gxTv_SdtLegajo_Legtrablun_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabMar_Z") )
            {
               gxTv_SdtLegajo_Legtrabmar_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabMie_Z") )
            {
               gxTv_SdtLegajo_Legtrabmie_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabJue_Z") )
            {
               gxTv_SdtLegajo_Legtrabjue_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabVie_Z") )
            {
               gxTv_SdtLegajo_Legtrabvie_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabSa_Z") )
            {
               gxTv_SdtLegajo_Legtrabsa_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTrabDo_Z") )
            {
               gxTv_SdtLegajo_Legtrabdo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegVacPend_Z") )
            {
               gxTv_SdtLegajo_Legvacpend_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecPreAviso_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Legfecpreaviso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Legfecpreaviso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveVersionCli_Z") )
            {
               gxTv_SdtLegajo_Legconveversioncli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitRevEgreso_Z") )
            {
               gxTv_SdtLegajo_Legsitrevegreso_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPromDias_Z") )
            {
               gxTv_SdtLegajo_Legpromdias_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTitulo_Z") )
            {
               gxTv_SdtLegajo_Legtitulo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEstado_Z") )
            {
               gxTv_SdtLegajo_Legestado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActClasNro_Z") )
            {
               gxTv_SdtLegajo_Legactclasnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPueAfiCod_Z") )
            {
               gxTv_SdtLegajo_Legpueaficod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIncompleto_Z") )
            {
               gxTv_SdtLegajo_Legincompleto_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLiqApo_Z") )
            {
               gxTv_SdtLegajo_Legliqapo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegModTra_Z") )
            {
               gxTv_SdtLegajo_Legmodtra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipoTarifa_Z") )
            {
               gxTv_SdtLegajo_Legtipotarifa_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFoto_N") )
            {
               gxTv_SdtLegajo_Legfoto_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSexo_N") )
            {
               gxTv_SdtLegajo_Legsexo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEstadoCivil_N") )
            {
               gxTv_SdtLegajo_Legestadocivil_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNacionCod_N") )
            {
               gxTv_SdtLegajo_Legnacioncod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPaiCod_N") )
            {
               gxTv_SdtLegajo_Legpaicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegProvCod_N") )
            {
               gxTv_SdtLegajo_Legprovcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLocCod_N") )
            {
               gxTv_SdtLegajo_Legloccod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTelefono_N") )
            {
               gxTv_SdtLegajo_Legtelefono_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecEgreso_N") )
            {
               gxTv_SdtLegajo_Legfecegreso_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegMegCodigo_N") )
            {
               gxTv_SdtLegajo_Legmegcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegDescrip_N") )
            {
               gxTv_SdtLegajo_Megdescrip_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatCodigo_N") )
            {
               gxTv_SdtLegajo_Legcatcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCatPueCod_N") )
            {
               gxTv_SdtLegajo_Legcatpuecod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSecCodigo_N") )
            {
               gxTv_SdtLegajo_Legseccodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip_N") )
            {
               gxTv_SdtLegajo_Secdescrip_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLpgCodigo_N") )
            {
               gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LpgDescri_N") )
            {
               gxTv_SdtLegajo_Lpgdescri_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanCod_N") )
            {
               gxTv_SdtLegajo_Legbancod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanSuc_N") )
            {
               gxTv_SdtLegajo_Legbansuc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegBanTipCuen_N") )
            {
               gxTv_SdtLegajo_Legbantipcuen_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSinCod_N") )
            {
               gxTv_SdtLegajo_Legsincod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinDescrip_N") )
            {
               gxTv_SdtLegajo_Sindescrip_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoCod_N") )
            {
               gxTv_SdtLegajo_Legosocod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOsoAfipCod_N") )
            {
               gxTv_SdtLegajo_Legosoafipcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoDescrip_N") )
            {
               gxTv_SdtLegajo_Osodescrip_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActCodigo_N") )
            {
               gxTv_SdtLegajo_Legactcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprCod_N") )
            {
               gxTv_SdtLegajo_Mprcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCuentaBanc_N") )
            {
               gxTv_SdtLegajo_Legcuentabanc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicInicio_N") )
            {
               gxTv_SdtLegajo_Leglicinicio_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFinal_N") )
            {
               gxTv_SdtLegajo_Leglicfinal_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ZonCod_N") )
            {
               gxTv_SdtLegajo_Zoncod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCBU_N") )
            {
               gxTv_SdtLegajo_Legcbu_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo_N") )
            {
               gxTv_SdtLegajo_Condicodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SinieCodigo_N") )
            {
               gxTv_SdtLegajo_Siniecodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_N") )
            {
               gxTv_SdtLegajo_Legid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveCodigo_N") )
            {
               gxTv_SdtLegajo_Legconvecodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_N") )
            {
               gxTv_SdtLegajo_Tipemplecod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoC3992_N") )
            {
               gxTv_SdtLegajo_Osoc3992_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegReligion_N") )
            {
               gxTv_SdtLegajo_Legreligion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrigen_N") )
            {
               gxTv_SdtLegajo_Legorigen_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPuesCodigo_N") )
            {
               gxTv_SdtLegajo_Legpuescodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSucCodigo_N") )
            {
               gxTv_SdtLegajo_Legsuccodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegConveVersionCli_N") )
            {
               gxTv_SdtLegajo_Legconveversioncli_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitRevEgreso_N") )
            {
               gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegActClasNro_N") )
            {
               gxTv_SdtLegajo_Legactclasnro_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPueAfiCod_N") )
            {
               gxTv_SdtLegajo_Legpueaficod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegMigrWarn_N") )
            {
               gxTv_SdtLegajo_Legmigrwarn_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Legajo" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtLegajo_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegApellido", gxTv_SdtLegajo_Legapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNombre", gxTv_SdtLegajo_Legnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegFoto", GXutil.blobToBase64( gxTv_SdtLegajo_Legfoto));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtLegajo_Salario != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtLegajo_Salario.writexml(oWriter, "Salario", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtLegajo_Familia != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtLegajo_Familia.writexml(oWriter, "Familia", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("LegFotoNom", gxTv_SdtLegajo_Legfotonom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegFotoExt", gxTv_SdtLegajo_Legfotoext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTipDoc", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legtipdoc, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumDoc", gxTv_SdtLegajo_Legnumdoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSexo", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsexo, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegEstadoCivil", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legestadocivil, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNacionCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legnacioncod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNacionalidad", gxTv_SdtLegajo_Legnacionalidad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCUIL", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcuil, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDiscapacidad", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legdiscapacidad, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDomici", gxTv_SdtLegajo_Legdomici);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegEmail", gxTv_SdtLegajo_Legemail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCodPos", gxTv_SdtLegajo_Legcodpos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPaiCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legpaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPaiNom", gxTv_SdtLegajo_Legpainom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegProvCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legprovcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegProvNom", gxTv_SdtLegajo_Legprovnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLocCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legloccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLocNom", gxTv_SdtLegajo_Leglocnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTelefono", gxTv_SdtLegajo_Legtelefono);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecIngreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecEgreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegMegCodigo", gxTv_SdtLegajo_Legmegcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegDescrip", gxTv_SdtLegajo_Megdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCatCodigo", gxTv_SdtLegajo_Legcatcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCatPueCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcatpuecod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSecCodigo", gxTv_SdtLegajo_Legseccodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecDescrip", gxTv_SdtLegajo_Secdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLpgCodigo", gxTv_SdtLegajo_Leglpgcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LpgDescri", gxTv_SdtLegajo_Lpgdescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegClase", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegBasico", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Legbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegFormaPago", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legformapago, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegBanCod", gxTv_SdtLegajo_Legbancod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegBanDes", gxTv_SdtLegajo_Legbandes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegBanSuc", gxTv_SdtLegajo_Legbansuc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegBanTipCuen", gxTv_SdtLegajo_Legbantipcuen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSinCod", gxTv_SdtLegajo_Legsincod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SinDescrip", gxTv_SdtLegajo_Sindescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegOsoCod", gxTv_SdtLegajo_Legosocod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegOsoDes", gxTv_SdtLegajo_Legosodes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegOsoAfipCod", gxTv_SdtLegajo_Legosoafipcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoDescrip", gxTv_SdtLegajo_Osodescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegActCodigo", gxTv_SdtLegajo_Legactcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegActDescri", gxTv_SdtLegajo_Legactdescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MprCod", gxTv_SdtLegajo_Mprcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MprDescrip", gxTv_SdtLegajo_Mprdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecUltMod", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCuentaBanc", gxTv_SdtLegajo_Legcuentabanc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicInicio", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicFinal", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ZonCod", gxTv_SdtLegajo_Zoncod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ZonDescrip", gxTv_SdtLegajo_Zondescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ZonPorcReduc", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Zonporcreduc, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCBU", gxTv_SdtLegajo_Legcbu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegConvenio", GXutil.booltostr( gxTv_SdtLegajo_Legconvenio));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSCVO", GXutil.booltostr( gxTv_SdtLegajo_Legscvo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CondiCodigo", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Condicodigo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CondiDescri", gxTv_SdtLegajo_Condidescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SinieCodigo", gxTv_SdtLegajo_Siniecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SinieDescri", gxTv_SdtLegajo_Siniedescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegActivo", GXutil.booltostr( gxTv_SdtLegajo_Legactivo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSueldoFuera", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Legsueldofuera, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegId", gxTv_SdtLegajo_Legid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegConveCodigo", gxTv_SdtLegajo_Legconvecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegIdNomApe", gxTv_SdtLegajo_Legidnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipEmpleCod", gxTv_SdtLegajo_Tipemplecod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoC3992", gxTv_SdtLegajo_Osoc3992);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegObs", gxTv_SdtLegajo_Legobs);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNomApe", gxTv_SdtLegajo_Legnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLegajo_Legfecimportacion), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecImportacion", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegAgenReten", GXutil.booltostr( gxTv_SdtLegajo_Legagenreten));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegContinua", gxTv_SdtLegajo_Legcontinua);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegRecalcLiq", GXutil.booltostr( gxTv_SdtLegajo_Legrecalcliq));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegJubilado", GXutil.booltostr( gxTv_SdtLegajo_Legjubilado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegHorasDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Leghorasdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegHorasSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Leghorassem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegReligion", gxTv_SdtLegajo_Legreligion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegOrigen", gxTv_SdtLegajo_Legorigen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPuesCodigo", gxTv_SdtLegajo_Legpuescodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSucCodigo", gxTv_SdtLegajo_Legsuccodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabLun", GXutil.booltostr( gxTv_SdtLegajo_Legtrablun));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabMar", GXutil.booltostr( gxTv_SdtLegajo_Legtrabmar));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabMie", GXutil.booltostr( gxTv_SdtLegajo_Legtrabmie));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabJue", GXutil.booltostr( gxTv_SdtLegajo_Legtrabjue));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabVie", GXutil.booltostr( gxTv_SdtLegajo_Legtrabvie));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabSa", GXutil.booltostr( gxTv_SdtLegajo_Legtrabsa));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTrabDo", GXutil.booltostr( gxTv_SdtLegajo_Legtrabdo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtLegajo_Tipos_de_trabajo.writexml(oWriter, "tipos_de_trabajo", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("LegVacPend", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legvacpend, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecPreAviso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegConveVersionCli", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legconveversioncli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitRevEgreso", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsitrevegreso, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPromDias", gxTv_SdtLegajo_Legpromdias);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTitulo", gxTv_SdtLegajo_Legtitulo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegEstado", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegActClasNro", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legactclasnro, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPueAfiCod", gxTv_SdtLegajo_Legpueaficod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegMigrWarn", gxTv_SdtLegajo_Legmigrwarn);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegIncompleto", GXutil.booltostr( gxTv_SdtLegajo_Legincompleto));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLiqApo", GXutil.booltostr( gxTv_SdtLegajo_Legliqapo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtLegajo_Propiedades != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtLegajo_Propiedades.writexml(oWriter, "Propiedades", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("LegModTra", gxTv_SdtLegajo_Legmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegTipoTarifa", gxTv_SdtLegajo_Legtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtLegajo_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegApellido_Z", gxTv_SdtLegajo_Legapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNombre_Z", gxTv_SdtLegajo_Legnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFotoNom_Z", gxTv_SdtLegajo_Legfotonom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFotoExt_Z", gxTv_SdtLegajo_Legfotoext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTipDoc_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legtipdoc_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumDoc_Z", gxTv_SdtLegajo_Legnumdoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecNac_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSexo_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsexo_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegEstadoCivil_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legestadocivil_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNacionCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legnacioncod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNacionalidad_Z", gxTv_SdtLegajo_Legnacionalidad_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCUIL_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcuil_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDiscapacidad_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legdiscapacidad_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDomici_Z", gxTv_SdtLegajo_Legdomici_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegEmail_Z", gxTv_SdtLegajo_Legemail_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCodPos_Z", gxTv_SdtLegajo_Legcodpos_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legpaicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPaiNom_Z", gxTv_SdtLegajo_Legpainom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegProvCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legprovcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegProvNom_Z", gxTv_SdtLegajo_Legprovnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLocCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legloccod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLocNom_Z", gxTv_SdtLegajo_Leglocnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTelefono_Z", gxTv_SdtLegajo_Legtelefono_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecIngreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecEgreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegMegCodigo_Z", gxTv_SdtLegajo_Legmegcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegDescrip_Z", gxTv_SdtLegajo_Megdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCatCodigo_Z", gxTv_SdtLegajo_Legcatcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCatPueCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcatpuecod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSecCodigo_Z", gxTv_SdtLegajo_Legseccodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecDescrip_Z", gxTv_SdtLegajo_Secdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLpgCodigo_Z", gxTv_SdtLegajo_Leglpgcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LpgDescri_Z", gxTv_SdtLegajo_Lpgdescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegClase_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legclase_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBasico_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Legbasico_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFormaPago_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legformapago_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanCod_Z", gxTv_SdtLegajo_Legbancod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanDes_Z", gxTv_SdtLegajo_Legbandes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanSuc_Z", gxTv_SdtLegajo_Legbansuc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanTipCuen_Z", gxTv_SdtLegajo_Legbantipcuen_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSinCod_Z", gxTv_SdtLegajo_Legsincod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SinDescrip_Z", gxTv_SdtLegajo_Sindescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOsoCod_Z", gxTv_SdtLegajo_Legosocod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOsoDes_Z", gxTv_SdtLegajo_Legosodes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOsoAfipCod_Z", gxTv_SdtLegajo_Legosoafipcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OsoDescrip_Z", gxTv_SdtLegajo_Osodescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActCodigo_Z", gxTv_SdtLegajo_Legactcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActDescri_Z", gxTv_SdtLegajo_Legactdescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MprCod_Z", gxTv_SdtLegajo_Mprcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MprDescrip_Z", gxTv_SdtLegajo_Mprdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecUltMod_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCuentaBanc_Z", gxTv_SdtLegajo_Legcuentabanc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicInicio_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicFinal_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ZonCod_Z", gxTv_SdtLegajo_Zoncod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ZonDescrip_Z", gxTv_SdtLegajo_Zondescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ZonPorcReduc_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Zonporcreduc_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCBU_Z", gxTv_SdtLegajo_Legcbu_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegConvenio_Z", GXutil.booltostr( gxTv_SdtLegajo_Legconvenio_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSCVO_Z", GXutil.booltostr( gxTv_SdtLegajo_Legscvo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiCodigo_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Condicodigo_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiDescri_Z", gxTv_SdtLegajo_Condidescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SinieCodigo_Z", gxTv_SdtLegajo_Siniecodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SinieDescri_Z", gxTv_SdtLegajo_Siniedescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActivo_Z", GXutil.booltostr( gxTv_SdtLegajo_Legactivo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSueldoFuera_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Legsueldofuera_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_Z", gxTv_SdtLegajo_Legid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegConveCodigo_Z", gxTv_SdtLegajo_Legconvecodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegIdNomApe_Z", gxTv_SdtLegajo_Legidnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_Z", gxTv_SdtLegajo_Tipemplecod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OsoC3992_Z", gxTv_SdtLegajo_Osoc3992_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNomApe_Z", gxTv_SdtLegajo_Legnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLegajo_Legfecimportacion_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecImportacion_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegAgenReten_Z", GXutil.booltostr( gxTv_SdtLegajo_Legagenreten_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegContinua_Z", gxTv_SdtLegajo_Legcontinua_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegRecalcLiq_Z", GXutil.booltostr( gxTv_SdtLegajo_Legrecalcliq_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegJubilado_Z", GXutil.booltostr( gxTv_SdtLegajo_Legjubilado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegHorasDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Leghorasdia_Z, 3, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegHorasSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Leghorassem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegReligion_Z", gxTv_SdtLegajo_Legreligion_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOrigen_Z", gxTv_SdtLegajo_Legorigen_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPuesCodigo_Z", gxTv_SdtLegajo_Legpuescodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSucCodigo_Z", gxTv_SdtLegajo_Legsuccodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabLun_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrablun_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabMar_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabmar_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabMie_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabmie_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabJue_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabjue_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabVie_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabvie_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabSa_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabsa_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTrabDo_Z", GXutil.booltostr( gxTv_SdtLegajo_Legtrabdo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegVacPend_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legvacpend_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecPreAviso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegConveVersionCli_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legconveversioncli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitRevEgreso_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsitrevegreso_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPromDias_Z", gxTv_SdtLegajo_Legpromdias_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTitulo_Z", gxTv_SdtLegajo_Legtitulo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegEstado_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legestado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActClasNro_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legactclasnro_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPueAfiCod_Z", gxTv_SdtLegajo_Legpueaficod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegIncompleto_Z", GXutil.booltostr( gxTv_SdtLegajo_Legincompleto_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLiqApo_Z", GXutil.booltostr( gxTv_SdtLegajo_Legliqapo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegModTra_Z", gxTv_SdtLegajo_Legmodtra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTipoTarifa_Z", gxTv_SdtLegajo_Legtipotarifa_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFoto_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legfoto_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSexo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsexo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegEstadoCivil_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legestadocivil_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNacionCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legnacioncod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPaiCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legpaicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegProvCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legprovcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLocCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legloccod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTelefono_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legtelefono_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFecEgreso_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legfecegreso_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegMegCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legmegcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegDescrip_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Megdescrip_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCatCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcatcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCatPueCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcatpuecod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSecCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legseccodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecDescrip_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Secdescrip_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLpgCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Leglpgcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LpgDescri_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Lpgdescri_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legbancod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanSuc_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legbansuc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegBanTipCuen_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legbantipcuen_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSinCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsincod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SinDescrip_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Sindescrip_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOsoCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legosocod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOsoAfipCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legosoafipcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OsoDescrip_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Osodescrip_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legactcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MprCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Mprcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCuentaBanc_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcuentabanc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicInicio_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Leglicinicio_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicFinal_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Leglicfinal_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ZonCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Zoncod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCBU_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legcbu_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Condicodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SinieCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Siniecodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegConveCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legconvecodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Tipemplecod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OsoC3992_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Osoc3992_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegReligion_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legreligion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOrigen_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legorigen_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPuesCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legpuescodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSucCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsuccodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegConveVersionCli_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legconveversioncli_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitRevEgreso_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legsitrevegreso_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegActClasNro_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legactclasnro_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPueAfiCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legpueaficod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegMigrWarn_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Legmigrwarn_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtLegajo_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLegajo_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtLegajo_Empnom, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtLegajo_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LegApellido", gxTv_SdtLegajo_Legapellido, false, includeNonInitialized);
      AddObjectProperty("LegNombre", gxTv_SdtLegajo_Legnombre, false, includeNonInitialized);
      AddObjectProperty("LegFoto", gxTv_SdtLegajo_Legfoto, false, includeNonInitialized);
      AddObjectProperty("LegFoto_N", gxTv_SdtLegajo_Legfoto_N, false, includeNonInitialized);
      if ( gxTv_SdtLegajo_Salario != null )
      {
         AddObjectProperty("Salario", gxTv_SdtLegajo_Salario, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtLegajo_Familia != null )
      {
         AddObjectProperty("Familia", gxTv_SdtLegajo_Familia, includeState, includeNonInitialized);
      }
      AddObjectProperty("LegFotoNom", gxTv_SdtLegajo_Legfotonom, false, includeNonInitialized);
      AddObjectProperty("LegFotoExt", gxTv_SdtLegajo_Legfotoext, false, includeNonInitialized);
      AddObjectProperty("LegTipDoc", gxTv_SdtLegajo_Legtipdoc, false, includeNonInitialized);
      AddObjectProperty("LegNumDoc", gxTv_SdtLegajo_Legnumdoc, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecNac", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegSexo", gxTv_SdtLegajo_Legsexo, false, includeNonInitialized);
      AddObjectProperty("LegSexo_N", gxTv_SdtLegajo_Legsexo_N, false, includeNonInitialized);
      AddObjectProperty("LegEstadoCivil", gxTv_SdtLegajo_Legestadocivil, false, includeNonInitialized);
      AddObjectProperty("LegEstadoCivil_N", gxTv_SdtLegajo_Legestadocivil_N, false, includeNonInitialized);
      AddObjectProperty("LegNacionCod", gxTv_SdtLegajo_Legnacioncod, false, includeNonInitialized);
      AddObjectProperty("LegNacionCod_N", gxTv_SdtLegajo_Legnacioncod_N, false, includeNonInitialized);
      AddObjectProperty("LegNacionalidad", gxTv_SdtLegajo_Legnacionalidad, false, includeNonInitialized);
      AddObjectProperty("LegCUIL", gxTv_SdtLegajo_Legcuil, false, includeNonInitialized);
      AddObjectProperty("LegDiscapacidad", gxTv_SdtLegajo_Legdiscapacidad, false, includeNonInitialized);
      AddObjectProperty("LegDomici", gxTv_SdtLegajo_Legdomici, false, includeNonInitialized);
      AddObjectProperty("LegEmail", gxTv_SdtLegajo_Legemail, false, includeNonInitialized);
      AddObjectProperty("LegCodPos", gxTv_SdtLegajo_Legcodpos, false, includeNonInitialized);
      AddObjectProperty("LegPaiCod", gxTv_SdtLegajo_Legpaicod, false, includeNonInitialized);
      AddObjectProperty("LegPaiCod_N", gxTv_SdtLegajo_Legpaicod_N, false, includeNonInitialized);
      AddObjectProperty("LegPaiNom", gxTv_SdtLegajo_Legpainom, false, includeNonInitialized);
      AddObjectProperty("LegProvCod", gxTv_SdtLegajo_Legprovcod, false, includeNonInitialized);
      AddObjectProperty("LegProvCod_N", gxTv_SdtLegajo_Legprovcod_N, false, includeNonInitialized);
      AddObjectProperty("LegProvNom", gxTv_SdtLegajo_Legprovnom, false, includeNonInitialized);
      AddObjectProperty("LegLocCod", gxTv_SdtLegajo_Legloccod, false, includeNonInitialized);
      AddObjectProperty("LegLocCod_N", gxTv_SdtLegajo_Legloccod_N, false, includeNonInitialized);
      AddObjectProperty("LegLocNom", gxTv_SdtLegajo_Leglocnom, false, includeNonInitialized);
      AddObjectProperty("LegTelefono", gxTv_SdtLegajo_Legtelefono, false, includeNonInitialized);
      AddObjectProperty("LegTelefono_N", gxTv_SdtLegajo_Legtelefono_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecIngreso", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecEgreso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegFecEgreso_N", gxTv_SdtLegajo_Legfecegreso_N, false, includeNonInitialized);
      AddObjectProperty("LegMegCodigo", gxTv_SdtLegajo_Legmegcodigo, false, includeNonInitialized);
      AddObjectProperty("LegMegCodigo_N", gxTv_SdtLegajo_Legmegcodigo_N, false, includeNonInitialized);
      AddObjectProperty("MegDescrip", gxTv_SdtLegajo_Megdescrip, false, includeNonInitialized);
      AddObjectProperty("MegDescrip_N", gxTv_SdtLegajo_Megdescrip_N, false, includeNonInitialized);
      AddObjectProperty("LegCatCodigo", gxTv_SdtLegajo_Legcatcodigo, false, includeNonInitialized);
      AddObjectProperty("LegCatCodigo_N", gxTv_SdtLegajo_Legcatcodigo_N, false, includeNonInitialized);
      AddObjectProperty("LegCatPueCod", gxTv_SdtLegajo_Legcatpuecod, false, includeNonInitialized);
      AddObjectProperty("LegCatPueCod_N", gxTv_SdtLegajo_Legcatpuecod_N, false, includeNonInitialized);
      AddObjectProperty("LegSecCodigo", gxTv_SdtLegajo_Legseccodigo, false, includeNonInitialized);
      AddObjectProperty("LegSecCodigo_N", gxTv_SdtLegajo_Legseccodigo_N, false, includeNonInitialized);
      AddObjectProperty("SecDescrip", gxTv_SdtLegajo_Secdescrip, false, includeNonInitialized);
      AddObjectProperty("SecDescrip_N", gxTv_SdtLegajo_Secdescrip_N, false, includeNonInitialized);
      AddObjectProperty("LegLpgCodigo", gxTv_SdtLegajo_Leglpgcodigo, false, includeNonInitialized);
      AddObjectProperty("LegLpgCodigo_N", gxTv_SdtLegajo_Leglpgcodigo_N, false, includeNonInitialized);
      AddObjectProperty("LpgDescri", gxTv_SdtLegajo_Lpgdescri, false, includeNonInitialized);
      AddObjectProperty("LpgDescri_N", gxTv_SdtLegajo_Lpgdescri_N, false, includeNonInitialized);
      AddObjectProperty("LegClase", gxTv_SdtLegajo_Legclase, false, includeNonInitialized);
      AddObjectProperty("LegBasico", gxTv_SdtLegajo_Legbasico, false, includeNonInitialized);
      AddObjectProperty("LegFormaPago", gxTv_SdtLegajo_Legformapago, false, includeNonInitialized);
      AddObjectProperty("LegBanCod", gxTv_SdtLegajo_Legbancod, false, includeNonInitialized);
      AddObjectProperty("LegBanCod_N", gxTv_SdtLegajo_Legbancod_N, false, includeNonInitialized);
      AddObjectProperty("LegBanDes", gxTv_SdtLegajo_Legbandes, false, includeNonInitialized);
      AddObjectProperty("LegBanSuc", gxTv_SdtLegajo_Legbansuc, false, includeNonInitialized);
      AddObjectProperty("LegBanSuc_N", gxTv_SdtLegajo_Legbansuc_N, false, includeNonInitialized);
      AddObjectProperty("LegBanTipCuen", gxTv_SdtLegajo_Legbantipcuen, false, includeNonInitialized);
      AddObjectProperty("LegBanTipCuen_N", gxTv_SdtLegajo_Legbantipcuen_N, false, includeNonInitialized);
      AddObjectProperty("LegSinCod", gxTv_SdtLegajo_Legsincod, false, includeNonInitialized);
      AddObjectProperty("LegSinCod_N", gxTv_SdtLegajo_Legsincod_N, false, includeNonInitialized);
      AddObjectProperty("SinDescrip", gxTv_SdtLegajo_Sindescrip, false, includeNonInitialized);
      AddObjectProperty("SinDescrip_N", gxTv_SdtLegajo_Sindescrip_N, false, includeNonInitialized);
      AddObjectProperty("LegOsoCod", gxTv_SdtLegajo_Legosocod, false, includeNonInitialized);
      AddObjectProperty("LegOsoCod_N", gxTv_SdtLegajo_Legosocod_N, false, includeNonInitialized);
      AddObjectProperty("LegOsoDes", gxTv_SdtLegajo_Legosodes, false, includeNonInitialized);
      AddObjectProperty("LegOsoAfipCod", gxTv_SdtLegajo_Legosoafipcod, false, includeNonInitialized);
      AddObjectProperty("LegOsoAfipCod_N", gxTv_SdtLegajo_Legosoafipcod_N, false, includeNonInitialized);
      AddObjectProperty("OsoDescrip", gxTv_SdtLegajo_Osodescrip, false, includeNonInitialized);
      AddObjectProperty("OsoDescrip_N", gxTv_SdtLegajo_Osodescrip_N, false, includeNonInitialized);
      AddObjectProperty("LegActCodigo", gxTv_SdtLegajo_Legactcodigo, false, includeNonInitialized);
      AddObjectProperty("LegActCodigo_N", gxTv_SdtLegajo_Legactcodigo_N, false, includeNonInitialized);
      AddObjectProperty("LegActDescri", gxTv_SdtLegajo_Legactdescri, false, includeNonInitialized);
      AddObjectProperty("MprCod", gxTv_SdtLegajo_Mprcod, false, includeNonInitialized);
      AddObjectProperty("MprCod_N", gxTv_SdtLegajo_Mprcod_N, false, includeNonInitialized);
      AddObjectProperty("MprDescrip", gxTv_SdtLegajo_Mprdescrip, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecUltMod", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegCuentaBanc", gxTv_SdtLegajo_Legcuentabanc, false, includeNonInitialized);
      AddObjectProperty("LegCuentaBanc_N", gxTv_SdtLegajo_Legcuentabanc_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicinicio), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicInicio", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegLicInicio_N", gxTv_SdtLegajo_Leglicinicio_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicfinal), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicFinal", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegLicFinal_N", gxTv_SdtLegajo_Leglicfinal_N, false, includeNonInitialized);
      AddObjectProperty("ZonCod", gxTv_SdtLegajo_Zoncod, false, includeNonInitialized);
      AddObjectProperty("ZonCod_N", gxTv_SdtLegajo_Zoncod_N, false, includeNonInitialized);
      AddObjectProperty("ZonDescrip", gxTv_SdtLegajo_Zondescrip, false, includeNonInitialized);
      AddObjectProperty("ZonPorcReduc", gxTv_SdtLegajo_Zonporcreduc, false, includeNonInitialized);
      AddObjectProperty("LegCBU", gxTv_SdtLegajo_Legcbu, false, includeNonInitialized);
      AddObjectProperty("LegCBU_N", gxTv_SdtLegajo_Legcbu_N, false, includeNonInitialized);
      AddObjectProperty("LegConvenio", gxTv_SdtLegajo_Legconvenio, false, includeNonInitialized);
      AddObjectProperty("LegSCVO", gxTv_SdtLegajo_Legscvo, false, includeNonInitialized);
      AddObjectProperty("CondiCodigo", gxTv_SdtLegajo_Condicodigo, false, includeNonInitialized);
      AddObjectProperty("CondiCodigo_N", gxTv_SdtLegajo_Condicodigo_N, false, includeNonInitialized);
      AddObjectProperty("CondiDescri", gxTv_SdtLegajo_Condidescri, false, includeNonInitialized);
      AddObjectProperty("SinieCodigo", gxTv_SdtLegajo_Siniecodigo, false, includeNonInitialized);
      AddObjectProperty("SinieCodigo_N", gxTv_SdtLegajo_Siniecodigo_N, false, includeNonInitialized);
      AddObjectProperty("SinieDescri", gxTv_SdtLegajo_Siniedescri, false, includeNonInitialized);
      AddObjectProperty("LegActivo", gxTv_SdtLegajo_Legactivo, false, includeNonInitialized);
      AddObjectProperty("LegSueldoFuera", gxTv_SdtLegajo_Legsueldofuera, false, includeNonInitialized);
      AddObjectProperty("LegId", gxTv_SdtLegajo_Legid, false, includeNonInitialized);
      AddObjectProperty("LegId_N", gxTv_SdtLegajo_Legid_N, false, includeNonInitialized);
      AddObjectProperty("LegConveCodigo", gxTv_SdtLegajo_Legconvecodigo, false, includeNonInitialized);
      AddObjectProperty("LegConveCodigo_N", gxTv_SdtLegajo_Legconvecodigo_N, false, includeNonInitialized);
      AddObjectProperty("LegIdNomApe", gxTv_SdtLegajo_Legidnomape, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod", gxTv_SdtLegajo_Tipemplecod, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod_N", gxTv_SdtLegajo_Tipemplecod_N, false, includeNonInitialized);
      AddObjectProperty("OsoC3992", gxTv_SdtLegajo_Osoc3992, false, includeNonInitialized);
      AddObjectProperty("OsoC3992_N", gxTv_SdtLegajo_Osoc3992_N, false, includeNonInitialized);
      AddObjectProperty("LegObs", gxTv_SdtLegajo_Legobs, false, includeNonInitialized);
      AddObjectProperty("LegNomApe", gxTv_SdtLegajo_Legnomape, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtLegajo_Legfecimportacion ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecImportacion", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegAgenReten", gxTv_SdtLegajo_Legagenreten, false, includeNonInitialized);
      AddObjectProperty("LegContinua", gxTv_SdtLegajo_Legcontinua, false, includeNonInitialized);
      AddObjectProperty("LegRecalcLiq", gxTv_SdtLegajo_Legrecalcliq, false, includeNonInitialized);
      AddObjectProperty("LegJubilado", gxTv_SdtLegajo_Legjubilado, false, includeNonInitialized);
      AddObjectProperty("LegHorasDia", gxTv_SdtLegajo_Leghorasdia, false, includeNonInitialized);
      AddObjectProperty("LegHorasSem", gxTv_SdtLegajo_Leghorassem, false, includeNonInitialized);
      AddObjectProperty("LegReligion", gxTv_SdtLegajo_Legreligion, false, includeNonInitialized);
      AddObjectProperty("LegReligion_N", gxTv_SdtLegajo_Legreligion_N, false, includeNonInitialized);
      AddObjectProperty("LegOrigen", gxTv_SdtLegajo_Legorigen, false, includeNonInitialized);
      AddObjectProperty("LegOrigen_N", gxTv_SdtLegajo_Legorigen_N, false, includeNonInitialized);
      AddObjectProperty("LegPuesCodigo", gxTv_SdtLegajo_Legpuescodigo, false, includeNonInitialized);
      AddObjectProperty("LegPuesCodigo_N", gxTv_SdtLegajo_Legpuescodigo_N, false, includeNonInitialized);
      AddObjectProperty("LegSucCodigo", gxTv_SdtLegajo_Legsuccodigo, false, includeNonInitialized);
      AddObjectProperty("LegSucCodigo_N", gxTv_SdtLegajo_Legsuccodigo_N, false, includeNonInitialized);
      AddObjectProperty("LegTrabLun", gxTv_SdtLegajo_Legtrablun, false, includeNonInitialized);
      AddObjectProperty("LegTrabMar", gxTv_SdtLegajo_Legtrabmar, false, includeNonInitialized);
      AddObjectProperty("LegTrabMie", gxTv_SdtLegajo_Legtrabmie, false, includeNonInitialized);
      AddObjectProperty("LegTrabJue", gxTv_SdtLegajo_Legtrabjue, false, includeNonInitialized);
      AddObjectProperty("LegTrabVie", gxTv_SdtLegajo_Legtrabvie, false, includeNonInitialized);
      AddObjectProperty("LegTrabSa", gxTv_SdtLegajo_Legtrabsa, false, includeNonInitialized);
      AddObjectProperty("LegTrabDo", gxTv_SdtLegajo_Legtrabdo, false, includeNonInitialized);
      if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
      {
         AddObjectProperty("tipos_de_trabajo", gxTv_SdtLegajo_Tipos_de_trabajo, includeState, includeNonInitialized);
      }
      AddObjectProperty("LegVacPend", gxTv_SdtLegajo_Legvacpend, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecpreaviso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecPreAviso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegConveVersionCli", gxTv_SdtLegajo_Legconveversioncli, false, includeNonInitialized);
      AddObjectProperty("LegConveVersionCli_N", gxTv_SdtLegajo_Legconveversioncli_N, false, includeNonInitialized);
      AddObjectProperty("LegSitRevEgreso", gxTv_SdtLegajo_Legsitrevegreso, false, includeNonInitialized);
      AddObjectProperty("LegSitRevEgreso_N", gxTv_SdtLegajo_Legsitrevegreso_N, false, includeNonInitialized);
      AddObjectProperty("LegPromDias", gxTv_SdtLegajo_Legpromdias, false, includeNonInitialized);
      AddObjectProperty("LegTitulo", gxTv_SdtLegajo_Legtitulo, false, includeNonInitialized);
      AddObjectProperty("LegEstado", gxTv_SdtLegajo_Legestado, false, includeNonInitialized);
      AddObjectProperty("LegActClasNro", gxTv_SdtLegajo_Legactclasnro, false, includeNonInitialized);
      AddObjectProperty("LegActClasNro_N", gxTv_SdtLegajo_Legactclasnro_N, false, includeNonInitialized);
      AddObjectProperty("LegPueAfiCod", gxTv_SdtLegajo_Legpueaficod, false, includeNonInitialized);
      AddObjectProperty("LegPueAfiCod_N", gxTv_SdtLegajo_Legpueaficod_N, false, includeNonInitialized);
      AddObjectProperty("LegMigrWarn", gxTv_SdtLegajo_Legmigrwarn, false, includeNonInitialized);
      AddObjectProperty("LegMigrWarn_N", gxTv_SdtLegajo_Legmigrwarn_N, false, includeNonInitialized);
      AddObjectProperty("LegIncompleto", gxTv_SdtLegajo_Legincompleto, false, includeNonInitialized);
      AddObjectProperty("LegLiqApo", gxTv_SdtLegajo_Legliqapo, false, includeNonInitialized);
      if ( gxTv_SdtLegajo_Propiedades != null )
      {
         AddObjectProperty("Propiedades", gxTv_SdtLegajo_Propiedades, includeState, includeNonInitialized);
      }
      AddObjectProperty("LegModTra", gxTv_SdtLegajo_Legmodtra, false, includeNonInitialized);
      AddObjectProperty("LegTipoTarifa", gxTv_SdtLegajo_Legtipotarifa, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLegajo_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLegajo_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtLegajo_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtLegajo_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LegApellido_Z", gxTv_SdtLegajo_Legapellido_Z, false, includeNonInitialized);
         AddObjectProperty("LegNombre_Z", gxTv_SdtLegajo_Legnombre_Z, false, includeNonInitialized);
         AddObjectProperty("LegFotoNom_Z", gxTv_SdtLegajo_Legfotonom_Z, false, includeNonInitialized);
         AddObjectProperty("LegFotoExt_Z", gxTv_SdtLegajo_Legfotoext_Z, false, includeNonInitialized);
         AddObjectProperty("LegTipDoc_Z", gxTv_SdtLegajo_Legtipdoc_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumDoc_Z", gxTv_SdtLegajo_Legnumdoc_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecNac_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegSexo_Z", gxTv_SdtLegajo_Legsexo_Z, false, includeNonInitialized);
         AddObjectProperty("LegEstadoCivil_Z", gxTv_SdtLegajo_Legestadocivil_Z, false, includeNonInitialized);
         AddObjectProperty("LegNacionCod_Z", gxTv_SdtLegajo_Legnacioncod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNacionalidad_Z", gxTv_SdtLegajo_Legnacionalidad_Z, false, includeNonInitialized);
         AddObjectProperty("LegCUIL_Z", gxTv_SdtLegajo_Legcuil_Z, false, includeNonInitialized);
         AddObjectProperty("LegDiscapacidad_Z", gxTv_SdtLegajo_Legdiscapacidad_Z, false, includeNonInitialized);
         AddObjectProperty("LegDomici_Z", gxTv_SdtLegajo_Legdomici_Z, false, includeNonInitialized);
         AddObjectProperty("LegEmail_Z", gxTv_SdtLegajo_Legemail_Z, false, includeNonInitialized);
         AddObjectProperty("LegCodPos_Z", gxTv_SdtLegajo_Legcodpos_Z, false, includeNonInitialized);
         AddObjectProperty("LegPaiCod_Z", gxTv_SdtLegajo_Legpaicod_Z, false, includeNonInitialized);
         AddObjectProperty("LegPaiNom_Z", gxTv_SdtLegajo_Legpainom_Z, false, includeNonInitialized);
         AddObjectProperty("LegProvCod_Z", gxTv_SdtLegajo_Legprovcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegProvNom_Z", gxTv_SdtLegajo_Legprovnom_Z, false, includeNonInitialized);
         AddObjectProperty("LegLocCod_Z", gxTv_SdtLegajo_Legloccod_Z, false, includeNonInitialized);
         AddObjectProperty("LegLocNom_Z", gxTv_SdtLegajo_Leglocnom_Z, false, includeNonInitialized);
         AddObjectProperty("LegTelefono_Z", gxTv_SdtLegajo_Legtelefono_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecIngreso_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecEgreso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegMegCodigo_Z", gxTv_SdtLegajo_Legmegcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("MegDescrip_Z", gxTv_SdtLegajo_Megdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegCatCodigo_Z", gxTv_SdtLegajo_Legcatcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegCatPueCod_Z", gxTv_SdtLegajo_Legcatpuecod_Z, false, includeNonInitialized);
         AddObjectProperty("LegSecCodigo_Z", gxTv_SdtLegajo_Legseccodigo_Z, false, includeNonInitialized);
         AddObjectProperty("SecDescrip_Z", gxTv_SdtLegajo_Secdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLpgCodigo_Z", gxTv_SdtLegajo_Leglpgcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LpgDescri_Z", gxTv_SdtLegajo_Lpgdescri_Z, false, includeNonInitialized);
         AddObjectProperty("LegClase_Z", gxTv_SdtLegajo_Legclase_Z, false, includeNonInitialized);
         AddObjectProperty("LegBasico_Z", gxTv_SdtLegajo_Legbasico_Z, false, includeNonInitialized);
         AddObjectProperty("LegFormaPago_Z", gxTv_SdtLegajo_Legformapago_Z, false, includeNonInitialized);
         AddObjectProperty("LegBanCod_Z", gxTv_SdtLegajo_Legbancod_Z, false, includeNonInitialized);
         AddObjectProperty("LegBanDes_Z", gxTv_SdtLegajo_Legbandes_Z, false, includeNonInitialized);
         AddObjectProperty("LegBanSuc_Z", gxTv_SdtLegajo_Legbansuc_Z, false, includeNonInitialized);
         AddObjectProperty("LegBanTipCuen_Z", gxTv_SdtLegajo_Legbantipcuen_Z, false, includeNonInitialized);
         AddObjectProperty("LegSinCod_Z", gxTv_SdtLegajo_Legsincod_Z, false, includeNonInitialized);
         AddObjectProperty("SinDescrip_Z", gxTv_SdtLegajo_Sindescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegOsoCod_Z", gxTv_SdtLegajo_Legosocod_Z, false, includeNonInitialized);
         AddObjectProperty("LegOsoDes_Z", gxTv_SdtLegajo_Legosodes_Z, false, includeNonInitialized);
         AddObjectProperty("LegOsoAfipCod_Z", gxTv_SdtLegajo_Legosoafipcod_Z, false, includeNonInitialized);
         AddObjectProperty("OsoDescrip_Z", gxTv_SdtLegajo_Osodescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegActCodigo_Z", gxTv_SdtLegajo_Legactcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegActDescri_Z", gxTv_SdtLegajo_Legactdescri_Z, false, includeNonInitialized);
         AddObjectProperty("MprCod_Z", gxTv_SdtLegajo_Mprcod_Z, false, includeNonInitialized);
         AddObjectProperty("MprDescrip_Z", gxTv_SdtLegajo_Mprdescrip_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecUltMod_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegCuentaBanc_Z", gxTv_SdtLegajo_Legcuentabanc_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicinicio_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicInicio_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Leglicfinal_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicFinal_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ZonCod_Z", gxTv_SdtLegajo_Zoncod_Z, false, includeNonInitialized);
         AddObjectProperty("ZonDescrip_Z", gxTv_SdtLegajo_Zondescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ZonPorcReduc_Z", gxTv_SdtLegajo_Zonporcreduc_Z, false, includeNonInitialized);
         AddObjectProperty("LegCBU_Z", gxTv_SdtLegajo_Legcbu_Z, false, includeNonInitialized);
         AddObjectProperty("LegConvenio_Z", gxTv_SdtLegajo_Legconvenio_Z, false, includeNonInitialized);
         AddObjectProperty("LegSCVO_Z", gxTv_SdtLegajo_Legscvo_Z, false, includeNonInitialized);
         AddObjectProperty("CondiCodigo_Z", gxTv_SdtLegajo_Condicodigo_Z, false, includeNonInitialized);
         AddObjectProperty("CondiDescri_Z", gxTv_SdtLegajo_Condidescri_Z, false, includeNonInitialized);
         AddObjectProperty("SinieCodigo_Z", gxTv_SdtLegajo_Siniecodigo_Z, false, includeNonInitialized);
         AddObjectProperty("SinieDescri_Z", gxTv_SdtLegajo_Siniedescri_Z, false, includeNonInitialized);
         AddObjectProperty("LegActivo_Z", gxTv_SdtLegajo_Legactivo_Z, false, includeNonInitialized);
         AddObjectProperty("LegSueldoFuera_Z", gxTv_SdtLegajo_Legsueldofuera_Z, false, includeNonInitialized);
         AddObjectProperty("LegId_Z", gxTv_SdtLegajo_Legid_Z, false, includeNonInitialized);
         AddObjectProperty("LegConveCodigo_Z", gxTv_SdtLegajo_Legconvecodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegIdNomApe_Z", gxTv_SdtLegajo_Legidnomape_Z, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_Z", gxTv_SdtLegajo_Tipemplecod_Z, false, includeNonInitialized);
         AddObjectProperty("OsoC3992_Z", gxTv_SdtLegajo_Osoc3992_Z, false, includeNonInitialized);
         AddObjectProperty("LegNomApe_Z", gxTv_SdtLegajo_Legnomape_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtLegajo_Legfecimportacion_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecImportacion_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegAgenReten_Z", gxTv_SdtLegajo_Legagenreten_Z, false, includeNonInitialized);
         AddObjectProperty("LegContinua_Z", gxTv_SdtLegajo_Legcontinua_Z, false, includeNonInitialized);
         AddObjectProperty("LegRecalcLiq_Z", gxTv_SdtLegajo_Legrecalcliq_Z, false, includeNonInitialized);
         AddObjectProperty("LegJubilado_Z", gxTv_SdtLegajo_Legjubilado_Z, false, includeNonInitialized);
         AddObjectProperty("LegHorasDia_Z", gxTv_SdtLegajo_Leghorasdia_Z, false, includeNonInitialized);
         AddObjectProperty("LegHorasSem_Z", gxTv_SdtLegajo_Leghorassem_Z, false, includeNonInitialized);
         AddObjectProperty("LegReligion_Z", gxTv_SdtLegajo_Legreligion_Z, false, includeNonInitialized);
         AddObjectProperty("LegOrigen_Z", gxTv_SdtLegajo_Legorigen_Z, false, includeNonInitialized);
         AddObjectProperty("LegPuesCodigo_Z", gxTv_SdtLegajo_Legpuescodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegSucCodigo_Z", gxTv_SdtLegajo_Legsuccodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabLun_Z", gxTv_SdtLegajo_Legtrablun_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabMar_Z", gxTv_SdtLegajo_Legtrabmar_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabMie_Z", gxTv_SdtLegajo_Legtrabmie_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabJue_Z", gxTv_SdtLegajo_Legtrabjue_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabVie_Z", gxTv_SdtLegajo_Legtrabvie_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabSa_Z", gxTv_SdtLegajo_Legtrabsa_Z, false, includeNonInitialized);
         AddObjectProperty("LegTrabDo_Z", gxTv_SdtLegajo_Legtrabdo_Z, false, includeNonInitialized);
         AddObjectProperty("LegVacPend_Z", gxTv_SdtLegajo_Legvacpend_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Legfecpreaviso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecPreAviso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegConveVersionCli_Z", gxTv_SdtLegajo_Legconveversioncli_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitRevEgreso_Z", gxTv_SdtLegajo_Legsitrevegreso_Z, false, includeNonInitialized);
         AddObjectProperty("LegPromDias_Z", gxTv_SdtLegajo_Legpromdias_Z, false, includeNonInitialized);
         AddObjectProperty("LegTitulo_Z", gxTv_SdtLegajo_Legtitulo_Z, false, includeNonInitialized);
         AddObjectProperty("LegEstado_Z", gxTv_SdtLegajo_Legestado_Z, false, includeNonInitialized);
         AddObjectProperty("LegActClasNro_Z", gxTv_SdtLegajo_Legactclasnro_Z, false, includeNonInitialized);
         AddObjectProperty("LegPueAfiCod_Z", gxTv_SdtLegajo_Legpueaficod_Z, false, includeNonInitialized);
         AddObjectProperty("LegIncompleto_Z", gxTv_SdtLegajo_Legincompleto_Z, false, includeNonInitialized);
         AddObjectProperty("LegLiqApo_Z", gxTv_SdtLegajo_Legliqapo_Z, false, includeNonInitialized);
         AddObjectProperty("LegModTra_Z", gxTv_SdtLegajo_Legmodtra_Z, false, includeNonInitialized);
         AddObjectProperty("LegTipoTarifa_Z", gxTv_SdtLegajo_Legtipotarifa_Z, false, includeNonInitialized);
         AddObjectProperty("LegFoto_N", gxTv_SdtLegajo_Legfoto_N, false, includeNonInitialized);
         AddObjectProperty("LegSexo_N", gxTv_SdtLegajo_Legsexo_N, false, includeNonInitialized);
         AddObjectProperty("LegEstadoCivil_N", gxTv_SdtLegajo_Legestadocivil_N, false, includeNonInitialized);
         AddObjectProperty("LegNacionCod_N", gxTv_SdtLegajo_Legnacioncod_N, false, includeNonInitialized);
         AddObjectProperty("LegPaiCod_N", gxTv_SdtLegajo_Legpaicod_N, false, includeNonInitialized);
         AddObjectProperty("LegProvCod_N", gxTv_SdtLegajo_Legprovcod_N, false, includeNonInitialized);
         AddObjectProperty("LegLocCod_N", gxTv_SdtLegajo_Legloccod_N, false, includeNonInitialized);
         AddObjectProperty("LegTelefono_N", gxTv_SdtLegajo_Legtelefono_N, false, includeNonInitialized);
         AddObjectProperty("LegFecEgreso_N", gxTv_SdtLegajo_Legfecegreso_N, false, includeNonInitialized);
         AddObjectProperty("LegMegCodigo_N", gxTv_SdtLegajo_Legmegcodigo_N, false, includeNonInitialized);
         AddObjectProperty("MegDescrip_N", gxTv_SdtLegajo_Megdescrip_N, false, includeNonInitialized);
         AddObjectProperty("LegCatCodigo_N", gxTv_SdtLegajo_Legcatcodigo_N, false, includeNonInitialized);
         AddObjectProperty("LegCatPueCod_N", gxTv_SdtLegajo_Legcatpuecod_N, false, includeNonInitialized);
         AddObjectProperty("LegSecCodigo_N", gxTv_SdtLegajo_Legseccodigo_N, false, includeNonInitialized);
         AddObjectProperty("SecDescrip_N", gxTv_SdtLegajo_Secdescrip_N, false, includeNonInitialized);
         AddObjectProperty("LegLpgCodigo_N", gxTv_SdtLegajo_Leglpgcodigo_N, false, includeNonInitialized);
         AddObjectProperty("LpgDescri_N", gxTv_SdtLegajo_Lpgdescri_N, false, includeNonInitialized);
         AddObjectProperty("LegBanCod_N", gxTv_SdtLegajo_Legbancod_N, false, includeNonInitialized);
         AddObjectProperty("LegBanSuc_N", gxTv_SdtLegajo_Legbansuc_N, false, includeNonInitialized);
         AddObjectProperty("LegBanTipCuen_N", gxTv_SdtLegajo_Legbantipcuen_N, false, includeNonInitialized);
         AddObjectProperty("LegSinCod_N", gxTv_SdtLegajo_Legsincod_N, false, includeNonInitialized);
         AddObjectProperty("SinDescrip_N", gxTv_SdtLegajo_Sindescrip_N, false, includeNonInitialized);
         AddObjectProperty("LegOsoCod_N", gxTv_SdtLegajo_Legosocod_N, false, includeNonInitialized);
         AddObjectProperty("LegOsoAfipCod_N", gxTv_SdtLegajo_Legosoafipcod_N, false, includeNonInitialized);
         AddObjectProperty("OsoDescrip_N", gxTv_SdtLegajo_Osodescrip_N, false, includeNonInitialized);
         AddObjectProperty("LegActCodigo_N", gxTv_SdtLegajo_Legactcodigo_N, false, includeNonInitialized);
         AddObjectProperty("MprCod_N", gxTv_SdtLegajo_Mprcod_N, false, includeNonInitialized);
         AddObjectProperty("LegCuentaBanc_N", gxTv_SdtLegajo_Legcuentabanc_N, false, includeNonInitialized);
         AddObjectProperty("LegLicInicio_N", gxTv_SdtLegajo_Leglicinicio_N, false, includeNonInitialized);
         AddObjectProperty("LegLicFinal_N", gxTv_SdtLegajo_Leglicfinal_N, false, includeNonInitialized);
         AddObjectProperty("ZonCod_N", gxTv_SdtLegajo_Zoncod_N, false, includeNonInitialized);
         AddObjectProperty("LegCBU_N", gxTv_SdtLegajo_Legcbu_N, false, includeNonInitialized);
         AddObjectProperty("CondiCodigo_N", gxTv_SdtLegajo_Condicodigo_N, false, includeNonInitialized);
         AddObjectProperty("SinieCodigo_N", gxTv_SdtLegajo_Siniecodigo_N, false, includeNonInitialized);
         AddObjectProperty("LegId_N", gxTv_SdtLegajo_Legid_N, false, includeNonInitialized);
         AddObjectProperty("LegConveCodigo_N", gxTv_SdtLegajo_Legconvecodigo_N, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_N", gxTv_SdtLegajo_Tipemplecod_N, false, includeNonInitialized);
         AddObjectProperty("OsoC3992_N", gxTv_SdtLegajo_Osoc3992_N, false, includeNonInitialized);
         AddObjectProperty("LegReligion_N", gxTv_SdtLegajo_Legreligion_N, false, includeNonInitialized);
         AddObjectProperty("LegOrigen_N", gxTv_SdtLegajo_Legorigen_N, false, includeNonInitialized);
         AddObjectProperty("LegPuesCodigo_N", gxTv_SdtLegajo_Legpuescodigo_N, false, includeNonInitialized);
         AddObjectProperty("LegSucCodigo_N", gxTv_SdtLegajo_Legsuccodigo_N, false, includeNonInitialized);
         AddObjectProperty("LegConveVersionCli_N", gxTv_SdtLegajo_Legconveversioncli_N, false, includeNonInitialized);
         AddObjectProperty("LegSitRevEgreso_N", gxTv_SdtLegajo_Legsitrevegreso_N, false, includeNonInitialized);
         AddObjectProperty("LegActClasNro_N", gxTv_SdtLegajo_Legactclasnro_N, false, includeNonInitialized);
         AddObjectProperty("LegPueAfiCod_N", gxTv_SdtLegajo_Legpueaficod_N, false, includeNonInitialized);
         AddObjectProperty("LegMigrWarn_N", gxTv_SdtLegajo_Legmigrwarn_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Clicod = sdt.getgxTv_SdtLegajo_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Empcod = sdt.getgxTv_SdtLegajo_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Empnom = sdt.getgxTv_SdtLegajo_Empnom() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnumero = sdt.getgxTv_SdtLegajo_Legnumero() ;
      }
      if ( sdt.IsDirty("LegApellido") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legapellido = sdt.getgxTv_SdtLegajo_Legapellido() ;
      }
      if ( sdt.IsDirty("LegNombre") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnombre = sdt.getgxTv_SdtLegajo_Legnombre() ;
      }
      if ( sdt.IsDirty("LegFoto") )
      {
         gxTv_SdtLegajo_Legfoto_N = sdt.getgxTv_SdtLegajo_Legfoto_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfoto = sdt.getgxTv_SdtLegajo_Legfoto() ;
      }
      if ( gxTv_SdtLegajo_Salario != null )
      {
         GXBCLevelCollection<web.SdtLegajo_Salario> newCollectionSalario = sdt.getgxTv_SdtLegajo_Salario();
         web.SdtLegajo_Salario currItemSalario;
         web.SdtLegajo_Salario newItemSalario;
         short idx = 1;
         while ( idx <= newCollectionSalario.size() )
         {
            newItemSalario = (web.SdtLegajo_Salario)((web.SdtLegajo_Salario)newCollectionSalario.elementAt(-1+idx));
            currItemSalario = (web.SdtLegajo_Salario)gxTv_SdtLegajo_Salario.getByKey(newItemSalario.getgxTv_SdtLegajo_Salario_Legsuelsec());
            if ( GXutil.strcmp(currItemSalario.getgxTv_SdtLegajo_Salario_Mode(), "UPD") == 0 )
            {
               currItemSalario.updateDirties(newItemSalario);
               if ( GXutil.strcmp(newItemSalario.getgxTv_SdtLegajo_Salario_Mode(), "DLT") == 0 )
               {
                  currItemSalario.setgxTv_SdtLegajo_Salario_Mode( "DLT" );
               }
               currItemSalario.setgxTv_SdtLegajo_Salario_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtLegajo_Salario.add(newItemSalario, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtLegajo_Familia != null )
      {
         GXBCLevelCollection<web.SdtLegajo_Familia> newCollectionFamilia = sdt.getgxTv_SdtLegajo_Familia();
         web.SdtLegajo_Familia currItemFamilia;
         web.SdtLegajo_Familia newItemFamilia;
         short idx = 1;
         while ( idx <= newCollectionFamilia.size() )
         {
            newItemFamilia = (web.SdtLegajo_Familia)((web.SdtLegajo_Familia)newCollectionFamilia.elementAt(-1+idx));
            currItemFamilia = (web.SdtLegajo_Familia)gxTv_SdtLegajo_Familia.getByKey(newItemFamilia.getgxTv_SdtLegajo_Familia_Legorden());
            if ( GXutil.strcmp(currItemFamilia.getgxTv_SdtLegajo_Familia_Mode(), "UPD") == 0 )
            {
               currItemFamilia.updateDirties(newItemFamilia);
               if ( GXutil.strcmp(newItemFamilia.getgxTv_SdtLegajo_Familia_Mode(), "DLT") == 0 )
               {
                  currItemFamilia.setgxTv_SdtLegajo_Familia_Mode( "DLT" );
               }
               currItemFamilia.setgxTv_SdtLegajo_Familia_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtLegajo_Familia.add(newItemFamilia, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("LegFotoNom") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfotonom = sdt.getgxTv_SdtLegajo_Legfotonom() ;
      }
      if ( sdt.IsDirty("LegFotoExt") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfotoext = sdt.getgxTv_SdtLegajo_Legfotoext() ;
      }
      if ( sdt.IsDirty("LegTipDoc") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtipdoc = sdt.getgxTv_SdtLegajo_Legtipdoc() ;
      }
      if ( sdt.IsDirty("LegNumDoc") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnumdoc = sdt.getgxTv_SdtLegajo_Legnumdoc() ;
      }
      if ( sdt.IsDirty("LegFecNac") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecnac = sdt.getgxTv_SdtLegajo_Legfecnac() ;
      }
      if ( sdt.IsDirty("LegSexo") )
      {
         gxTv_SdtLegajo_Legsexo_N = sdt.getgxTv_SdtLegajo_Legsexo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legsexo = sdt.getgxTv_SdtLegajo_Legsexo() ;
      }
      if ( sdt.IsDirty("LegEstadoCivil") )
      {
         gxTv_SdtLegajo_Legestadocivil_N = sdt.getgxTv_SdtLegajo_Legestadocivil_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legestadocivil = sdt.getgxTv_SdtLegajo_Legestadocivil() ;
      }
      if ( sdt.IsDirty("LegNacionCod") )
      {
         gxTv_SdtLegajo_Legnacioncod_N = sdt.getgxTv_SdtLegajo_Legnacioncod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnacioncod = sdt.getgxTv_SdtLegajo_Legnacioncod() ;
      }
      if ( sdt.IsDirty("LegNacionalidad") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnacionalidad = sdt.getgxTv_SdtLegajo_Legnacionalidad() ;
      }
      if ( sdt.IsDirty("LegCUIL") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcuil = sdt.getgxTv_SdtLegajo_Legcuil() ;
      }
      if ( sdt.IsDirty("LegDiscapacidad") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legdiscapacidad = sdt.getgxTv_SdtLegajo_Legdiscapacidad() ;
      }
      if ( sdt.IsDirty("LegDomici") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legdomici = sdt.getgxTv_SdtLegajo_Legdomici() ;
      }
      if ( sdt.IsDirty("LegEmail") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legemail = sdt.getgxTv_SdtLegajo_Legemail() ;
      }
      if ( sdt.IsDirty("LegCodPos") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcodpos = sdt.getgxTv_SdtLegajo_Legcodpos() ;
      }
      if ( sdt.IsDirty("LegPaiCod") )
      {
         gxTv_SdtLegajo_Legpaicod_N = sdt.getgxTv_SdtLegajo_Legpaicod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legpaicod = sdt.getgxTv_SdtLegajo_Legpaicod() ;
      }
      if ( sdt.IsDirty("LegPaiNom") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legpainom = sdt.getgxTv_SdtLegajo_Legpainom() ;
      }
      if ( sdt.IsDirty("LegProvCod") )
      {
         gxTv_SdtLegajo_Legprovcod_N = sdt.getgxTv_SdtLegajo_Legprovcod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legprovcod = sdt.getgxTv_SdtLegajo_Legprovcod() ;
      }
      if ( sdt.IsDirty("LegProvNom") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legprovnom = sdt.getgxTv_SdtLegajo_Legprovnom() ;
      }
      if ( sdt.IsDirty("LegLocCod") )
      {
         gxTv_SdtLegajo_Legloccod_N = sdt.getgxTv_SdtLegajo_Legloccod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legloccod = sdt.getgxTv_SdtLegajo_Legloccod() ;
      }
      if ( sdt.IsDirty("LegLocNom") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leglocnom = sdt.getgxTv_SdtLegajo_Leglocnom() ;
      }
      if ( sdt.IsDirty("LegTelefono") )
      {
         gxTv_SdtLegajo_Legtelefono_N = sdt.getgxTv_SdtLegajo_Legtelefono_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtelefono = sdt.getgxTv_SdtLegajo_Legtelefono() ;
      }
      if ( sdt.IsDirty("LegFecIngreso") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecingreso = sdt.getgxTv_SdtLegajo_Legfecingreso() ;
      }
      if ( sdt.IsDirty("LegFecEgreso") )
      {
         gxTv_SdtLegajo_Legfecegreso_N = sdt.getgxTv_SdtLegajo_Legfecegreso_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecegreso = sdt.getgxTv_SdtLegajo_Legfecegreso() ;
      }
      if ( sdt.IsDirty("LegMegCodigo") )
      {
         gxTv_SdtLegajo_Legmegcodigo_N = sdt.getgxTv_SdtLegajo_Legmegcodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legmegcodigo = sdt.getgxTv_SdtLegajo_Legmegcodigo() ;
      }
      if ( sdt.IsDirty("MegDescrip") )
      {
         gxTv_SdtLegajo_Megdescrip_N = sdt.getgxTv_SdtLegajo_Megdescrip_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Megdescrip = sdt.getgxTv_SdtLegajo_Megdescrip() ;
      }
      if ( sdt.IsDirty("LegCatCodigo") )
      {
         gxTv_SdtLegajo_Legcatcodigo_N = sdt.getgxTv_SdtLegajo_Legcatcodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcatcodigo = sdt.getgxTv_SdtLegajo_Legcatcodigo() ;
      }
      if ( sdt.IsDirty("LegCatPueCod") )
      {
         gxTv_SdtLegajo_Legcatpuecod_N = sdt.getgxTv_SdtLegajo_Legcatpuecod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcatpuecod = sdt.getgxTv_SdtLegajo_Legcatpuecod() ;
      }
      if ( sdt.IsDirty("LegSecCodigo") )
      {
         gxTv_SdtLegajo_Legseccodigo_N = sdt.getgxTv_SdtLegajo_Legseccodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legseccodigo = sdt.getgxTv_SdtLegajo_Legseccodigo() ;
      }
      if ( sdt.IsDirty("SecDescrip") )
      {
         gxTv_SdtLegajo_Secdescrip_N = sdt.getgxTv_SdtLegajo_Secdescrip_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Secdescrip = sdt.getgxTv_SdtLegajo_Secdescrip() ;
      }
      if ( sdt.IsDirty("LegLpgCodigo") )
      {
         gxTv_SdtLegajo_Leglpgcodigo_N = sdt.getgxTv_SdtLegajo_Leglpgcodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leglpgcodigo = sdt.getgxTv_SdtLegajo_Leglpgcodigo() ;
      }
      if ( sdt.IsDirty("LpgDescri") )
      {
         gxTv_SdtLegajo_Lpgdescri_N = sdt.getgxTv_SdtLegajo_Lpgdescri_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Lpgdescri = sdt.getgxTv_SdtLegajo_Lpgdescri() ;
      }
      if ( sdt.IsDirty("LegClase") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legclase = sdt.getgxTv_SdtLegajo_Legclase() ;
      }
      if ( sdt.IsDirty("LegBasico") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legbasico = sdt.getgxTv_SdtLegajo_Legbasico() ;
      }
      if ( sdt.IsDirty("LegFormaPago") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legformapago = sdt.getgxTv_SdtLegajo_Legformapago() ;
      }
      if ( sdt.IsDirty("LegBanCod") )
      {
         gxTv_SdtLegajo_Legbancod_N = sdt.getgxTv_SdtLegajo_Legbancod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legbancod = sdt.getgxTv_SdtLegajo_Legbancod() ;
      }
      if ( sdt.IsDirty("LegBanDes") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legbandes = sdt.getgxTv_SdtLegajo_Legbandes() ;
      }
      if ( sdt.IsDirty("LegBanSuc") )
      {
         gxTv_SdtLegajo_Legbansuc_N = sdt.getgxTv_SdtLegajo_Legbansuc_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legbansuc = sdt.getgxTv_SdtLegajo_Legbansuc() ;
      }
      if ( sdt.IsDirty("LegBanTipCuen") )
      {
         gxTv_SdtLegajo_Legbantipcuen_N = sdt.getgxTv_SdtLegajo_Legbantipcuen_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legbantipcuen = sdt.getgxTv_SdtLegajo_Legbantipcuen() ;
      }
      if ( sdt.IsDirty("LegSinCod") )
      {
         gxTv_SdtLegajo_Legsincod_N = sdt.getgxTv_SdtLegajo_Legsincod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legsincod = sdt.getgxTv_SdtLegajo_Legsincod() ;
      }
      if ( sdt.IsDirty("SinDescrip") )
      {
         gxTv_SdtLegajo_Sindescrip_N = sdt.getgxTv_SdtLegajo_Sindescrip_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Sindescrip = sdt.getgxTv_SdtLegajo_Sindescrip() ;
      }
      if ( sdt.IsDirty("LegOsoCod") )
      {
         gxTv_SdtLegajo_Legosocod_N = sdt.getgxTv_SdtLegajo_Legosocod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legosocod = sdt.getgxTv_SdtLegajo_Legosocod() ;
      }
      if ( sdt.IsDirty("LegOsoDes") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legosodes = sdt.getgxTv_SdtLegajo_Legosodes() ;
      }
      if ( sdt.IsDirty("LegOsoAfipCod") )
      {
         gxTv_SdtLegajo_Legosoafipcod_N = sdt.getgxTv_SdtLegajo_Legosoafipcod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legosoafipcod = sdt.getgxTv_SdtLegajo_Legosoafipcod() ;
      }
      if ( sdt.IsDirty("OsoDescrip") )
      {
         gxTv_SdtLegajo_Osodescrip_N = sdt.getgxTv_SdtLegajo_Osodescrip_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Osodescrip = sdt.getgxTv_SdtLegajo_Osodescrip() ;
      }
      if ( sdt.IsDirty("LegActCodigo") )
      {
         gxTv_SdtLegajo_Legactcodigo_N = sdt.getgxTv_SdtLegajo_Legactcodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legactcodigo = sdt.getgxTv_SdtLegajo_Legactcodigo() ;
      }
      if ( sdt.IsDirty("LegActDescri") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legactdescri = sdt.getgxTv_SdtLegajo_Legactdescri() ;
      }
      if ( sdt.IsDirty("MprCod") )
      {
         gxTv_SdtLegajo_Mprcod_N = sdt.getgxTv_SdtLegajo_Mprcod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Mprcod = sdt.getgxTv_SdtLegajo_Mprcod() ;
      }
      if ( sdt.IsDirty("MprDescrip") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Mprdescrip = sdt.getgxTv_SdtLegajo_Mprdescrip() ;
      }
      if ( sdt.IsDirty("LegFecUltMod") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecultmod = sdt.getgxTv_SdtLegajo_Legfecultmod() ;
      }
      if ( sdt.IsDirty("LegCuentaBanc") )
      {
         gxTv_SdtLegajo_Legcuentabanc_N = sdt.getgxTv_SdtLegajo_Legcuentabanc_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcuentabanc = sdt.getgxTv_SdtLegajo_Legcuentabanc() ;
      }
      if ( sdt.IsDirty("LegLicInicio") )
      {
         gxTv_SdtLegajo_Leglicinicio_N = sdt.getgxTv_SdtLegajo_Leglicinicio_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leglicinicio = sdt.getgxTv_SdtLegajo_Leglicinicio() ;
      }
      if ( sdt.IsDirty("LegLicFinal") )
      {
         gxTv_SdtLegajo_Leglicfinal_N = sdt.getgxTv_SdtLegajo_Leglicfinal_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leglicfinal = sdt.getgxTv_SdtLegajo_Leglicfinal() ;
      }
      if ( sdt.IsDirty("ZonCod") )
      {
         gxTv_SdtLegajo_Zoncod_N = sdt.getgxTv_SdtLegajo_Zoncod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Zoncod = sdt.getgxTv_SdtLegajo_Zoncod() ;
      }
      if ( sdt.IsDirty("ZonDescrip") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Zondescrip = sdt.getgxTv_SdtLegajo_Zondescrip() ;
      }
      if ( sdt.IsDirty("ZonPorcReduc") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Zonporcreduc = sdt.getgxTv_SdtLegajo_Zonporcreduc() ;
      }
      if ( sdt.IsDirty("LegCBU") )
      {
         gxTv_SdtLegajo_Legcbu_N = sdt.getgxTv_SdtLegajo_Legcbu_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcbu = sdt.getgxTv_SdtLegajo_Legcbu() ;
      }
      if ( sdt.IsDirty("LegConvenio") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legconvenio = sdt.getgxTv_SdtLegajo_Legconvenio() ;
      }
      if ( sdt.IsDirty("LegSCVO") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legscvo = sdt.getgxTv_SdtLegajo_Legscvo() ;
      }
      if ( sdt.IsDirty("CondiCodigo") )
      {
         gxTv_SdtLegajo_Condicodigo_N = sdt.getgxTv_SdtLegajo_Condicodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Condicodigo = sdt.getgxTv_SdtLegajo_Condicodigo() ;
      }
      if ( sdt.IsDirty("CondiDescri") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Condidescri = sdt.getgxTv_SdtLegajo_Condidescri() ;
      }
      if ( sdt.IsDirty("SinieCodigo") )
      {
         gxTv_SdtLegajo_Siniecodigo_N = sdt.getgxTv_SdtLegajo_Siniecodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Siniecodigo = sdt.getgxTv_SdtLegajo_Siniecodigo() ;
      }
      if ( sdt.IsDirty("SinieDescri") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Siniedescri = sdt.getgxTv_SdtLegajo_Siniedescri() ;
      }
      if ( sdt.IsDirty("LegActivo") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legactivo = sdt.getgxTv_SdtLegajo_Legactivo() ;
      }
      if ( sdt.IsDirty("LegSueldoFuera") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legsueldofuera = sdt.getgxTv_SdtLegajo_Legsueldofuera() ;
      }
      if ( sdt.IsDirty("LegId") )
      {
         gxTv_SdtLegajo_Legid_N = sdt.getgxTv_SdtLegajo_Legid_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legid = sdt.getgxTv_SdtLegajo_Legid() ;
      }
      if ( sdt.IsDirty("LegConveCodigo") )
      {
         gxTv_SdtLegajo_Legconvecodigo_N = sdt.getgxTv_SdtLegajo_Legconvecodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legconvecodigo = sdt.getgxTv_SdtLegajo_Legconvecodigo() ;
      }
      if ( sdt.IsDirty("LegIdNomApe") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legidnomape = sdt.getgxTv_SdtLegajo_Legidnomape() ;
      }
      if ( sdt.IsDirty("TipEmpleCod") )
      {
         gxTv_SdtLegajo_Tipemplecod_N = sdt.getgxTv_SdtLegajo_Tipemplecod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Tipemplecod = sdt.getgxTv_SdtLegajo_Tipemplecod() ;
      }
      if ( sdt.IsDirty("OsoC3992") )
      {
         gxTv_SdtLegajo_Osoc3992_N = sdt.getgxTv_SdtLegajo_Osoc3992_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Osoc3992 = sdt.getgxTv_SdtLegajo_Osoc3992() ;
      }
      if ( sdt.IsDirty("LegObs") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legobs = sdt.getgxTv_SdtLegajo_Legobs() ;
      }
      if ( sdt.IsDirty("LegNomApe") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legnomape = sdt.getgxTv_SdtLegajo_Legnomape() ;
      }
      if ( sdt.IsDirty("LegFecImportacion") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecimportacion = sdt.getgxTv_SdtLegajo_Legfecimportacion() ;
      }
      if ( sdt.IsDirty("LegAgenReten") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legagenreten = sdt.getgxTv_SdtLegajo_Legagenreten() ;
      }
      if ( sdt.IsDirty("LegContinua") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legcontinua = sdt.getgxTv_SdtLegajo_Legcontinua() ;
      }
      if ( sdt.IsDirty("LegRecalcLiq") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legrecalcliq = sdt.getgxTv_SdtLegajo_Legrecalcliq() ;
      }
      if ( sdt.IsDirty("LegJubilado") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legjubilado = sdt.getgxTv_SdtLegajo_Legjubilado() ;
      }
      if ( sdt.IsDirty("LegHorasDia") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leghorasdia = sdt.getgxTv_SdtLegajo_Leghorasdia() ;
      }
      if ( sdt.IsDirty("LegHorasSem") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Leghorassem = sdt.getgxTv_SdtLegajo_Leghorassem() ;
      }
      if ( sdt.IsDirty("LegReligion") )
      {
         gxTv_SdtLegajo_Legreligion_N = sdt.getgxTv_SdtLegajo_Legreligion_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legreligion = sdt.getgxTv_SdtLegajo_Legreligion() ;
      }
      if ( sdt.IsDirty("LegOrigen") )
      {
         gxTv_SdtLegajo_Legorigen_N = sdt.getgxTv_SdtLegajo_Legorigen_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legorigen = sdt.getgxTv_SdtLegajo_Legorigen() ;
      }
      if ( sdt.IsDirty("LegPuesCodigo") )
      {
         gxTv_SdtLegajo_Legpuescodigo_N = sdt.getgxTv_SdtLegajo_Legpuescodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legpuescodigo = sdt.getgxTv_SdtLegajo_Legpuescodigo() ;
      }
      if ( sdt.IsDirty("LegSucCodigo") )
      {
         gxTv_SdtLegajo_Legsuccodigo_N = sdt.getgxTv_SdtLegajo_Legsuccodigo_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legsuccodigo = sdt.getgxTv_SdtLegajo_Legsuccodigo() ;
      }
      if ( sdt.IsDirty("LegTrabLun") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrablun = sdt.getgxTv_SdtLegajo_Legtrablun() ;
      }
      if ( sdt.IsDirty("LegTrabMar") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabmar = sdt.getgxTv_SdtLegajo_Legtrabmar() ;
      }
      if ( sdt.IsDirty("LegTrabMie") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabmie = sdt.getgxTv_SdtLegajo_Legtrabmie() ;
      }
      if ( sdt.IsDirty("LegTrabJue") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabjue = sdt.getgxTv_SdtLegajo_Legtrabjue() ;
      }
      if ( sdt.IsDirty("LegTrabVie") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabvie = sdt.getgxTv_SdtLegajo_Legtrabvie() ;
      }
      if ( sdt.IsDirty("LegTrabSa") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabsa = sdt.getgxTv_SdtLegajo_Legtrabsa() ;
      }
      if ( sdt.IsDirty("LegTrabDo") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtrabdo = sdt.getgxTv_SdtLegajo_Legtrabdo() ;
      }
      if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
      {
         GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> newCollectionTipos_de_trabajo = sdt.getgxTv_SdtLegajo_Tipos_de_trabajo();
         web.SdtLegajo_tipos_de_trabajo currItemTipos_de_trabajo;
         web.SdtLegajo_tipos_de_trabajo newItemTipos_de_trabajo;
         short idx = 1;
         while ( idx <= newCollectionTipos_de_trabajo.size() )
         {
            newItemTipos_de_trabajo = (web.SdtLegajo_tipos_de_trabajo)((web.SdtLegajo_tipos_de_trabajo)newCollectionTipos_de_trabajo.elementAt(-1+idx));
            currItemTipos_de_trabajo = (web.SdtLegajo_tipos_de_trabajo)gxTv_SdtLegajo_Tipos_de_trabajo.getByKey(newItemTipos_de_trabajo.getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra());
            if ( GXutil.strcmp(currItemTipos_de_trabajo.getgxTv_SdtLegajo_tipos_de_trabajo_Mode(), "UPD") == 0 )
            {
               currItemTipos_de_trabajo.updateDirties(newItemTipos_de_trabajo);
               if ( GXutil.strcmp(newItemTipos_de_trabajo.getgxTv_SdtLegajo_tipos_de_trabajo_Mode(), "DLT") == 0 )
               {
                  currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( "DLT" );
               }
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtLegajo_Tipos_de_trabajo.add(newItemTipos_de_trabajo, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("LegVacPend") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legvacpend = sdt.getgxTv_SdtLegajo_Legvacpend() ;
      }
      if ( sdt.IsDirty("LegFecPreAviso") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legfecpreaviso = sdt.getgxTv_SdtLegajo_Legfecpreaviso() ;
      }
      if ( sdt.IsDirty("LegConveVersionCli") )
      {
         gxTv_SdtLegajo_Legconveversioncli_N = sdt.getgxTv_SdtLegajo_Legconveversioncli_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legconveversioncli = sdt.getgxTv_SdtLegajo_Legconveversioncli() ;
      }
      if ( sdt.IsDirty("LegSitRevEgreso") )
      {
         gxTv_SdtLegajo_Legsitrevegreso_N = sdt.getgxTv_SdtLegajo_Legsitrevegreso_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legsitrevegreso = sdt.getgxTv_SdtLegajo_Legsitrevegreso() ;
      }
      if ( sdt.IsDirty("LegPromDias") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legpromdias = sdt.getgxTv_SdtLegajo_Legpromdias() ;
      }
      if ( sdt.IsDirty("LegTitulo") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtitulo = sdt.getgxTv_SdtLegajo_Legtitulo() ;
      }
      if ( sdt.IsDirty("LegEstado") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legestado = sdt.getgxTv_SdtLegajo_Legestado() ;
      }
      if ( sdt.IsDirty("LegActClasNro") )
      {
         gxTv_SdtLegajo_Legactclasnro_N = sdt.getgxTv_SdtLegajo_Legactclasnro_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legactclasnro = sdt.getgxTv_SdtLegajo_Legactclasnro() ;
      }
      if ( sdt.IsDirty("LegPueAfiCod") )
      {
         gxTv_SdtLegajo_Legpueaficod_N = sdt.getgxTv_SdtLegajo_Legpueaficod_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legpueaficod = sdt.getgxTv_SdtLegajo_Legpueaficod() ;
      }
      if ( sdt.IsDirty("LegMigrWarn") )
      {
         gxTv_SdtLegajo_Legmigrwarn_N = sdt.getgxTv_SdtLegajo_Legmigrwarn_N() ;
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legmigrwarn = sdt.getgxTv_SdtLegajo_Legmigrwarn() ;
      }
      if ( sdt.IsDirty("LegIncompleto") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legincompleto = sdt.getgxTv_SdtLegajo_Legincompleto() ;
      }
      if ( sdt.IsDirty("LegLiqApo") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legliqapo = sdt.getgxTv_SdtLegajo_Legliqapo() ;
      }
      if ( gxTv_SdtLegajo_Propiedades != null )
      {
         GXBCLevelCollection<web.SdtLegajo_Propiedades> newCollectionPropiedades = sdt.getgxTv_SdtLegajo_Propiedades();
         web.SdtLegajo_Propiedades currItemPropiedades;
         web.SdtLegajo_Propiedades newItemPropiedades;
         short idx = 1;
         while ( idx <= newCollectionPropiedades.size() )
         {
            newItemPropiedades = (web.SdtLegajo_Propiedades)((web.SdtLegajo_Propiedades)newCollectionPropiedades.elementAt(-1+idx));
            currItemPropiedades = (web.SdtLegajo_Propiedades)gxTv_SdtLegajo_Propiedades.getByKey(newItemPropiedades.getgxTv_SdtLegajo_Propiedades_Legpropcod());
            if ( GXutil.strcmp(currItemPropiedades.getgxTv_SdtLegajo_Propiedades_Mode(), "UPD") == 0 )
            {
               currItemPropiedades.updateDirties(newItemPropiedades);
               if ( GXutil.strcmp(newItemPropiedades.getgxTv_SdtLegajo_Propiedades_Mode(), "DLT") == 0 )
               {
                  currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Mode( "DLT" );
               }
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtLegajo_Propiedades.add(newItemPropiedades, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("LegModTra") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legmodtra = sdt.getgxTv_SdtLegajo_Legmodtra() ;
      }
      if ( sdt.IsDirty("LegTipoTarifa") )
      {
         gxTv_SdtLegajo_N = (byte)(0) ;
         gxTv_SdtLegajo_Legtipotarifa = sdt.getgxTv_SdtLegajo_Legtipotarifa() ;
      }
   }

   public int getgxTv_SdtLegajo_Clicod( )
   {
      return gxTv_SdtLegajo_Clicod ;
   }

   public void setgxTv_SdtLegajo_Clicod( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLegajo_Clicod != value )
      {
         gxTv_SdtLegajo_Mode = "INS" ;
         this.setgxTv_SdtLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legapellido_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnombre_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotonom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotoext_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsexo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestadocivil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacioncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacionalidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdiscapacidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdomici_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legemail_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcodpos_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpaicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpainom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legloccod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglocnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtelefono_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecingreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmegcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Megdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatpuecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legseccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Secdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglpgcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Lpgdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legclase_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbasico_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legformapago_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbancod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbandes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbansuc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbantipcuen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsincod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Sindescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosocod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosodes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosoafipcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osodescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecultmod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuentabanc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicinicio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicfinal_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zoncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zondescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zonporcreduc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcbu_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvenio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legscvo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condicodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condidescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniedescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactivo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsueldofuera_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osoc3992_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecimportacion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legagenreten_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcontinua_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legrecalcliq_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legjubilado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorasdia_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorassem_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legreligion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legorigen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpuescodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsuccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrablun_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmar_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabjue_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabvie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabsa_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabdo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legvacpend_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecpreaviso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconveversioncli_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsitrevegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpromdias_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtitulo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactclasnro_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpueaficod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legincompleto_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legliqapo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmodtra_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipotarifa_Z_SetNull( );
         if ( gxTv_SdtLegajo_Salario != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Salario> collectionSalario = gxTv_SdtLegajo_Salario;
            web.SdtLegajo_Salario currItemSalario;
            short idx = 1;
            while ( idx <= collectionSalario.size() )
            {
               currItemSalario = (web.SdtLegajo_Salario)((web.SdtLegajo_Salario)collectionSalario.elementAt(-1+idx));
               currItemSalario.setgxTv_SdtLegajo_Salario_Mode( "INS" );
               currItemSalario.setgxTv_SdtLegajo_Salario_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Familia != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Familia> collectionFamilia = gxTv_SdtLegajo_Familia;
            web.SdtLegajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.SdtLegajo_Familia)((web.SdtLegajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_SdtLegajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_SdtLegajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
         {
            GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> collectionTipos_de_trabajo = gxTv_SdtLegajo_Tipos_de_trabajo;
            web.SdtLegajo_tipos_de_trabajo currItemTipos_de_trabajo;
            short idx = 1;
            while ( idx <= collectionTipos_de_trabajo.size() )
            {
               currItemTipos_de_trabajo = (web.SdtLegajo_tipos_de_trabajo)((web.SdtLegajo_tipos_de_trabajo)collectionTipos_de_trabajo.elementAt(-1+idx));
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( "INS" );
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Propiedades != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Propiedades> collectionPropiedades = gxTv_SdtLegajo_Propiedades;
            web.SdtLegajo_Propiedades currItemPropiedades;
            short idx = 1;
            while ( idx <= collectionPropiedades.size() )
            {
               currItemPropiedades = (web.SdtLegajo_Propiedades)((web.SdtLegajo_Propiedades)collectionPropiedades.elementAt(-1+idx));
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Mode( "INS" );
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtLegajo_Clicod = value ;
   }

   public short getgxTv_SdtLegajo_Empcod( )
   {
      return gxTv_SdtLegajo_Empcod ;
   }

   public void setgxTv_SdtLegajo_Empcod( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLegajo_Empcod != value )
      {
         gxTv_SdtLegajo_Mode = "INS" ;
         this.setgxTv_SdtLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legapellido_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnombre_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotonom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotoext_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsexo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestadocivil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacioncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacionalidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdiscapacidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdomici_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legemail_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcodpos_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpaicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpainom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legloccod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglocnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtelefono_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecingreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmegcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Megdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatpuecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legseccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Secdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglpgcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Lpgdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legclase_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbasico_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legformapago_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbancod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbandes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbansuc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbantipcuen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsincod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Sindescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosocod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosodes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosoafipcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osodescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecultmod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuentabanc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicinicio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicfinal_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zoncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zondescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zonporcreduc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcbu_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvenio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legscvo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condicodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condidescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniedescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactivo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsueldofuera_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osoc3992_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecimportacion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legagenreten_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcontinua_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legrecalcliq_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legjubilado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorasdia_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorassem_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legreligion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legorigen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpuescodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsuccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrablun_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmar_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabjue_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabvie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabsa_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabdo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legvacpend_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecpreaviso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconveversioncli_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsitrevegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpromdias_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtitulo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactclasnro_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpueaficod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legincompleto_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legliqapo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmodtra_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipotarifa_Z_SetNull( );
         if ( gxTv_SdtLegajo_Salario != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Salario> collectionSalario = gxTv_SdtLegajo_Salario;
            web.SdtLegajo_Salario currItemSalario;
            short idx = 1;
            while ( idx <= collectionSalario.size() )
            {
               currItemSalario = (web.SdtLegajo_Salario)((web.SdtLegajo_Salario)collectionSalario.elementAt(-1+idx));
               currItemSalario.setgxTv_SdtLegajo_Salario_Mode( "INS" );
               currItemSalario.setgxTv_SdtLegajo_Salario_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Familia != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Familia> collectionFamilia = gxTv_SdtLegajo_Familia;
            web.SdtLegajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.SdtLegajo_Familia)((web.SdtLegajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_SdtLegajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_SdtLegajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
         {
            GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> collectionTipos_de_trabajo = gxTv_SdtLegajo_Tipos_de_trabajo;
            web.SdtLegajo_tipos_de_trabajo currItemTipos_de_trabajo;
            short idx = 1;
            while ( idx <= collectionTipos_de_trabajo.size() )
            {
               currItemTipos_de_trabajo = (web.SdtLegajo_tipos_de_trabajo)((web.SdtLegajo_tipos_de_trabajo)collectionTipos_de_trabajo.elementAt(-1+idx));
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( "INS" );
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Propiedades != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Propiedades> collectionPropiedades = gxTv_SdtLegajo_Propiedades;
            web.SdtLegajo_Propiedades currItemPropiedades;
            short idx = 1;
            while ( idx <= collectionPropiedades.size() )
            {
               currItemPropiedades = (web.SdtLegajo_Propiedades)((web.SdtLegajo_Propiedades)collectionPropiedades.elementAt(-1+idx));
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Mode( "INS" );
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Empcod");
      gxTv_SdtLegajo_Empcod = value ;
   }

   public String getgxTv_SdtLegajo_Empnom( )
   {
      return gxTv_SdtLegajo_Empnom ;
   }

   public void setgxTv_SdtLegajo_Empnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtLegajo_Empnom = value ;
   }

   public int getgxTv_SdtLegajo_Legnumero( )
   {
      return gxTv_SdtLegajo_Legnumero ;
   }

   public void setgxTv_SdtLegajo_Legnumero( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLegajo_Legnumero != value )
      {
         gxTv_SdtLegajo_Mode = "INS" ;
         this.setgxTv_SdtLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legapellido_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnombre_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotonom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfotoext_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnumdoc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsexo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestadocivil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacioncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnacionalidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuil_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdiscapacidad_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legdomici_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legemail_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcodpos_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpaicod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpainom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legprovnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legloccod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglocnom_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtelefono_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecingreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmegcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Megdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcatpuecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legseccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Secdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglpgcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Lpgdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legclase_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbasico_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legformapago_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbancod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbandes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbansuc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legbantipcuen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsincod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Sindescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosocod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosodes_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legosoafipcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osodescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactdescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprcod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Mprdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecultmod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcuentabanc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicinicio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leglicfinal_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zoncod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zondescrip_Z_SetNull( );
         this.setgxTv_SdtLegajo_Zonporcreduc_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcbu_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvenio_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legscvo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condicodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Condidescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Siniedescri_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactivo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsueldofuera_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconvecodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Osoc3992_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legnomape_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecimportacion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legagenreten_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legcontinua_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legrecalcliq_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legjubilado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorasdia_Z_SetNull( );
         this.setgxTv_SdtLegajo_Leghorassem_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legreligion_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legorigen_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpuescodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsuccodigo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrablun_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmar_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabmie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabjue_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabvie_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabsa_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtrabdo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legvacpend_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legfecpreaviso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legconveversioncli_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legsitrevegreso_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpromdias_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtitulo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legestado_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legactclasnro_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legpueaficod_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legincompleto_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legliqapo_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legmodtra_Z_SetNull( );
         this.setgxTv_SdtLegajo_Legtipotarifa_Z_SetNull( );
         if ( gxTv_SdtLegajo_Salario != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Salario> collectionSalario = gxTv_SdtLegajo_Salario;
            web.SdtLegajo_Salario currItemSalario;
            short idx = 1;
            while ( idx <= collectionSalario.size() )
            {
               currItemSalario = (web.SdtLegajo_Salario)((web.SdtLegajo_Salario)collectionSalario.elementAt(-1+idx));
               currItemSalario.setgxTv_SdtLegajo_Salario_Mode( "INS" );
               currItemSalario.setgxTv_SdtLegajo_Salario_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Familia != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Familia> collectionFamilia = gxTv_SdtLegajo_Familia;
            web.SdtLegajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.SdtLegajo_Familia)((web.SdtLegajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_SdtLegajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_SdtLegajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Tipos_de_trabajo != null )
         {
            GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> collectionTipos_de_trabajo = gxTv_SdtLegajo_Tipos_de_trabajo;
            web.SdtLegajo_tipos_de_trabajo currItemTipos_de_trabajo;
            short idx = 1;
            while ( idx <= collectionTipos_de_trabajo.size() )
            {
               currItemTipos_de_trabajo = (web.SdtLegajo_tipos_de_trabajo)((web.SdtLegajo_tipos_de_trabajo)collectionTipos_de_trabajo.elementAt(-1+idx));
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( "INS" );
               currItemTipos_de_trabajo.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtLegajo_Propiedades != null )
         {
            GXBCLevelCollection<web.SdtLegajo_Propiedades> collectionPropiedades = gxTv_SdtLegajo_Propiedades;
            web.SdtLegajo_Propiedades currItemPropiedades;
            short idx = 1;
            while ( idx <= collectionPropiedades.size() )
            {
               currItemPropiedades = (web.SdtLegajo_Propiedades)((web.SdtLegajo_Propiedades)collectionPropiedades.elementAt(-1+idx));
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Mode( "INS" );
               currItemPropiedades.setgxTv_SdtLegajo_Propiedades_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Legnumero");
      gxTv_SdtLegajo_Legnumero = value ;
   }

   public String getgxTv_SdtLegajo_Legapellido( )
   {
      return gxTv_SdtLegajo_Legapellido ;
   }

   public void setgxTv_SdtLegajo_Legapellido( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legapellido");
      gxTv_SdtLegajo_Legapellido = value ;
   }

   public String getgxTv_SdtLegajo_Legnombre( )
   {
      return gxTv_SdtLegajo_Legnombre ;
   }

   public void setgxTv_SdtLegajo_Legnombre( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnombre");
      gxTv_SdtLegajo_Legnombre = value ;
   }

   @GxUpload
   public String getgxTv_SdtLegajo_Legfoto( )
   {
      return gxTv_SdtLegajo_Legfoto ;
   }

   public void setgxTv_SdtLegajo_Legfoto( String value )
   {
      gxTv_SdtLegajo_Legfoto_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfoto");
      gxTv_SdtLegajo_Legfoto = value ;
   }

   public void setgxTv_SdtLegajo_Legfoto_SetBlob( String blob ,
                                                  String fileName ,
                                                  String fileType )
   {
      gxTv_SdtLegajo_Legfoto = blob ;
      gxTv_SdtLegajo_Legfotonom = fileName ;
      gxTv_SdtLegajo_Legfotoext = fileType ;
   }

   public void setgxTv_SdtLegajo_Legfoto_SetNull( )
   {
      gxTv_SdtLegajo_Legfoto_N = (byte)(1) ;
      gxTv_SdtLegajo_Legfoto = "" ;
      SetDirty("Legfoto");
   }

   public boolean getgxTv_SdtLegajo_Legfoto_IsNull( )
   {
      return (gxTv_SdtLegajo_Legfoto_N==1) ;
   }

   public GXBCLevelCollection<web.SdtLegajo_Salario> getgxTv_SdtLegajo_Salario( )
   {
      if ( gxTv_SdtLegajo_Salario == null )
      {
         gxTv_SdtLegajo_Salario = new GXBCLevelCollection<web.SdtLegajo_Salario>(web.SdtLegajo_Salario.class, "Legajo.Salario", "PayDay", remoteHandle);
      }
      gxTv_SdtLegajo_N = (byte)(0) ;
      return gxTv_SdtLegajo_Salario ;
   }

   public void setgxTv_SdtLegajo_Salario( GXBCLevelCollection<web.SdtLegajo_Salario> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Salario");
      gxTv_SdtLegajo_Salario = value ;
   }

   public void setgxTv_SdtLegajo_Salario_SetNull( )
   {
      gxTv_SdtLegajo_Salario = null ;
      SetDirty("Salario");
   }

   public boolean getgxTv_SdtLegajo_Salario_IsNull( )
   {
      if ( gxTv_SdtLegajo_Salario == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtLegajo_Familia> getgxTv_SdtLegajo_Familia( )
   {
      if ( gxTv_SdtLegajo_Familia == null )
      {
         gxTv_SdtLegajo_Familia = new GXBCLevelCollection<web.SdtLegajo_Familia>(web.SdtLegajo_Familia.class, "Legajo.Familia", "PayDay", remoteHandle);
      }
      gxTv_SdtLegajo_N = (byte)(0) ;
      return gxTv_SdtLegajo_Familia ;
   }

   public void setgxTv_SdtLegajo_Familia( GXBCLevelCollection<web.SdtLegajo_Familia> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Familia");
      gxTv_SdtLegajo_Familia = value ;
   }

   public void setgxTv_SdtLegajo_Familia_SetNull( )
   {
      gxTv_SdtLegajo_Familia = null ;
      SetDirty("Familia");
   }

   public boolean getgxTv_SdtLegajo_Familia_IsNull( )
   {
      if ( gxTv_SdtLegajo_Familia == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtLegajo_Legfotonom( )
   {
      return gxTv_SdtLegajo_Legfotonom ;
   }

   public void setgxTv_SdtLegajo_Legfotonom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfotonom");
      gxTv_SdtLegajo_Legfotonom = value ;
   }

   public String getgxTv_SdtLegajo_Legfotoext( )
   {
      return gxTv_SdtLegajo_Legfotoext ;
   }

   public void setgxTv_SdtLegajo_Legfotoext( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfotoext");
      gxTv_SdtLegajo_Legfotoext = value ;
   }

   public byte getgxTv_SdtLegajo_Legtipdoc( )
   {
      return gxTv_SdtLegajo_Legtipdoc ;
   }

   public void setgxTv_SdtLegajo_Legtipdoc( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtipdoc");
      gxTv_SdtLegajo_Legtipdoc = value ;
   }

   public String getgxTv_SdtLegajo_Legnumdoc( )
   {
      return gxTv_SdtLegajo_Legnumdoc ;
   }

   public void setgxTv_SdtLegajo_Legnumdoc( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnumdoc");
      gxTv_SdtLegajo_Legnumdoc = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecnac( )
   {
      return gxTv_SdtLegajo_Legfecnac ;
   }

   public void setgxTv_SdtLegajo_Legfecnac( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecnac");
      gxTv_SdtLegajo_Legfecnac = value ;
   }

   public byte getgxTv_SdtLegajo_Legsexo( )
   {
      return gxTv_SdtLegajo_Legsexo ;
   }

   public void setgxTv_SdtLegajo_Legsexo( byte value )
   {
      gxTv_SdtLegajo_Legsexo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsexo");
      gxTv_SdtLegajo_Legsexo = value ;
   }

   public void setgxTv_SdtLegajo_Legsexo_SetNull( )
   {
      gxTv_SdtLegajo_Legsexo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsexo = (byte)(0) ;
      SetDirty("Legsexo");
   }

   public boolean getgxTv_SdtLegajo_Legsexo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legsexo_N==1) ;
   }

   public short getgxTv_SdtLegajo_Legestadocivil( )
   {
      return gxTv_SdtLegajo_Legestadocivil ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil( short value )
   {
      gxTv_SdtLegajo_Legestadocivil_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legestadocivil");
      gxTv_SdtLegajo_Legestadocivil = value ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil_SetNull( )
   {
      gxTv_SdtLegajo_Legestadocivil_N = (byte)(1) ;
      gxTv_SdtLegajo_Legestadocivil = (short)(0) ;
      SetDirty("Legestadocivil");
   }

   public boolean getgxTv_SdtLegajo_Legestadocivil_IsNull( )
   {
      return (gxTv_SdtLegajo_Legestadocivil_N==1) ;
   }

   public short getgxTv_SdtLegajo_Legnacioncod( )
   {
      return gxTv_SdtLegajo_Legnacioncod ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod( short value )
   {
      gxTv_SdtLegajo_Legnacioncod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnacioncod");
      gxTv_SdtLegajo_Legnacioncod = value ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod_SetNull( )
   {
      gxTv_SdtLegajo_Legnacioncod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legnacioncod = (short)(0) ;
      SetDirty("Legnacioncod");
   }

   public boolean getgxTv_SdtLegajo_Legnacioncod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legnacioncod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legnacionalidad( )
   {
      return gxTv_SdtLegajo_Legnacionalidad ;
   }

   public void setgxTv_SdtLegajo_Legnacionalidad( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnacionalidad");
      gxTv_SdtLegajo_Legnacionalidad = value ;
   }

   public long getgxTv_SdtLegajo_Legcuil( )
   {
      return gxTv_SdtLegajo_Legcuil ;
   }

   public void setgxTv_SdtLegajo_Legcuil( long value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcuil");
      gxTv_SdtLegajo_Legcuil = value ;
   }

   public byte getgxTv_SdtLegajo_Legdiscapacidad( )
   {
      return gxTv_SdtLegajo_Legdiscapacidad ;
   }

   public void setgxTv_SdtLegajo_Legdiscapacidad( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legdiscapacidad");
      gxTv_SdtLegajo_Legdiscapacidad = value ;
   }

   public String getgxTv_SdtLegajo_Legdomici( )
   {
      return gxTv_SdtLegajo_Legdomici ;
   }

   public void setgxTv_SdtLegajo_Legdomici( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legdomici");
      gxTv_SdtLegajo_Legdomici = value ;
   }

   public String getgxTv_SdtLegajo_Legemail( )
   {
      return gxTv_SdtLegajo_Legemail ;
   }

   public void setgxTv_SdtLegajo_Legemail( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legemail");
      gxTv_SdtLegajo_Legemail = value ;
   }

   public String getgxTv_SdtLegajo_Legcodpos( )
   {
      return gxTv_SdtLegajo_Legcodpos ;
   }

   public void setgxTv_SdtLegajo_Legcodpos( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcodpos");
      gxTv_SdtLegajo_Legcodpos = value ;
   }

   public short getgxTv_SdtLegajo_Legpaicod( )
   {
      return gxTv_SdtLegajo_Legpaicod ;
   }

   public void setgxTv_SdtLegajo_Legpaicod( short value )
   {
      gxTv_SdtLegajo_Legpaicod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpaicod");
      gxTv_SdtLegajo_Legpaicod = value ;
   }

   public void setgxTv_SdtLegajo_Legpaicod_SetNull( )
   {
      gxTv_SdtLegajo_Legpaicod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpaicod = (short)(0) ;
      SetDirty("Legpaicod");
   }

   public boolean getgxTv_SdtLegajo_Legpaicod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legpaicod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legpainom( )
   {
      return gxTv_SdtLegajo_Legpainom ;
   }

   public void setgxTv_SdtLegajo_Legpainom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpainom");
      gxTv_SdtLegajo_Legpainom = value ;
   }

   public short getgxTv_SdtLegajo_Legprovcod( )
   {
      return gxTv_SdtLegajo_Legprovcod ;
   }

   public void setgxTv_SdtLegajo_Legprovcod( short value )
   {
      gxTv_SdtLegajo_Legprovcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legprovcod");
      gxTv_SdtLegajo_Legprovcod = value ;
   }

   public void setgxTv_SdtLegajo_Legprovcod_SetNull( )
   {
      gxTv_SdtLegajo_Legprovcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legprovcod = (short)(0) ;
      SetDirty("Legprovcod");
   }

   public boolean getgxTv_SdtLegajo_Legprovcod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legprovcod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legprovnom( )
   {
      return gxTv_SdtLegajo_Legprovnom ;
   }

   public void setgxTv_SdtLegajo_Legprovnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legprovnom");
      gxTv_SdtLegajo_Legprovnom = value ;
   }

   public short getgxTv_SdtLegajo_Legloccod( )
   {
      return gxTv_SdtLegajo_Legloccod ;
   }

   public void setgxTv_SdtLegajo_Legloccod( short value )
   {
      gxTv_SdtLegajo_Legloccod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legloccod");
      gxTv_SdtLegajo_Legloccod = value ;
   }

   public void setgxTv_SdtLegajo_Legloccod_SetNull( )
   {
      gxTv_SdtLegajo_Legloccod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legloccod = (short)(0) ;
      SetDirty("Legloccod");
   }

   public boolean getgxTv_SdtLegajo_Legloccod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legloccod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Leglocnom( )
   {
      return gxTv_SdtLegajo_Leglocnom ;
   }

   public void setgxTv_SdtLegajo_Leglocnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglocnom");
      gxTv_SdtLegajo_Leglocnom = value ;
   }

   public String getgxTv_SdtLegajo_Legtelefono( )
   {
      return gxTv_SdtLegajo_Legtelefono ;
   }

   public void setgxTv_SdtLegajo_Legtelefono( String value )
   {
      gxTv_SdtLegajo_Legtelefono_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtelefono");
      gxTv_SdtLegajo_Legtelefono = value ;
   }

   public void setgxTv_SdtLegajo_Legtelefono_SetNull( )
   {
      gxTv_SdtLegajo_Legtelefono_N = (byte)(1) ;
      gxTv_SdtLegajo_Legtelefono = "" ;
      SetDirty("Legtelefono");
   }

   public boolean getgxTv_SdtLegajo_Legtelefono_IsNull( )
   {
      return (gxTv_SdtLegajo_Legtelefono_N==1) ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecingreso( )
   {
      return gxTv_SdtLegajo_Legfecingreso ;
   }

   public void setgxTv_SdtLegajo_Legfecingreso( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecingreso");
      gxTv_SdtLegajo_Legfecingreso = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecegreso( )
   {
      return gxTv_SdtLegajo_Legfecegreso ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso( java.util.Date value )
   {
      gxTv_SdtLegajo_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecegreso");
      gxTv_SdtLegajo_Legfecegreso = value ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso_SetNull( )
   {
      gxTv_SdtLegajo_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtLegajo_Legfecegreso = GXutil.nullDate() ;
      SetDirty("Legfecegreso");
   }

   public boolean getgxTv_SdtLegajo_Legfecegreso_IsNull( )
   {
      return (gxTv_SdtLegajo_Legfecegreso_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legmegcodigo( )
   {
      return gxTv_SdtLegajo_Legmegcodigo ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo( String value )
   {
      gxTv_SdtLegajo_Legmegcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmegcodigo");
      gxTv_SdtLegajo_Legmegcodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legmegcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legmegcodigo = "" ;
      SetDirty("Legmegcodigo");
   }

   public boolean getgxTv_SdtLegajo_Legmegcodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legmegcodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Megdescrip( )
   {
      return gxTv_SdtLegajo_Megdescrip ;
   }

   public void setgxTv_SdtLegajo_Megdescrip( String value )
   {
      gxTv_SdtLegajo_Megdescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Megdescrip");
      gxTv_SdtLegajo_Megdescrip = value ;
   }

   public void setgxTv_SdtLegajo_Megdescrip_SetNull( )
   {
      gxTv_SdtLegajo_Megdescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Megdescrip = "" ;
      SetDirty("Megdescrip");
   }

   public boolean getgxTv_SdtLegajo_Megdescrip_IsNull( )
   {
      return (gxTv_SdtLegajo_Megdescrip_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legcatcodigo( )
   {
      return gxTv_SdtLegajo_Legcatcodigo ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo( String value )
   {
      gxTv_SdtLegajo_Legcatcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatcodigo");
      gxTv_SdtLegajo_Legcatcodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legcatcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcatcodigo = "" ;
      SetDirty("Legcatcodigo");
   }

   public boolean getgxTv_SdtLegajo_Legcatcodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legcatcodigo_N==1) ;
   }

   public int getgxTv_SdtLegajo_Legcatpuecod( )
   {
      return gxTv_SdtLegajo_Legcatpuecod ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod( int value )
   {
      gxTv_SdtLegajo_Legcatpuecod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatpuecod");
      gxTv_SdtLegajo_Legcatpuecod = value ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod_SetNull( )
   {
      gxTv_SdtLegajo_Legcatpuecod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcatpuecod = 0 ;
      SetDirty("Legcatpuecod");
   }

   public boolean getgxTv_SdtLegajo_Legcatpuecod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legcatpuecod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legseccodigo( )
   {
      return gxTv_SdtLegajo_Legseccodigo ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo( String value )
   {
      gxTv_SdtLegajo_Legseccodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legseccodigo");
      gxTv_SdtLegajo_Legseccodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legseccodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legseccodigo = "" ;
      SetDirty("Legseccodigo");
   }

   public boolean getgxTv_SdtLegajo_Legseccodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legseccodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Secdescrip( )
   {
      return gxTv_SdtLegajo_Secdescrip ;
   }

   public void setgxTv_SdtLegajo_Secdescrip( String value )
   {
      gxTv_SdtLegajo_Secdescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Secdescrip");
      gxTv_SdtLegajo_Secdescrip = value ;
   }

   public void setgxTv_SdtLegajo_Secdescrip_SetNull( )
   {
      gxTv_SdtLegajo_Secdescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Secdescrip = "" ;
      SetDirty("Secdescrip");
   }

   public boolean getgxTv_SdtLegajo_Secdescrip_IsNull( )
   {
      return (gxTv_SdtLegajo_Secdescrip_N==1) ;
   }

   public String getgxTv_SdtLegajo_Leglpgcodigo( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo( String value )
   {
      gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglpgcodigo");
      gxTv_SdtLegajo_Leglpgcodigo = value ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo_SetNull( )
   {
      gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglpgcodigo = "" ;
      SetDirty("Leglpgcodigo");
   }

   public boolean getgxTv_SdtLegajo_Leglpgcodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Leglpgcodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Lpgdescri( )
   {
      return gxTv_SdtLegajo_Lpgdescri ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri( String value )
   {
      gxTv_SdtLegajo_Lpgdescri_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Lpgdescri");
      gxTv_SdtLegajo_Lpgdescri = value ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri_SetNull( )
   {
      gxTv_SdtLegajo_Lpgdescri_N = (byte)(1) ;
      gxTv_SdtLegajo_Lpgdescri = "" ;
      SetDirty("Lpgdescri");
   }

   public boolean getgxTv_SdtLegajo_Lpgdescri_IsNull( )
   {
      return (gxTv_SdtLegajo_Lpgdescri_N==1) ;
   }

   public byte getgxTv_SdtLegajo_Legclase( )
   {
      return gxTv_SdtLegajo_Legclase ;
   }

   public void setgxTv_SdtLegajo_Legclase( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legclase");
      gxTv_SdtLegajo_Legclase = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Legbasico( )
   {
      return gxTv_SdtLegajo_Legbasico ;
   }

   public void setgxTv_SdtLegajo_Legbasico( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbasico");
      gxTv_SdtLegajo_Legbasico = value ;
   }

   public void setgxTv_SdtLegajo_Legbasico_SetNull( )
   {
      gxTv_SdtLegajo_Legbasico = DecimalUtil.ZERO ;
      SetDirty("Legbasico");
   }

   public boolean getgxTv_SdtLegajo_Legbasico_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legformapago( )
   {
      return gxTv_SdtLegajo_Legformapago ;
   }

   public void setgxTv_SdtLegajo_Legformapago( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legformapago");
      gxTv_SdtLegajo_Legformapago = value ;
   }

   public String getgxTv_SdtLegajo_Legbancod( )
   {
      return gxTv_SdtLegajo_Legbancod ;
   }

   public void setgxTv_SdtLegajo_Legbancod( String value )
   {
      gxTv_SdtLegajo_Legbancod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbancod");
      gxTv_SdtLegajo_Legbancod = value ;
   }

   public void setgxTv_SdtLegajo_Legbancod_SetNull( )
   {
      gxTv_SdtLegajo_Legbancod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbancod = "" ;
      SetDirty("Legbancod");
   }

   public boolean getgxTv_SdtLegajo_Legbancod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legbancod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legbandes( )
   {
      return gxTv_SdtLegajo_Legbandes ;
   }

   public void setgxTv_SdtLegajo_Legbandes( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbandes");
      gxTv_SdtLegajo_Legbandes = value ;
   }

   public String getgxTv_SdtLegajo_Legbansuc( )
   {
      return gxTv_SdtLegajo_Legbansuc ;
   }

   public void setgxTv_SdtLegajo_Legbansuc( String value )
   {
      gxTv_SdtLegajo_Legbansuc_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbansuc");
      gxTv_SdtLegajo_Legbansuc = value ;
   }

   public void setgxTv_SdtLegajo_Legbansuc_SetNull( )
   {
      gxTv_SdtLegajo_Legbansuc_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbansuc = "" ;
      SetDirty("Legbansuc");
   }

   public boolean getgxTv_SdtLegajo_Legbansuc_IsNull( )
   {
      return (gxTv_SdtLegajo_Legbansuc_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legbantipcuen( )
   {
      return gxTv_SdtLegajo_Legbantipcuen ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen( String value )
   {
      gxTv_SdtLegajo_Legbantipcuen_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbantipcuen");
      gxTv_SdtLegajo_Legbantipcuen = value ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen_SetNull( )
   {
      gxTv_SdtLegajo_Legbantipcuen_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbantipcuen = "" ;
      SetDirty("Legbantipcuen");
   }

   public boolean getgxTv_SdtLegajo_Legbantipcuen_IsNull( )
   {
      return (gxTv_SdtLegajo_Legbantipcuen_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legsincod( )
   {
      return gxTv_SdtLegajo_Legsincod ;
   }

   public void setgxTv_SdtLegajo_Legsincod( String value )
   {
      gxTv_SdtLegajo_Legsincod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsincod");
      gxTv_SdtLegajo_Legsincod = value ;
   }

   public void setgxTv_SdtLegajo_Legsincod_SetNull( )
   {
      gxTv_SdtLegajo_Legsincod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsincod = "" ;
      SetDirty("Legsincod");
   }

   public boolean getgxTv_SdtLegajo_Legsincod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legsincod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Sindescrip( )
   {
      return gxTv_SdtLegajo_Sindescrip ;
   }

   public void setgxTv_SdtLegajo_Sindescrip( String value )
   {
      gxTv_SdtLegajo_Sindescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Sindescrip");
      gxTv_SdtLegajo_Sindescrip = value ;
   }

   public void setgxTv_SdtLegajo_Sindescrip_SetNull( )
   {
      gxTv_SdtLegajo_Sindescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Sindescrip = "" ;
      SetDirty("Sindescrip");
   }

   public boolean getgxTv_SdtLegajo_Sindescrip_IsNull( )
   {
      return (gxTv_SdtLegajo_Sindescrip_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legosocod( )
   {
      return gxTv_SdtLegajo_Legosocod ;
   }

   public void setgxTv_SdtLegajo_Legosocod( String value )
   {
      gxTv_SdtLegajo_Legosocod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosocod");
      gxTv_SdtLegajo_Legosocod = value ;
   }

   public void setgxTv_SdtLegajo_Legosocod_SetNull( )
   {
      gxTv_SdtLegajo_Legosocod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legosocod = "" ;
      SetDirty("Legosocod");
   }

   public boolean getgxTv_SdtLegajo_Legosocod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legosocod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legosodes( )
   {
      return gxTv_SdtLegajo_Legosodes ;
   }

   public void setgxTv_SdtLegajo_Legosodes( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosodes");
      gxTv_SdtLegajo_Legosodes = value ;
   }

   public String getgxTv_SdtLegajo_Legosoafipcod( )
   {
      return gxTv_SdtLegajo_Legosoafipcod ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod( String value )
   {
      gxTv_SdtLegajo_Legosoafipcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosoafipcod");
      gxTv_SdtLegajo_Legosoafipcod = value ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod_SetNull( )
   {
      gxTv_SdtLegajo_Legosoafipcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legosoafipcod = "" ;
      SetDirty("Legosoafipcod");
   }

   public boolean getgxTv_SdtLegajo_Legosoafipcod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legosoafipcod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Osodescrip( )
   {
      return gxTv_SdtLegajo_Osodescrip ;
   }

   public void setgxTv_SdtLegajo_Osodescrip( String value )
   {
      gxTv_SdtLegajo_Osodescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osodescrip");
      gxTv_SdtLegajo_Osodescrip = value ;
   }

   public void setgxTv_SdtLegajo_Osodescrip_SetNull( )
   {
      gxTv_SdtLegajo_Osodescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Osodescrip = "" ;
      SetDirty("Osodescrip");
   }

   public boolean getgxTv_SdtLegajo_Osodescrip_IsNull( )
   {
      return (gxTv_SdtLegajo_Osodescrip_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legactcodigo( )
   {
      return gxTv_SdtLegajo_Legactcodigo ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo( String value )
   {
      gxTv_SdtLegajo_Legactcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactcodigo");
      gxTv_SdtLegajo_Legactcodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legactcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legactcodigo = "" ;
      SetDirty("Legactcodigo");
   }

   public boolean getgxTv_SdtLegajo_Legactcodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legactcodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legactdescri( )
   {
      return gxTv_SdtLegajo_Legactdescri ;
   }

   public void setgxTv_SdtLegajo_Legactdescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactdescri");
      gxTv_SdtLegajo_Legactdescri = value ;
   }

   public String getgxTv_SdtLegajo_Mprcod( )
   {
      return gxTv_SdtLegajo_Mprcod ;
   }

   public void setgxTv_SdtLegajo_Mprcod( String value )
   {
      gxTv_SdtLegajo_Mprcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mprcod");
      gxTv_SdtLegajo_Mprcod = value ;
   }

   public void setgxTv_SdtLegajo_Mprcod_SetNull( )
   {
      gxTv_SdtLegajo_Mprcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Mprcod = "" ;
      SetDirty("Mprcod");
   }

   public boolean getgxTv_SdtLegajo_Mprcod_IsNull( )
   {
      return (gxTv_SdtLegajo_Mprcod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Mprdescrip( )
   {
      return gxTv_SdtLegajo_Mprdescrip ;
   }

   public void setgxTv_SdtLegajo_Mprdescrip( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mprdescrip");
      gxTv_SdtLegajo_Mprdescrip = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecultmod( )
   {
      return gxTv_SdtLegajo_Legfecultmod ;
   }

   public void setgxTv_SdtLegajo_Legfecultmod( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecultmod");
      gxTv_SdtLegajo_Legfecultmod = value ;
   }

   public String getgxTv_SdtLegajo_Legcuentabanc( )
   {
      return gxTv_SdtLegajo_Legcuentabanc ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc( String value )
   {
      gxTv_SdtLegajo_Legcuentabanc_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcuentabanc");
      gxTv_SdtLegajo_Legcuentabanc = value ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc_SetNull( )
   {
      gxTv_SdtLegajo_Legcuentabanc_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcuentabanc = "" ;
      SetDirty("Legcuentabanc");
   }

   public boolean getgxTv_SdtLegajo_Legcuentabanc_IsNull( )
   {
      return (gxTv_SdtLegajo_Legcuentabanc_N==1) ;
   }

   public java.util.Date getgxTv_SdtLegajo_Leglicinicio( )
   {
      return gxTv_SdtLegajo_Leglicinicio ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio( java.util.Date value )
   {
      gxTv_SdtLegajo_Leglicinicio_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicinicio");
      gxTv_SdtLegajo_Leglicinicio = value ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio_SetNull( )
   {
      gxTv_SdtLegajo_Leglicinicio_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglicinicio = GXutil.nullDate() ;
      SetDirty("Leglicinicio");
   }

   public boolean getgxTv_SdtLegajo_Leglicinicio_IsNull( )
   {
      return (gxTv_SdtLegajo_Leglicinicio_N==1) ;
   }

   public java.util.Date getgxTv_SdtLegajo_Leglicfinal( )
   {
      return gxTv_SdtLegajo_Leglicfinal ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal( java.util.Date value )
   {
      gxTv_SdtLegajo_Leglicfinal_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicfinal");
      gxTv_SdtLegajo_Leglicfinal = value ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal_SetNull( )
   {
      gxTv_SdtLegajo_Leglicfinal_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglicfinal = GXutil.nullDate() ;
      SetDirty("Leglicfinal");
   }

   public boolean getgxTv_SdtLegajo_Leglicfinal_IsNull( )
   {
      return (gxTv_SdtLegajo_Leglicfinal_N==1) ;
   }

   public String getgxTv_SdtLegajo_Zoncod( )
   {
      return gxTv_SdtLegajo_Zoncod ;
   }

   public void setgxTv_SdtLegajo_Zoncod( String value )
   {
      gxTv_SdtLegajo_Zoncod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zoncod");
      gxTv_SdtLegajo_Zoncod = value ;
   }

   public void setgxTv_SdtLegajo_Zoncod_SetNull( )
   {
      gxTv_SdtLegajo_Zoncod_N = (byte)(1) ;
      gxTv_SdtLegajo_Zoncod = "" ;
      SetDirty("Zoncod");
   }

   public boolean getgxTv_SdtLegajo_Zoncod_IsNull( )
   {
      return (gxTv_SdtLegajo_Zoncod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Zondescrip( )
   {
      return gxTv_SdtLegajo_Zondescrip ;
   }

   public void setgxTv_SdtLegajo_Zondescrip( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zondescrip");
      gxTv_SdtLegajo_Zondescrip = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Zonporcreduc( )
   {
      return gxTv_SdtLegajo_Zonporcreduc ;
   }

   public void setgxTv_SdtLegajo_Zonporcreduc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zonporcreduc");
      gxTv_SdtLegajo_Zonporcreduc = value ;
   }

   public String getgxTv_SdtLegajo_Legcbu( )
   {
      return gxTv_SdtLegajo_Legcbu ;
   }

   public void setgxTv_SdtLegajo_Legcbu( String value )
   {
      gxTv_SdtLegajo_Legcbu_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcbu");
      gxTv_SdtLegajo_Legcbu = value ;
   }

   public void setgxTv_SdtLegajo_Legcbu_SetNull( )
   {
      gxTv_SdtLegajo_Legcbu_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcbu = "" ;
      SetDirty("Legcbu");
   }

   public boolean getgxTv_SdtLegajo_Legcbu_IsNull( )
   {
      return (gxTv_SdtLegajo_Legcbu_N==1) ;
   }

   public boolean getgxTv_SdtLegajo_Legconvenio( )
   {
      return gxTv_SdtLegajo_Legconvenio ;
   }

   public void setgxTv_SdtLegajo_Legconvenio( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconvenio");
      gxTv_SdtLegajo_Legconvenio = value ;
   }

   public boolean getgxTv_SdtLegajo_Legscvo( )
   {
      return gxTv_SdtLegajo_Legscvo ;
   }

   public void setgxTv_SdtLegajo_Legscvo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legscvo");
      gxTv_SdtLegajo_Legscvo = value ;
   }

   public short getgxTv_SdtLegajo_Condicodigo( )
   {
      return gxTv_SdtLegajo_Condicodigo ;
   }

   public void setgxTv_SdtLegajo_Condicodigo( short value )
   {
      gxTv_SdtLegajo_Condicodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Condicodigo");
      gxTv_SdtLegajo_Condicodigo = value ;
   }

   public void setgxTv_SdtLegajo_Condicodigo_SetNull( )
   {
      gxTv_SdtLegajo_Condicodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Condicodigo = (short)(0) ;
      SetDirty("Condicodigo");
   }

   public boolean getgxTv_SdtLegajo_Condicodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Condicodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Condidescri( )
   {
      return gxTv_SdtLegajo_Condidescri ;
   }

   public void setgxTv_SdtLegajo_Condidescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Condidescri");
      gxTv_SdtLegajo_Condidescri = value ;
   }

   public String getgxTv_SdtLegajo_Siniecodigo( )
   {
      return gxTv_SdtLegajo_Siniecodigo ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo( String value )
   {
      gxTv_SdtLegajo_Siniecodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Siniecodigo");
      gxTv_SdtLegajo_Siniecodigo = value ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo_SetNull( )
   {
      gxTv_SdtLegajo_Siniecodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Siniecodigo = "" ;
      SetDirty("Siniecodigo");
   }

   public boolean getgxTv_SdtLegajo_Siniecodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Siniecodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Siniedescri( )
   {
      return gxTv_SdtLegajo_Siniedescri ;
   }

   public void setgxTv_SdtLegajo_Siniedescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Siniedescri");
      gxTv_SdtLegajo_Siniedescri = value ;
   }

   public boolean getgxTv_SdtLegajo_Legactivo( )
   {
      return gxTv_SdtLegajo_Legactivo ;
   }

   public void setgxTv_SdtLegajo_Legactivo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactivo");
      gxTv_SdtLegajo_Legactivo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Legsueldofuera( )
   {
      return gxTv_SdtLegajo_Legsueldofuera ;
   }

   public void setgxTv_SdtLegajo_Legsueldofuera( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsueldofuera");
      gxTv_SdtLegajo_Legsueldofuera = value ;
   }

   public String getgxTv_SdtLegajo_Legid( )
   {
      return gxTv_SdtLegajo_Legid ;
   }

   public void setgxTv_SdtLegajo_Legid( String value )
   {
      gxTv_SdtLegajo_Legid_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legid");
      gxTv_SdtLegajo_Legid = value ;
   }

   public void setgxTv_SdtLegajo_Legid_SetNull( )
   {
      gxTv_SdtLegajo_Legid_N = (byte)(1) ;
      gxTv_SdtLegajo_Legid = "" ;
      SetDirty("Legid");
   }

   public boolean getgxTv_SdtLegajo_Legid_IsNull( )
   {
      return (gxTv_SdtLegajo_Legid_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legconvecodigo( )
   {
      return gxTv_SdtLegajo_Legconvecodigo ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo( String value )
   {
      gxTv_SdtLegajo_Legconvecodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconvecodigo");
      gxTv_SdtLegajo_Legconvecodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legconvecodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legconvecodigo = "" ;
      SetDirty("Legconvecodigo");
   }

   public boolean getgxTv_SdtLegajo_Legconvecodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legconvecodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legidnomape( )
   {
      return gxTv_SdtLegajo_Legidnomape ;
   }

   public void setgxTv_SdtLegajo_Legidnomape( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legidnomape");
      gxTv_SdtLegajo_Legidnomape = value ;
   }

   public String getgxTv_SdtLegajo_Tipemplecod( )
   {
      return gxTv_SdtLegajo_Tipemplecod ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod( String value )
   {
      gxTv_SdtLegajo_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Tipemplecod");
      gxTv_SdtLegajo_Tipemplecod = value ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod_SetNull( )
   {
      gxTv_SdtLegajo_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtLegajo_Tipemplecod = "" ;
      SetDirty("Tipemplecod");
   }

   public boolean getgxTv_SdtLegajo_Tipemplecod_IsNull( )
   {
      return (gxTv_SdtLegajo_Tipemplecod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Osoc3992( )
   {
      return gxTv_SdtLegajo_Osoc3992 ;
   }

   public void setgxTv_SdtLegajo_Osoc3992( String value )
   {
      gxTv_SdtLegajo_Osoc3992_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osoc3992");
      gxTv_SdtLegajo_Osoc3992 = value ;
   }

   public void setgxTv_SdtLegajo_Osoc3992_SetNull( )
   {
      gxTv_SdtLegajo_Osoc3992_N = (byte)(1) ;
      gxTv_SdtLegajo_Osoc3992 = "" ;
      SetDirty("Osoc3992");
   }

   public boolean getgxTv_SdtLegajo_Osoc3992_IsNull( )
   {
      return (gxTv_SdtLegajo_Osoc3992_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legobs( )
   {
      return gxTv_SdtLegajo_Legobs ;
   }

   public void setgxTv_SdtLegajo_Legobs( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legobs");
      gxTv_SdtLegajo_Legobs = value ;
   }

   public String getgxTv_SdtLegajo_Legnomape( )
   {
      return gxTv_SdtLegajo_Legnomape ;
   }

   public void setgxTv_SdtLegajo_Legnomape( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnomape");
      gxTv_SdtLegajo_Legnomape = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecimportacion( )
   {
      return gxTv_SdtLegajo_Legfecimportacion ;
   }

   public void setgxTv_SdtLegajo_Legfecimportacion( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecimportacion");
      gxTv_SdtLegajo_Legfecimportacion = value ;
   }

   public boolean getgxTv_SdtLegajo_Legagenreten( )
   {
      return gxTv_SdtLegajo_Legagenreten ;
   }

   public void setgxTv_SdtLegajo_Legagenreten( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legagenreten");
      gxTv_SdtLegajo_Legagenreten = value ;
   }

   public String getgxTv_SdtLegajo_Legcontinua( )
   {
      return gxTv_SdtLegajo_Legcontinua ;
   }

   public void setgxTv_SdtLegajo_Legcontinua( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcontinua");
      gxTv_SdtLegajo_Legcontinua = value ;
   }

   public boolean getgxTv_SdtLegajo_Legrecalcliq( )
   {
      return gxTv_SdtLegajo_Legrecalcliq ;
   }

   public void setgxTv_SdtLegajo_Legrecalcliq( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legrecalcliq");
      gxTv_SdtLegajo_Legrecalcliq = value ;
   }

   public boolean getgxTv_SdtLegajo_Legjubilado( )
   {
      return gxTv_SdtLegajo_Legjubilado ;
   }

   public void setgxTv_SdtLegajo_Legjubilado( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legjubilado");
      gxTv_SdtLegajo_Legjubilado = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Leghorasdia( )
   {
      return gxTv_SdtLegajo_Leghorasdia ;
   }

   public void setgxTv_SdtLegajo_Leghorasdia( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leghorasdia");
      gxTv_SdtLegajo_Leghorasdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Leghorassem( )
   {
      return gxTv_SdtLegajo_Leghorassem ;
   }

   public void setgxTv_SdtLegajo_Leghorassem( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leghorassem");
      gxTv_SdtLegajo_Leghorassem = value ;
   }

   public String getgxTv_SdtLegajo_Legreligion( )
   {
      return gxTv_SdtLegajo_Legreligion ;
   }

   public void setgxTv_SdtLegajo_Legreligion( String value )
   {
      gxTv_SdtLegajo_Legreligion_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legreligion");
      gxTv_SdtLegajo_Legreligion = value ;
   }

   public void setgxTv_SdtLegajo_Legreligion_SetNull( )
   {
      gxTv_SdtLegajo_Legreligion_N = (byte)(1) ;
      gxTv_SdtLegajo_Legreligion = "" ;
      SetDirty("Legreligion");
   }

   public boolean getgxTv_SdtLegajo_Legreligion_IsNull( )
   {
      return (gxTv_SdtLegajo_Legreligion_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legorigen( )
   {
      return gxTv_SdtLegajo_Legorigen ;
   }

   public void setgxTv_SdtLegajo_Legorigen( String value )
   {
      gxTv_SdtLegajo_Legorigen_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legorigen");
      gxTv_SdtLegajo_Legorigen = value ;
   }

   public void setgxTv_SdtLegajo_Legorigen_SetNull( )
   {
      gxTv_SdtLegajo_Legorigen_N = (byte)(1) ;
      gxTv_SdtLegajo_Legorigen = "" ;
      SetDirty("Legorigen");
   }

   public boolean getgxTv_SdtLegajo_Legorigen_IsNull( )
   {
      return (gxTv_SdtLegajo_Legorigen_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legpuescodigo( )
   {
      return gxTv_SdtLegajo_Legpuescodigo ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo( String value )
   {
      gxTv_SdtLegajo_Legpuescodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpuescodigo");
      gxTv_SdtLegajo_Legpuescodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legpuescodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpuescodigo = "" ;
      SetDirty("Legpuescodigo");
   }

   public boolean getgxTv_SdtLegajo_Legpuescodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legpuescodigo_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legsuccodigo( )
   {
      return gxTv_SdtLegajo_Legsuccodigo ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo( String value )
   {
      gxTv_SdtLegajo_Legsuccodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsuccodigo");
      gxTv_SdtLegajo_Legsuccodigo = value ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo_SetNull( )
   {
      gxTv_SdtLegajo_Legsuccodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsuccodigo = "" ;
      SetDirty("Legsuccodigo");
   }

   public boolean getgxTv_SdtLegajo_Legsuccodigo_IsNull( )
   {
      return (gxTv_SdtLegajo_Legsuccodigo_N==1) ;
   }

   public boolean getgxTv_SdtLegajo_Legtrablun( )
   {
      return gxTv_SdtLegajo_Legtrablun ;
   }

   public void setgxTv_SdtLegajo_Legtrablun( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrablun");
      gxTv_SdtLegajo_Legtrablun = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabmar( )
   {
      return gxTv_SdtLegajo_Legtrabmar ;
   }

   public void setgxTv_SdtLegajo_Legtrabmar( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabmar");
      gxTv_SdtLegajo_Legtrabmar = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabmie( )
   {
      return gxTv_SdtLegajo_Legtrabmie ;
   }

   public void setgxTv_SdtLegajo_Legtrabmie( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabmie");
      gxTv_SdtLegajo_Legtrabmie = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabjue( )
   {
      return gxTv_SdtLegajo_Legtrabjue ;
   }

   public void setgxTv_SdtLegajo_Legtrabjue( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabjue");
      gxTv_SdtLegajo_Legtrabjue = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabvie( )
   {
      return gxTv_SdtLegajo_Legtrabvie ;
   }

   public void setgxTv_SdtLegajo_Legtrabvie( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabvie");
      gxTv_SdtLegajo_Legtrabvie = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabsa( )
   {
      return gxTv_SdtLegajo_Legtrabsa ;
   }

   public void setgxTv_SdtLegajo_Legtrabsa( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabsa");
      gxTv_SdtLegajo_Legtrabsa = value ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabdo( )
   {
      return gxTv_SdtLegajo_Legtrabdo ;
   }

   public void setgxTv_SdtLegajo_Legtrabdo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabdo");
      gxTv_SdtLegajo_Legtrabdo = value ;
   }

   public GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> getgxTv_SdtLegajo_Tipos_de_trabajo( )
   {
      if ( gxTv_SdtLegajo_Tipos_de_trabajo == null )
      {
         gxTv_SdtLegajo_Tipos_de_trabajo = new GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo>(web.SdtLegajo_tipos_de_trabajo.class, "Legajo.tipos_de_trabajo", "PayDay", remoteHandle);
      }
      gxTv_SdtLegajo_N = (byte)(0) ;
      return gxTv_SdtLegajo_Tipos_de_trabajo ;
   }

   public void setgxTv_SdtLegajo_Tipos_de_trabajo( GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Tipos_de_trabajo");
      gxTv_SdtLegajo_Tipos_de_trabajo = value ;
   }

   public void setgxTv_SdtLegajo_Tipos_de_trabajo_SetNull( )
   {
      gxTv_SdtLegajo_Tipos_de_trabajo = null ;
      SetDirty("Tipos_de_trabajo");
   }

   public boolean getgxTv_SdtLegajo_Tipos_de_trabajo_IsNull( )
   {
      if ( gxTv_SdtLegajo_Tipos_de_trabajo == null )
      {
         return true ;
      }
      return false ;
   }

   public short getgxTv_SdtLegajo_Legvacpend( )
   {
      return gxTv_SdtLegajo_Legvacpend ;
   }

   public void setgxTv_SdtLegajo_Legvacpend( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legvacpend");
      gxTv_SdtLegajo_Legvacpend = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecpreaviso( )
   {
      return gxTv_SdtLegajo_Legfecpreaviso ;
   }

   public void setgxTv_SdtLegajo_Legfecpreaviso( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecpreaviso");
      gxTv_SdtLegajo_Legfecpreaviso = value ;
   }

   public int getgxTv_SdtLegajo_Legconveversioncli( )
   {
      return gxTv_SdtLegajo_Legconveversioncli ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli( int value )
   {
      gxTv_SdtLegajo_Legconveversioncli_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconveversioncli");
      gxTv_SdtLegajo_Legconveversioncli = value ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli_SetNull( )
   {
      gxTv_SdtLegajo_Legconveversioncli_N = (byte)(1) ;
      gxTv_SdtLegajo_Legconveversioncli = 0 ;
      SetDirty("Legconveversioncli");
   }

   public boolean getgxTv_SdtLegajo_Legconveversioncli_IsNull( )
   {
      return (gxTv_SdtLegajo_Legconveversioncli_N==1) ;
   }

   public short getgxTv_SdtLegajo_Legsitrevegreso( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso( short value )
   {
      gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsitrevegreso");
      gxTv_SdtLegajo_Legsitrevegreso = value ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso_SetNull( )
   {
      gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsitrevegreso = (short)(0) ;
      SetDirty("Legsitrevegreso");
   }

   public boolean getgxTv_SdtLegajo_Legsitrevegreso_IsNull( )
   {
      return (gxTv_SdtLegajo_Legsitrevegreso_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legpromdias( )
   {
      return gxTv_SdtLegajo_Legpromdias ;
   }

   public void setgxTv_SdtLegajo_Legpromdias( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpromdias");
      gxTv_SdtLegajo_Legpromdias = value ;
   }

   public String getgxTv_SdtLegajo_Legtitulo( )
   {
      return gxTv_SdtLegajo_Legtitulo ;
   }

   public void setgxTv_SdtLegajo_Legtitulo( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtitulo");
      gxTv_SdtLegajo_Legtitulo = value ;
   }

   public byte getgxTv_SdtLegajo_Legestado( )
   {
      return gxTv_SdtLegajo_Legestado ;
   }

   public void setgxTv_SdtLegajo_Legestado( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legestado");
      gxTv_SdtLegajo_Legestado = value ;
   }

   public int getgxTv_SdtLegajo_Legactclasnro( )
   {
      return gxTv_SdtLegajo_Legactclasnro ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro( int value )
   {
      gxTv_SdtLegajo_Legactclasnro_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactclasnro");
      gxTv_SdtLegajo_Legactclasnro = value ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro_SetNull( )
   {
      gxTv_SdtLegajo_Legactclasnro_N = (byte)(1) ;
      gxTv_SdtLegajo_Legactclasnro = 0 ;
      SetDirty("Legactclasnro");
   }

   public boolean getgxTv_SdtLegajo_Legactclasnro_IsNull( )
   {
      return (gxTv_SdtLegajo_Legactclasnro_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legpueaficod( )
   {
      return gxTv_SdtLegajo_Legpueaficod ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod( String value )
   {
      gxTv_SdtLegajo_Legpueaficod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpueaficod");
      gxTv_SdtLegajo_Legpueaficod = value ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod_SetNull( )
   {
      gxTv_SdtLegajo_Legpueaficod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpueaficod = "" ;
      SetDirty("Legpueaficod");
   }

   public boolean getgxTv_SdtLegajo_Legpueaficod_IsNull( )
   {
      return (gxTv_SdtLegajo_Legpueaficod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Legmigrwarn( )
   {
      return gxTv_SdtLegajo_Legmigrwarn ;
   }

   public void setgxTv_SdtLegajo_Legmigrwarn( String value )
   {
      gxTv_SdtLegajo_Legmigrwarn_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmigrwarn");
      gxTv_SdtLegajo_Legmigrwarn = value ;
   }

   public void setgxTv_SdtLegajo_Legmigrwarn_SetNull( )
   {
      gxTv_SdtLegajo_Legmigrwarn_N = (byte)(1) ;
      gxTv_SdtLegajo_Legmigrwarn = "" ;
      SetDirty("Legmigrwarn");
   }

   public boolean getgxTv_SdtLegajo_Legmigrwarn_IsNull( )
   {
      return (gxTv_SdtLegajo_Legmigrwarn_N==1) ;
   }

   public boolean getgxTv_SdtLegajo_Legincompleto( )
   {
      return gxTv_SdtLegajo_Legincompleto ;
   }

   public void setgxTv_SdtLegajo_Legincompleto( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legincompleto");
      gxTv_SdtLegajo_Legincompleto = value ;
   }

   public boolean getgxTv_SdtLegajo_Legliqapo( )
   {
      return gxTv_SdtLegajo_Legliqapo ;
   }

   public void setgxTv_SdtLegajo_Legliqapo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legliqapo");
      gxTv_SdtLegajo_Legliqapo = value ;
   }

   public GXBCLevelCollection<web.SdtLegajo_Propiedades> getgxTv_SdtLegajo_Propiedades( )
   {
      if ( gxTv_SdtLegajo_Propiedades == null )
      {
         gxTv_SdtLegajo_Propiedades = new GXBCLevelCollection<web.SdtLegajo_Propiedades>(web.SdtLegajo_Propiedades.class, "Legajo.Propiedades", "PayDay", remoteHandle);
      }
      gxTv_SdtLegajo_N = (byte)(0) ;
      return gxTv_SdtLegajo_Propiedades ;
   }

   public void setgxTv_SdtLegajo_Propiedades( GXBCLevelCollection<web.SdtLegajo_Propiedades> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Propiedades");
      gxTv_SdtLegajo_Propiedades = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades = null ;
      SetDirty("Propiedades");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_IsNull( )
   {
      if ( gxTv_SdtLegajo_Propiedades == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtLegajo_Legmodtra( )
   {
      return gxTv_SdtLegajo_Legmodtra ;
   }

   public void setgxTv_SdtLegajo_Legmodtra( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmodtra");
      gxTv_SdtLegajo_Legmodtra = value ;
   }

   public String getgxTv_SdtLegajo_Legtipotarifa( )
   {
      return gxTv_SdtLegajo_Legtipotarifa ;
   }

   public void setgxTv_SdtLegajo_Legtipotarifa( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtipotarifa");
      gxTv_SdtLegajo_Legtipotarifa = value ;
   }

   public String getgxTv_SdtLegajo_Mode( )
   {
      return gxTv_SdtLegajo_Mode ;
   }

   public void setgxTv_SdtLegajo_Mode( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_Mode = value ;
   }

   public void setgxTv_SdtLegajo_Mode_SetNull( )
   {
      gxTv_SdtLegajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Initialized( )
   {
      return gxTv_SdtLegajo_Initialized ;
   }

   public void setgxTv_SdtLegajo_Initialized( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajo_Clicod_Z( )
   {
      return gxTv_SdtLegajo_Clicod_Z ;
   }

   public void setgxTv_SdtLegajo_Clicod_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLegajo_Clicod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Clicod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLegajo_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Empcod_Z( )
   {
      return gxTv_SdtLegajo_Empcod_Z ;
   }

   public void setgxTv_SdtLegajo_Empcod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLegajo_Empcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Empcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Empnom_Z( )
   {
      return gxTv_SdtLegajo_Empnom_Z ;
   }

   public void setgxTv_SdtLegajo_Empnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtLegajo_Empnom_Z = value ;
   }

   public void setgxTv_SdtLegajo_Empnom_Z_SetNull( )
   {
      gxTv_SdtLegajo_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtLegajo_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajo_Legnumero_Z( )
   {
      return gxTv_SdtLegajo_Legnumero_Z ;
   }

   public void setgxTv_SdtLegajo_Legnumero_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtLegajo_Legnumero_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnumero_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legapellido_Z( )
   {
      return gxTv_SdtLegajo_Legapellido_Z ;
   }

   public void setgxTv_SdtLegajo_Legapellido_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legapellido_Z");
      gxTv_SdtLegajo_Legapellido_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legapellido_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legapellido_Z = "" ;
      SetDirty("Legapellido_Z");
   }

   public boolean getgxTv_SdtLegajo_Legapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legnombre_Z( )
   {
      return gxTv_SdtLegajo_Legnombre_Z ;
   }

   public void setgxTv_SdtLegajo_Legnombre_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnombre_Z");
      gxTv_SdtLegajo_Legnombre_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnombre_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnombre_Z = "" ;
      SetDirty("Legnombre_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legfotonom_Z( )
   {
      return gxTv_SdtLegajo_Legfotonom_Z ;
   }

   public void setgxTv_SdtLegajo_Legfotonom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfotonom_Z");
      gxTv_SdtLegajo_Legfotonom_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfotonom_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfotonom_Z = "" ;
      SetDirty("Legfotonom_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfotonom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legfotoext_Z( )
   {
      return gxTv_SdtLegajo_Legfotoext_Z ;
   }

   public void setgxTv_SdtLegajo_Legfotoext_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfotoext_Z");
      gxTv_SdtLegajo_Legfotoext_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfotoext_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfotoext_Z = "" ;
      SetDirty("Legfotoext_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfotoext_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legtipdoc_Z( )
   {
      return gxTv_SdtLegajo_Legtipdoc_Z ;
   }

   public void setgxTv_SdtLegajo_Legtipdoc_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtipdoc_Z");
      gxTv_SdtLegajo_Legtipdoc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtipdoc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtipdoc_Z = (byte)(0) ;
      SetDirty("Legtipdoc_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtipdoc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legnumdoc_Z( )
   {
      return gxTv_SdtLegajo_Legnumdoc_Z ;
   }

   public void setgxTv_SdtLegajo_Legnumdoc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnumdoc_Z");
      gxTv_SdtLegajo_Legnumdoc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnumdoc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnumdoc_Z = "" ;
      SetDirty("Legnumdoc_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnumdoc_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecnac_Z( )
   {
      return gxTv_SdtLegajo_Legfecnac_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecnac_Z");
      gxTv_SdtLegajo_Legfecnac_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecnac_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecnac_Z = GXutil.nullDate() ;
      SetDirty("Legfecnac_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecnac_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legsexo_Z( )
   {
      return gxTv_SdtLegajo_Legsexo_Z ;
   }

   public void setgxTv_SdtLegajo_Legsexo_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsexo_Z");
      gxTv_SdtLegajo_Legsexo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legsexo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legsexo_Z = (byte)(0) ;
      SetDirty("Legsexo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legsexo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legestadocivil_Z( )
   {
      return gxTv_SdtLegajo_Legestadocivil_Z ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legestadocivil_Z");
      gxTv_SdtLegajo_Legestadocivil_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legestadocivil_Z = (short)(0) ;
      SetDirty("Legestadocivil_Z");
   }

   public boolean getgxTv_SdtLegajo_Legestadocivil_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legnacioncod_Z( )
   {
      return gxTv_SdtLegajo_Legnacioncod_Z ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnacioncod_Z");
      gxTv_SdtLegajo_Legnacioncod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnacioncod_Z = (short)(0) ;
      SetDirty("Legnacioncod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnacioncod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legnacionalidad_Z( )
   {
      return gxTv_SdtLegajo_Legnacionalidad_Z ;
   }

   public void setgxTv_SdtLegajo_Legnacionalidad_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnacionalidad_Z");
      gxTv_SdtLegajo_Legnacionalidad_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnacionalidad_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnacionalidad_Z = "" ;
      SetDirty("Legnacionalidad_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnacionalidad_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtLegajo_Legcuil_Z( )
   {
      return gxTv_SdtLegajo_Legcuil_Z ;
   }

   public void setgxTv_SdtLegajo_Legcuil_Z( long value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcuil_Z");
      gxTv_SdtLegajo_Legcuil_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcuil_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcuil_Z = 0 ;
      SetDirty("Legcuil_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcuil_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legdiscapacidad_Z( )
   {
      return gxTv_SdtLegajo_Legdiscapacidad_Z ;
   }

   public void setgxTv_SdtLegajo_Legdiscapacidad_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legdiscapacidad_Z");
      gxTv_SdtLegajo_Legdiscapacidad_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legdiscapacidad_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legdiscapacidad_Z = (byte)(0) ;
      SetDirty("Legdiscapacidad_Z");
   }

   public boolean getgxTv_SdtLegajo_Legdiscapacidad_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legdomici_Z( )
   {
      return gxTv_SdtLegajo_Legdomici_Z ;
   }

   public void setgxTv_SdtLegajo_Legdomici_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legdomici_Z");
      gxTv_SdtLegajo_Legdomici_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legdomici_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legdomici_Z = "" ;
      SetDirty("Legdomici_Z");
   }

   public boolean getgxTv_SdtLegajo_Legdomici_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legemail_Z( )
   {
      return gxTv_SdtLegajo_Legemail_Z ;
   }

   public void setgxTv_SdtLegajo_Legemail_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legemail_Z");
      gxTv_SdtLegajo_Legemail_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legemail_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legemail_Z = "" ;
      SetDirty("Legemail_Z");
   }

   public boolean getgxTv_SdtLegajo_Legemail_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legcodpos_Z( )
   {
      return gxTv_SdtLegajo_Legcodpos_Z ;
   }

   public void setgxTv_SdtLegajo_Legcodpos_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcodpos_Z");
      gxTv_SdtLegajo_Legcodpos_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcodpos_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcodpos_Z = "" ;
      SetDirty("Legcodpos_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcodpos_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legpaicod_Z( )
   {
      return gxTv_SdtLegajo_Legpaicod_Z ;
   }

   public void setgxTv_SdtLegajo_Legpaicod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpaicod_Z");
      gxTv_SdtLegajo_Legpaicod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legpaicod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legpaicod_Z = (short)(0) ;
      SetDirty("Legpaicod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legpaicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legpainom_Z( )
   {
      return gxTv_SdtLegajo_Legpainom_Z ;
   }

   public void setgxTv_SdtLegajo_Legpainom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpainom_Z");
      gxTv_SdtLegajo_Legpainom_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legpainom_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legpainom_Z = "" ;
      SetDirty("Legpainom_Z");
   }

   public boolean getgxTv_SdtLegajo_Legpainom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legprovcod_Z( )
   {
      return gxTv_SdtLegajo_Legprovcod_Z ;
   }

   public void setgxTv_SdtLegajo_Legprovcod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legprovcod_Z");
      gxTv_SdtLegajo_Legprovcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legprovcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legprovcod_Z = (short)(0) ;
      SetDirty("Legprovcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legprovcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legprovnom_Z( )
   {
      return gxTv_SdtLegajo_Legprovnom_Z ;
   }

   public void setgxTv_SdtLegajo_Legprovnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legprovnom_Z");
      gxTv_SdtLegajo_Legprovnom_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legprovnom_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legprovnom_Z = "" ;
      SetDirty("Legprovnom_Z");
   }

   public boolean getgxTv_SdtLegajo_Legprovnom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legloccod_Z( )
   {
      return gxTv_SdtLegajo_Legloccod_Z ;
   }

   public void setgxTv_SdtLegajo_Legloccod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legloccod_Z");
      gxTv_SdtLegajo_Legloccod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legloccod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legloccod_Z = (short)(0) ;
      SetDirty("Legloccod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legloccod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Leglocnom_Z( )
   {
      return gxTv_SdtLegajo_Leglocnom_Z ;
   }

   public void setgxTv_SdtLegajo_Leglocnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglocnom_Z");
      gxTv_SdtLegajo_Leglocnom_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leglocnom_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leglocnom_Z = "" ;
      SetDirty("Leglocnom_Z");
   }

   public boolean getgxTv_SdtLegajo_Leglocnom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legtelefono_Z( )
   {
      return gxTv_SdtLegajo_Legtelefono_Z ;
   }

   public void setgxTv_SdtLegajo_Legtelefono_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtelefono_Z");
      gxTv_SdtLegajo_Legtelefono_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtelefono_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtelefono_Z = "" ;
      SetDirty("Legtelefono_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtelefono_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecingreso_Z( )
   {
      return gxTv_SdtLegajo_Legfecingreso_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecingreso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecingreso_Z");
      gxTv_SdtLegajo_Legfecingreso_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecingreso_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecingreso_Z = GXutil.nullDate() ;
      SetDirty("Legfecingreso_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecingreso_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecegreso_Z( )
   {
      return gxTv_SdtLegajo_Legfecegreso_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecegreso_Z");
      gxTv_SdtLegajo_Legfecegreso_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecegreso_Z = GXutil.nullDate() ;
      SetDirty("Legfecegreso_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecegreso_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legmegcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legmegcodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmegcodigo_Z");
      gxTv_SdtLegajo_Legmegcodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legmegcodigo_Z = "" ;
      SetDirty("Legmegcodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legmegcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Megdescrip_Z( )
   {
      return gxTv_SdtLegajo_Megdescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Megdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Megdescrip_Z");
      gxTv_SdtLegajo_Megdescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Megdescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Megdescrip_Z = "" ;
      SetDirty("Megdescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Megdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legcatcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legcatcodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatcodigo_Z");
      gxTv_SdtLegajo_Legcatcodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcatcodigo_Z = "" ;
      SetDirty("Legcatcodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcatcodigo_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajo_Legcatpuecod_Z( )
   {
      return gxTv_SdtLegajo_Legcatpuecod_Z ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatpuecod_Z");
      gxTv_SdtLegajo_Legcatpuecod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcatpuecod_Z = 0 ;
      SetDirty("Legcatpuecod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcatpuecod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legseccodigo_Z( )
   {
      return gxTv_SdtLegajo_Legseccodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legseccodigo_Z");
      gxTv_SdtLegajo_Legseccodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legseccodigo_Z = "" ;
      SetDirty("Legseccodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legseccodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Secdescrip_Z( )
   {
      return gxTv_SdtLegajo_Secdescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Secdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Secdescrip_Z");
      gxTv_SdtLegajo_Secdescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Secdescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Secdescrip_Z = "" ;
      SetDirty("Secdescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Secdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Leglpgcodigo_Z( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglpgcodigo_Z");
      gxTv_SdtLegajo_Leglpgcodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leglpgcodigo_Z = "" ;
      SetDirty("Leglpgcodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Leglpgcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Lpgdescri_Z( )
   {
      return gxTv_SdtLegajo_Lpgdescri_Z ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Lpgdescri_Z");
      gxTv_SdtLegajo_Lpgdescri_Z = value ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri_Z_SetNull( )
   {
      gxTv_SdtLegajo_Lpgdescri_Z = "" ;
      SetDirty("Lpgdescri_Z");
   }

   public boolean getgxTv_SdtLegajo_Lpgdescri_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legclase_Z( )
   {
      return gxTv_SdtLegajo_Legclase_Z ;
   }

   public void setgxTv_SdtLegajo_Legclase_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legclase_Z");
      gxTv_SdtLegajo_Legclase_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legclase_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legclase_Z = (byte)(0) ;
      SetDirty("Legclase_Z");
   }

   public boolean getgxTv_SdtLegajo_Legclase_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Legbasico_Z( )
   {
      return gxTv_SdtLegajo_Legbasico_Z ;
   }

   public void setgxTv_SdtLegajo_Legbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbasico_Z");
      gxTv_SdtLegajo_Legbasico_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legbasico_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legbasico_Z = DecimalUtil.ZERO ;
      SetDirty("Legbasico_Z");
   }

   public boolean getgxTv_SdtLegajo_Legbasico_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legformapago_Z( )
   {
      return gxTv_SdtLegajo_Legformapago_Z ;
   }

   public void setgxTv_SdtLegajo_Legformapago_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legformapago_Z");
      gxTv_SdtLegajo_Legformapago_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legformapago_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legformapago_Z = (byte)(0) ;
      SetDirty("Legformapago_Z");
   }

   public boolean getgxTv_SdtLegajo_Legformapago_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legbancod_Z( )
   {
      return gxTv_SdtLegajo_Legbancod_Z ;
   }

   public void setgxTv_SdtLegajo_Legbancod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbancod_Z");
      gxTv_SdtLegajo_Legbancod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legbancod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legbancod_Z = "" ;
      SetDirty("Legbancod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legbancod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legbandes_Z( )
   {
      return gxTv_SdtLegajo_Legbandes_Z ;
   }

   public void setgxTv_SdtLegajo_Legbandes_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbandes_Z");
      gxTv_SdtLegajo_Legbandes_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legbandes_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legbandes_Z = "" ;
      SetDirty("Legbandes_Z");
   }

   public boolean getgxTv_SdtLegajo_Legbandes_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legbansuc_Z( )
   {
      return gxTv_SdtLegajo_Legbansuc_Z ;
   }

   public void setgxTv_SdtLegajo_Legbansuc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbansuc_Z");
      gxTv_SdtLegajo_Legbansuc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legbansuc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legbansuc_Z = "" ;
      SetDirty("Legbansuc_Z");
   }

   public boolean getgxTv_SdtLegajo_Legbansuc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legbantipcuen_Z( )
   {
      return gxTv_SdtLegajo_Legbantipcuen_Z ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbantipcuen_Z");
      gxTv_SdtLegajo_Legbantipcuen_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legbantipcuen_Z = "" ;
      SetDirty("Legbantipcuen_Z");
   }

   public boolean getgxTv_SdtLegajo_Legbantipcuen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legsincod_Z( )
   {
      return gxTv_SdtLegajo_Legsincod_Z ;
   }

   public void setgxTv_SdtLegajo_Legsincod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsincod_Z");
      gxTv_SdtLegajo_Legsincod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legsincod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legsincod_Z = "" ;
      SetDirty("Legsincod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legsincod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Sindescrip_Z( )
   {
      return gxTv_SdtLegajo_Sindescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Sindescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Sindescrip_Z");
      gxTv_SdtLegajo_Sindescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Sindescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Sindescrip_Z = "" ;
      SetDirty("Sindescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Sindescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legosocod_Z( )
   {
      return gxTv_SdtLegajo_Legosocod_Z ;
   }

   public void setgxTv_SdtLegajo_Legosocod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosocod_Z");
      gxTv_SdtLegajo_Legosocod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legosocod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legosocod_Z = "" ;
      SetDirty("Legosocod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legosocod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legosodes_Z( )
   {
      return gxTv_SdtLegajo_Legosodes_Z ;
   }

   public void setgxTv_SdtLegajo_Legosodes_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosodes_Z");
      gxTv_SdtLegajo_Legosodes_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legosodes_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legosodes_Z = "" ;
      SetDirty("Legosodes_Z");
   }

   public boolean getgxTv_SdtLegajo_Legosodes_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legosoafipcod_Z( )
   {
      return gxTv_SdtLegajo_Legosoafipcod_Z ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosoafipcod_Z");
      gxTv_SdtLegajo_Legosoafipcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legosoafipcod_Z = "" ;
      SetDirty("Legosoafipcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legosoafipcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Osodescrip_Z( )
   {
      return gxTv_SdtLegajo_Osodescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Osodescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osodescrip_Z");
      gxTv_SdtLegajo_Osodescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Osodescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Osodescrip_Z = "" ;
      SetDirty("Osodescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Osodescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legactcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legactcodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactcodigo_Z");
      gxTv_SdtLegajo_Legactcodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legactcodigo_Z = "" ;
      SetDirty("Legactcodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legactcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legactdescri_Z( )
   {
      return gxTv_SdtLegajo_Legactdescri_Z ;
   }

   public void setgxTv_SdtLegajo_Legactdescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactdescri_Z");
      gxTv_SdtLegajo_Legactdescri_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legactdescri_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legactdescri_Z = "" ;
      SetDirty("Legactdescri_Z");
   }

   public boolean getgxTv_SdtLegajo_Legactdescri_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Mprcod_Z( )
   {
      return gxTv_SdtLegajo_Mprcod_Z ;
   }

   public void setgxTv_SdtLegajo_Mprcod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mprcod_Z");
      gxTv_SdtLegajo_Mprcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Mprcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Mprcod_Z = "" ;
      SetDirty("Mprcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Mprcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Mprdescrip_Z( )
   {
      return gxTv_SdtLegajo_Mprdescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Mprdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mprdescrip_Z");
      gxTv_SdtLegajo_Mprdescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Mprdescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Mprdescrip_Z = "" ;
      SetDirty("Mprdescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Mprdescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecultmod_Z( )
   {
      return gxTv_SdtLegajo_Legfecultmod_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecultmod_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecultmod_Z");
      gxTv_SdtLegajo_Legfecultmod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecultmod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecultmod_Z = GXutil.nullDate() ;
      SetDirty("Legfecultmod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecultmod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legcuentabanc_Z( )
   {
      return gxTv_SdtLegajo_Legcuentabanc_Z ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcuentabanc_Z");
      gxTv_SdtLegajo_Legcuentabanc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcuentabanc_Z = "" ;
      SetDirty("Legcuentabanc_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcuentabanc_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Leglicinicio_Z( )
   {
      return gxTv_SdtLegajo_Leglicinicio_Z ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicinicio_Z");
      gxTv_SdtLegajo_Leglicinicio_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leglicinicio_Z = GXutil.nullDate() ;
      SetDirty("Leglicinicio_Z");
   }

   public boolean getgxTv_SdtLegajo_Leglicinicio_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Leglicfinal_Z( )
   {
      return gxTv_SdtLegajo_Leglicfinal_Z ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicfinal_Z");
      gxTv_SdtLegajo_Leglicfinal_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leglicfinal_Z = GXutil.nullDate() ;
      SetDirty("Leglicfinal_Z");
   }

   public boolean getgxTv_SdtLegajo_Leglicfinal_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Zoncod_Z( )
   {
      return gxTv_SdtLegajo_Zoncod_Z ;
   }

   public void setgxTv_SdtLegajo_Zoncod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zoncod_Z");
      gxTv_SdtLegajo_Zoncod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Zoncod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Zoncod_Z = "" ;
      SetDirty("Zoncod_Z");
   }

   public boolean getgxTv_SdtLegajo_Zoncod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Zondescrip_Z( )
   {
      return gxTv_SdtLegajo_Zondescrip_Z ;
   }

   public void setgxTv_SdtLegajo_Zondescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zondescrip_Z");
      gxTv_SdtLegajo_Zondescrip_Z = value ;
   }

   public void setgxTv_SdtLegajo_Zondescrip_Z_SetNull( )
   {
      gxTv_SdtLegajo_Zondescrip_Z = "" ;
      SetDirty("Zondescrip_Z");
   }

   public boolean getgxTv_SdtLegajo_Zondescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Zonporcreduc_Z( )
   {
      return gxTv_SdtLegajo_Zonporcreduc_Z ;
   }

   public void setgxTv_SdtLegajo_Zonporcreduc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zonporcreduc_Z");
      gxTv_SdtLegajo_Zonporcreduc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Zonporcreduc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Zonporcreduc_Z = DecimalUtil.ZERO ;
      SetDirty("Zonporcreduc_Z");
   }

   public boolean getgxTv_SdtLegajo_Zonporcreduc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legcbu_Z( )
   {
      return gxTv_SdtLegajo_Legcbu_Z ;
   }

   public void setgxTv_SdtLegajo_Legcbu_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcbu_Z");
      gxTv_SdtLegajo_Legcbu_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcbu_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcbu_Z = "" ;
      SetDirty("Legcbu_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcbu_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legconvenio_Z( )
   {
      return gxTv_SdtLegajo_Legconvenio_Z ;
   }

   public void setgxTv_SdtLegajo_Legconvenio_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconvenio_Z");
      gxTv_SdtLegajo_Legconvenio_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legconvenio_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legconvenio_Z = false ;
      SetDirty("Legconvenio_Z");
   }

   public boolean getgxTv_SdtLegajo_Legconvenio_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legscvo_Z( )
   {
      return gxTv_SdtLegajo_Legscvo_Z ;
   }

   public void setgxTv_SdtLegajo_Legscvo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legscvo_Z");
      gxTv_SdtLegajo_Legscvo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legscvo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legscvo_Z = false ;
      SetDirty("Legscvo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legscvo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Condicodigo_Z( )
   {
      return gxTv_SdtLegajo_Condicodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Condicodigo_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Condicodigo_Z");
      gxTv_SdtLegajo_Condicodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Condicodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Condicodigo_Z = (short)(0) ;
      SetDirty("Condicodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Condicodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Condidescri_Z( )
   {
      return gxTv_SdtLegajo_Condidescri_Z ;
   }

   public void setgxTv_SdtLegajo_Condidescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Condidescri_Z");
      gxTv_SdtLegajo_Condidescri_Z = value ;
   }

   public void setgxTv_SdtLegajo_Condidescri_Z_SetNull( )
   {
      gxTv_SdtLegajo_Condidescri_Z = "" ;
      SetDirty("Condidescri_Z");
   }

   public boolean getgxTv_SdtLegajo_Condidescri_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Siniecodigo_Z( )
   {
      return gxTv_SdtLegajo_Siniecodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Siniecodigo_Z");
      gxTv_SdtLegajo_Siniecodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Siniecodigo_Z = "" ;
      SetDirty("Siniecodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Siniecodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Siniedescri_Z( )
   {
      return gxTv_SdtLegajo_Siniedescri_Z ;
   }

   public void setgxTv_SdtLegajo_Siniedescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Siniedescri_Z");
      gxTv_SdtLegajo_Siniedescri_Z = value ;
   }

   public void setgxTv_SdtLegajo_Siniedescri_Z_SetNull( )
   {
      gxTv_SdtLegajo_Siniedescri_Z = "" ;
      SetDirty("Siniedescri_Z");
   }

   public boolean getgxTv_SdtLegajo_Siniedescri_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legactivo_Z( )
   {
      return gxTv_SdtLegajo_Legactivo_Z ;
   }

   public void setgxTv_SdtLegajo_Legactivo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactivo_Z");
      gxTv_SdtLegajo_Legactivo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legactivo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legactivo_Z = false ;
      SetDirty("Legactivo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legactivo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Legsueldofuera_Z( )
   {
      return gxTv_SdtLegajo_Legsueldofuera_Z ;
   }

   public void setgxTv_SdtLegajo_Legsueldofuera_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsueldofuera_Z");
      gxTv_SdtLegajo_Legsueldofuera_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legsueldofuera_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legsueldofuera_Z = DecimalUtil.ZERO ;
      SetDirty("Legsueldofuera_Z");
   }

   public boolean getgxTv_SdtLegajo_Legsueldofuera_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legid_Z( )
   {
      return gxTv_SdtLegajo_Legid_Z ;
   }

   public void setgxTv_SdtLegajo_Legid_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legid_Z");
      gxTv_SdtLegajo_Legid_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legid_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legid_Z = "" ;
      SetDirty("Legid_Z");
   }

   public boolean getgxTv_SdtLegajo_Legid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legconvecodigo_Z( )
   {
      return gxTv_SdtLegajo_Legconvecodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconvecodigo_Z");
      gxTv_SdtLegajo_Legconvecodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legconvecodigo_Z = "" ;
      SetDirty("Legconvecodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legconvecodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legidnomape_Z( )
   {
      return gxTv_SdtLegajo_Legidnomape_Z ;
   }

   public void setgxTv_SdtLegajo_Legidnomape_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legidnomape_Z");
      gxTv_SdtLegajo_Legidnomape_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legidnomape_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legidnomape_Z = "" ;
      SetDirty("Legidnomape_Z");
   }

   public boolean getgxTv_SdtLegajo_Legidnomape_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Tipemplecod_Z( )
   {
      return gxTv_SdtLegajo_Tipemplecod_Z ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Tipemplecod_Z");
      gxTv_SdtLegajo_Tipemplecod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Tipemplecod_Z = "" ;
      SetDirty("Tipemplecod_Z");
   }

   public boolean getgxTv_SdtLegajo_Tipemplecod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Osoc3992_Z( )
   {
      return gxTv_SdtLegajo_Osoc3992_Z ;
   }

   public void setgxTv_SdtLegajo_Osoc3992_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osoc3992_Z");
      gxTv_SdtLegajo_Osoc3992_Z = value ;
   }

   public void setgxTv_SdtLegajo_Osoc3992_Z_SetNull( )
   {
      gxTv_SdtLegajo_Osoc3992_Z = "" ;
      SetDirty("Osoc3992_Z");
   }

   public boolean getgxTv_SdtLegajo_Osoc3992_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legnomape_Z( )
   {
      return gxTv_SdtLegajo_Legnomape_Z ;
   }

   public void setgxTv_SdtLegajo_Legnomape_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnomape_Z");
      gxTv_SdtLegajo_Legnomape_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legnomape_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legnomape_Z = "" ;
      SetDirty("Legnomape_Z");
   }

   public boolean getgxTv_SdtLegajo_Legnomape_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecimportacion_Z( )
   {
      return gxTv_SdtLegajo_Legfecimportacion_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecimportacion_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecimportacion_Z");
      gxTv_SdtLegajo_Legfecimportacion_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecimportacion_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecimportacion_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Legfecimportacion_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecimportacion_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legagenreten_Z( )
   {
      return gxTv_SdtLegajo_Legagenreten_Z ;
   }

   public void setgxTv_SdtLegajo_Legagenreten_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legagenreten_Z");
      gxTv_SdtLegajo_Legagenreten_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legagenreten_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legagenreten_Z = false ;
      SetDirty("Legagenreten_Z");
   }

   public boolean getgxTv_SdtLegajo_Legagenreten_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legcontinua_Z( )
   {
      return gxTv_SdtLegajo_Legcontinua_Z ;
   }

   public void setgxTv_SdtLegajo_Legcontinua_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcontinua_Z");
      gxTv_SdtLegajo_Legcontinua_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legcontinua_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legcontinua_Z = "" ;
      SetDirty("Legcontinua_Z");
   }

   public boolean getgxTv_SdtLegajo_Legcontinua_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legrecalcliq_Z( )
   {
      return gxTv_SdtLegajo_Legrecalcliq_Z ;
   }

   public void setgxTv_SdtLegajo_Legrecalcliq_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legrecalcliq_Z");
      gxTv_SdtLegajo_Legrecalcliq_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legrecalcliq_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legrecalcliq_Z = false ;
      SetDirty("Legrecalcliq_Z");
   }

   public boolean getgxTv_SdtLegajo_Legrecalcliq_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legjubilado_Z( )
   {
      return gxTv_SdtLegajo_Legjubilado_Z ;
   }

   public void setgxTv_SdtLegajo_Legjubilado_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legjubilado_Z");
      gxTv_SdtLegajo_Legjubilado_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legjubilado_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legjubilado_Z = false ;
      SetDirty("Legjubilado_Z");
   }

   public boolean getgxTv_SdtLegajo_Legjubilado_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Leghorasdia_Z( )
   {
      return gxTv_SdtLegajo_Leghorasdia_Z ;
   }

   public void setgxTv_SdtLegajo_Leghorasdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leghorasdia_Z");
      gxTv_SdtLegajo_Leghorasdia_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leghorasdia_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leghorasdia_Z = DecimalUtil.ZERO ;
      SetDirty("Leghorasdia_Z");
   }

   public boolean getgxTv_SdtLegajo_Leghorasdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Leghorassem_Z( )
   {
      return gxTv_SdtLegajo_Leghorassem_Z ;
   }

   public void setgxTv_SdtLegajo_Leghorassem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leghorassem_Z");
      gxTv_SdtLegajo_Leghorassem_Z = value ;
   }

   public void setgxTv_SdtLegajo_Leghorassem_Z_SetNull( )
   {
      gxTv_SdtLegajo_Leghorassem_Z = DecimalUtil.ZERO ;
      SetDirty("Leghorassem_Z");
   }

   public boolean getgxTv_SdtLegajo_Leghorassem_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legreligion_Z( )
   {
      return gxTv_SdtLegajo_Legreligion_Z ;
   }

   public void setgxTv_SdtLegajo_Legreligion_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legreligion_Z");
      gxTv_SdtLegajo_Legreligion_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legreligion_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legreligion_Z = "" ;
      SetDirty("Legreligion_Z");
   }

   public boolean getgxTv_SdtLegajo_Legreligion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legorigen_Z( )
   {
      return gxTv_SdtLegajo_Legorigen_Z ;
   }

   public void setgxTv_SdtLegajo_Legorigen_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legorigen_Z");
      gxTv_SdtLegajo_Legorigen_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legorigen_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legorigen_Z = "" ;
      SetDirty("Legorigen_Z");
   }

   public boolean getgxTv_SdtLegajo_Legorigen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legpuescodigo_Z( )
   {
      return gxTv_SdtLegajo_Legpuescodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpuescodigo_Z");
      gxTv_SdtLegajo_Legpuescodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legpuescodigo_Z = "" ;
      SetDirty("Legpuescodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legpuescodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legsuccodigo_Z( )
   {
      return gxTv_SdtLegajo_Legsuccodigo_Z ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsuccodigo_Z");
      gxTv_SdtLegajo_Legsuccodigo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legsuccodigo_Z = "" ;
      SetDirty("Legsuccodigo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legsuccodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrablun_Z( )
   {
      return gxTv_SdtLegajo_Legtrablun_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrablun_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrablun_Z");
      gxTv_SdtLegajo_Legtrablun_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrablun_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrablun_Z = false ;
      SetDirty("Legtrablun_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrablun_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabmar_Z( )
   {
      return gxTv_SdtLegajo_Legtrabmar_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabmar_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabmar_Z");
      gxTv_SdtLegajo_Legtrabmar_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabmar_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabmar_Z = false ;
      SetDirty("Legtrabmar_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabmar_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabmie_Z( )
   {
      return gxTv_SdtLegajo_Legtrabmie_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabmie_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabmie_Z");
      gxTv_SdtLegajo_Legtrabmie_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabmie_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabmie_Z = false ;
      SetDirty("Legtrabmie_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabmie_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabjue_Z( )
   {
      return gxTv_SdtLegajo_Legtrabjue_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabjue_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabjue_Z");
      gxTv_SdtLegajo_Legtrabjue_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabjue_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabjue_Z = false ;
      SetDirty("Legtrabjue_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabjue_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabvie_Z( )
   {
      return gxTv_SdtLegajo_Legtrabvie_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabvie_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabvie_Z");
      gxTv_SdtLegajo_Legtrabvie_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabvie_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabvie_Z = false ;
      SetDirty("Legtrabvie_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabvie_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabsa_Z( )
   {
      return gxTv_SdtLegajo_Legtrabsa_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabsa_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabsa_Z");
      gxTv_SdtLegajo_Legtrabsa_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabsa_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabsa_Z = false ;
      SetDirty("Legtrabsa_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabsa_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legtrabdo_Z( )
   {
      return gxTv_SdtLegajo_Legtrabdo_Z ;
   }

   public void setgxTv_SdtLegajo_Legtrabdo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtrabdo_Z");
      gxTv_SdtLegajo_Legtrabdo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtrabdo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtrabdo_Z = false ;
      SetDirty("Legtrabdo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtrabdo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legvacpend_Z( )
   {
      return gxTv_SdtLegajo_Legvacpend_Z ;
   }

   public void setgxTv_SdtLegajo_Legvacpend_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legvacpend_Z");
      gxTv_SdtLegajo_Legvacpend_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legvacpend_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legvacpend_Z = (short)(0) ;
      SetDirty("Legvacpend_Z");
   }

   public boolean getgxTv_SdtLegajo_Legvacpend_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Legfecpreaviso_Z( )
   {
      return gxTv_SdtLegajo_Legfecpreaviso_Z ;
   }

   public void setgxTv_SdtLegajo_Legfecpreaviso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecpreaviso_Z");
      gxTv_SdtLegajo_Legfecpreaviso_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legfecpreaviso_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legfecpreaviso_Z = GXutil.nullDate() ;
      SetDirty("Legfecpreaviso_Z");
   }

   public boolean getgxTv_SdtLegajo_Legfecpreaviso_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajo_Legconveversioncli_Z( )
   {
      return gxTv_SdtLegajo_Legconveversioncli_Z ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconveversioncli_Z");
      gxTv_SdtLegajo_Legconveversioncli_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legconveversioncli_Z = 0 ;
      SetDirty("Legconveversioncli_Z");
   }

   public boolean getgxTv_SdtLegajo_Legconveversioncli_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Legsitrevegreso_Z( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso_Z ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsitrevegreso_Z");
      gxTv_SdtLegajo_Legsitrevegreso_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legsitrevegreso_Z = (short)(0) ;
      SetDirty("Legsitrevegreso_Z");
   }

   public boolean getgxTv_SdtLegajo_Legsitrevegreso_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legpromdias_Z( )
   {
      return gxTv_SdtLegajo_Legpromdias_Z ;
   }

   public void setgxTv_SdtLegajo_Legpromdias_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpromdias_Z");
      gxTv_SdtLegajo_Legpromdias_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legpromdias_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legpromdias_Z = "" ;
      SetDirty("Legpromdias_Z");
   }

   public boolean getgxTv_SdtLegajo_Legpromdias_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legtitulo_Z( )
   {
      return gxTv_SdtLegajo_Legtitulo_Z ;
   }

   public void setgxTv_SdtLegajo_Legtitulo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtitulo_Z");
      gxTv_SdtLegajo_Legtitulo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtitulo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtitulo_Z = "" ;
      SetDirty("Legtitulo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtitulo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legestado_Z( )
   {
      return gxTv_SdtLegajo_Legestado_Z ;
   }

   public void setgxTv_SdtLegajo_Legestado_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legestado_Z");
      gxTv_SdtLegajo_Legestado_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legestado_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legestado_Z = (byte)(0) ;
      SetDirty("Legestado_Z");
   }

   public boolean getgxTv_SdtLegajo_Legestado_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajo_Legactclasnro_Z( )
   {
      return gxTv_SdtLegajo_Legactclasnro_Z ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactclasnro_Z");
      gxTv_SdtLegajo_Legactclasnro_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legactclasnro_Z = 0 ;
      SetDirty("Legactclasnro_Z");
   }

   public boolean getgxTv_SdtLegajo_Legactclasnro_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legpueaficod_Z( )
   {
      return gxTv_SdtLegajo_Legpueaficod_Z ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpueaficod_Z");
      gxTv_SdtLegajo_Legpueaficod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legpueaficod_Z = "" ;
      SetDirty("Legpueaficod_Z");
   }

   public boolean getgxTv_SdtLegajo_Legpueaficod_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legincompleto_Z( )
   {
      return gxTv_SdtLegajo_Legincompleto_Z ;
   }

   public void setgxTv_SdtLegajo_Legincompleto_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legincompleto_Z");
      gxTv_SdtLegajo_Legincompleto_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legincompleto_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legincompleto_Z = false ;
      SetDirty("Legincompleto_Z");
   }

   public boolean getgxTv_SdtLegajo_Legincompleto_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Legliqapo_Z( )
   {
      return gxTv_SdtLegajo_Legliqapo_Z ;
   }

   public void setgxTv_SdtLegajo_Legliqapo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legliqapo_Z");
      gxTv_SdtLegajo_Legliqapo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legliqapo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legliqapo_Z = false ;
      SetDirty("Legliqapo_Z");
   }

   public boolean getgxTv_SdtLegajo_Legliqapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legmodtra_Z( )
   {
      return gxTv_SdtLegajo_Legmodtra_Z ;
   }

   public void setgxTv_SdtLegajo_Legmodtra_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmodtra_Z");
      gxTv_SdtLegajo_Legmodtra_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legmodtra_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legmodtra_Z = "" ;
      SetDirty("Legmodtra_Z");
   }

   public boolean getgxTv_SdtLegajo_Legmodtra_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Legtipotarifa_Z( )
   {
      return gxTv_SdtLegajo_Legtipotarifa_Z ;
   }

   public void setgxTv_SdtLegajo_Legtipotarifa_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtipotarifa_Z");
      gxTv_SdtLegajo_Legtipotarifa_Z = value ;
   }

   public void setgxTv_SdtLegajo_Legtipotarifa_Z_SetNull( )
   {
      gxTv_SdtLegajo_Legtipotarifa_Z = "" ;
      SetDirty("Legtipotarifa_Z");
   }

   public boolean getgxTv_SdtLegajo_Legtipotarifa_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legfoto_N( )
   {
      return gxTv_SdtLegajo_Legfoto_N ;
   }

   public void setgxTv_SdtLegajo_Legfoto_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfoto_N");
      gxTv_SdtLegajo_Legfoto_N = value ;
   }

   public void setgxTv_SdtLegajo_Legfoto_N_SetNull( )
   {
      gxTv_SdtLegajo_Legfoto_N = (byte)(0) ;
      SetDirty("Legfoto_N");
   }

   public boolean getgxTv_SdtLegajo_Legfoto_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legsexo_N( )
   {
      return gxTv_SdtLegajo_Legsexo_N ;
   }

   public void setgxTv_SdtLegajo_Legsexo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsexo_N");
      gxTv_SdtLegajo_Legsexo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legsexo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legsexo_N = (byte)(0) ;
      SetDirty("Legsexo_N");
   }

   public boolean getgxTv_SdtLegajo_Legsexo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legestadocivil_N( )
   {
      return gxTv_SdtLegajo_Legestadocivil_N ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legestadocivil_N");
      gxTv_SdtLegajo_Legestadocivil_N = value ;
   }

   public void setgxTv_SdtLegajo_Legestadocivil_N_SetNull( )
   {
      gxTv_SdtLegajo_Legestadocivil_N = (byte)(0) ;
      SetDirty("Legestadocivil_N");
   }

   public boolean getgxTv_SdtLegajo_Legestadocivil_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legnacioncod_N( )
   {
      return gxTv_SdtLegajo_Legnacioncod_N ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legnacioncod_N");
      gxTv_SdtLegajo_Legnacioncod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legnacioncod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legnacioncod_N = (byte)(0) ;
      SetDirty("Legnacioncod_N");
   }

   public boolean getgxTv_SdtLegajo_Legnacioncod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legpaicod_N( )
   {
      return gxTv_SdtLegajo_Legpaicod_N ;
   }

   public void setgxTv_SdtLegajo_Legpaicod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpaicod_N");
      gxTv_SdtLegajo_Legpaicod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legpaicod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legpaicod_N = (byte)(0) ;
      SetDirty("Legpaicod_N");
   }

   public boolean getgxTv_SdtLegajo_Legpaicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legprovcod_N( )
   {
      return gxTv_SdtLegajo_Legprovcod_N ;
   }

   public void setgxTv_SdtLegajo_Legprovcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legprovcod_N");
      gxTv_SdtLegajo_Legprovcod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legprovcod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legprovcod_N = (byte)(0) ;
      SetDirty("Legprovcod_N");
   }

   public boolean getgxTv_SdtLegajo_Legprovcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legloccod_N( )
   {
      return gxTv_SdtLegajo_Legloccod_N ;
   }

   public void setgxTv_SdtLegajo_Legloccod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legloccod_N");
      gxTv_SdtLegajo_Legloccod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legloccod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legloccod_N = (byte)(0) ;
      SetDirty("Legloccod_N");
   }

   public boolean getgxTv_SdtLegajo_Legloccod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legtelefono_N( )
   {
      return gxTv_SdtLegajo_Legtelefono_N ;
   }

   public void setgxTv_SdtLegajo_Legtelefono_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legtelefono_N");
      gxTv_SdtLegajo_Legtelefono_N = value ;
   }

   public void setgxTv_SdtLegajo_Legtelefono_N_SetNull( )
   {
      gxTv_SdtLegajo_Legtelefono_N = (byte)(0) ;
      SetDirty("Legtelefono_N");
   }

   public boolean getgxTv_SdtLegajo_Legtelefono_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legfecegreso_N( )
   {
      return gxTv_SdtLegajo_Legfecegreso_N ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
      gxTv_SdtLegajo_Legfecegreso_N = value ;
   }

   public void setgxTv_SdtLegajo_Legfecegreso_N_SetNull( )
   {
      gxTv_SdtLegajo_Legfecegreso_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
   }

   public boolean getgxTv_SdtLegajo_Legfecegreso_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legmegcodigo_N( )
   {
      return gxTv_SdtLegajo_Legmegcodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmegcodigo_N");
      gxTv_SdtLegajo_Legmegcodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legmegcodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legmegcodigo_N = (byte)(0) ;
      SetDirty("Legmegcodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legmegcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Megdescrip_N( )
   {
      return gxTv_SdtLegajo_Megdescrip_N ;
   }

   public void setgxTv_SdtLegajo_Megdescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Megdescrip_N");
      gxTv_SdtLegajo_Megdescrip_N = value ;
   }

   public void setgxTv_SdtLegajo_Megdescrip_N_SetNull( )
   {
      gxTv_SdtLegajo_Megdescrip_N = (byte)(0) ;
      SetDirty("Megdescrip_N");
   }

   public boolean getgxTv_SdtLegajo_Megdescrip_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legcatcodigo_N( )
   {
      return gxTv_SdtLegajo_Legcatcodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatcodigo_N");
      gxTv_SdtLegajo_Legcatcodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legcatcodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legcatcodigo_N = (byte)(0) ;
      SetDirty("Legcatcodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legcatcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legcatpuecod_N( )
   {
      return gxTv_SdtLegajo_Legcatpuecod_N ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcatpuecod_N");
      gxTv_SdtLegajo_Legcatpuecod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legcatpuecod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legcatpuecod_N = (byte)(0) ;
      SetDirty("Legcatpuecod_N");
   }

   public boolean getgxTv_SdtLegajo_Legcatpuecod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legseccodigo_N( )
   {
      return gxTv_SdtLegajo_Legseccodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legseccodigo_N");
      gxTv_SdtLegajo_Legseccodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legseccodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legseccodigo_N = (byte)(0) ;
      SetDirty("Legseccodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legseccodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Secdescrip_N( )
   {
      return gxTv_SdtLegajo_Secdescrip_N ;
   }

   public void setgxTv_SdtLegajo_Secdescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Secdescrip_N");
      gxTv_SdtLegajo_Secdescrip_N = value ;
   }

   public void setgxTv_SdtLegajo_Secdescrip_N_SetNull( )
   {
      gxTv_SdtLegajo_Secdescrip_N = (byte)(0) ;
      SetDirty("Secdescrip_N");
   }

   public boolean getgxTv_SdtLegajo_Secdescrip_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Leglpgcodigo_N( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo_N ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglpgcodigo_N");
      gxTv_SdtLegajo_Leglpgcodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Leglpgcodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(0) ;
      SetDirty("Leglpgcodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Leglpgcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Lpgdescri_N( )
   {
      return gxTv_SdtLegajo_Lpgdescri_N ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Lpgdescri_N");
      gxTv_SdtLegajo_Lpgdescri_N = value ;
   }

   public void setgxTv_SdtLegajo_Lpgdescri_N_SetNull( )
   {
      gxTv_SdtLegajo_Lpgdescri_N = (byte)(0) ;
      SetDirty("Lpgdescri_N");
   }

   public boolean getgxTv_SdtLegajo_Lpgdescri_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legbancod_N( )
   {
      return gxTv_SdtLegajo_Legbancod_N ;
   }

   public void setgxTv_SdtLegajo_Legbancod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbancod_N");
      gxTv_SdtLegajo_Legbancod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legbancod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legbancod_N = (byte)(0) ;
      SetDirty("Legbancod_N");
   }

   public boolean getgxTv_SdtLegajo_Legbancod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legbansuc_N( )
   {
      return gxTv_SdtLegajo_Legbansuc_N ;
   }

   public void setgxTv_SdtLegajo_Legbansuc_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbansuc_N");
      gxTv_SdtLegajo_Legbansuc_N = value ;
   }

   public void setgxTv_SdtLegajo_Legbansuc_N_SetNull( )
   {
      gxTv_SdtLegajo_Legbansuc_N = (byte)(0) ;
      SetDirty("Legbansuc_N");
   }

   public boolean getgxTv_SdtLegajo_Legbansuc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legbantipcuen_N( )
   {
      return gxTv_SdtLegajo_Legbantipcuen_N ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legbantipcuen_N");
      gxTv_SdtLegajo_Legbantipcuen_N = value ;
   }

   public void setgxTv_SdtLegajo_Legbantipcuen_N_SetNull( )
   {
      gxTv_SdtLegajo_Legbantipcuen_N = (byte)(0) ;
      SetDirty("Legbantipcuen_N");
   }

   public boolean getgxTv_SdtLegajo_Legbantipcuen_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legsincod_N( )
   {
      return gxTv_SdtLegajo_Legsincod_N ;
   }

   public void setgxTv_SdtLegajo_Legsincod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsincod_N");
      gxTv_SdtLegajo_Legsincod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legsincod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legsincod_N = (byte)(0) ;
      SetDirty("Legsincod_N");
   }

   public boolean getgxTv_SdtLegajo_Legsincod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Sindescrip_N( )
   {
      return gxTv_SdtLegajo_Sindescrip_N ;
   }

   public void setgxTv_SdtLegajo_Sindescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Sindescrip_N");
      gxTv_SdtLegajo_Sindescrip_N = value ;
   }

   public void setgxTv_SdtLegajo_Sindescrip_N_SetNull( )
   {
      gxTv_SdtLegajo_Sindescrip_N = (byte)(0) ;
      SetDirty("Sindescrip_N");
   }

   public boolean getgxTv_SdtLegajo_Sindescrip_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legosocod_N( )
   {
      return gxTv_SdtLegajo_Legosocod_N ;
   }

   public void setgxTv_SdtLegajo_Legosocod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosocod_N");
      gxTv_SdtLegajo_Legosocod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legosocod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legosocod_N = (byte)(0) ;
      SetDirty("Legosocod_N");
   }

   public boolean getgxTv_SdtLegajo_Legosocod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legosoafipcod_N( )
   {
      return gxTv_SdtLegajo_Legosoafipcod_N ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legosoafipcod_N");
      gxTv_SdtLegajo_Legosoafipcod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legosoafipcod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legosoafipcod_N = (byte)(0) ;
      SetDirty("Legosoafipcod_N");
   }

   public boolean getgxTv_SdtLegajo_Legosoafipcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Osodescrip_N( )
   {
      return gxTv_SdtLegajo_Osodescrip_N ;
   }

   public void setgxTv_SdtLegajo_Osodescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osodescrip_N");
      gxTv_SdtLegajo_Osodescrip_N = value ;
   }

   public void setgxTv_SdtLegajo_Osodescrip_N_SetNull( )
   {
      gxTv_SdtLegajo_Osodescrip_N = (byte)(0) ;
      SetDirty("Osodescrip_N");
   }

   public boolean getgxTv_SdtLegajo_Osodescrip_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legactcodigo_N( )
   {
      return gxTv_SdtLegajo_Legactcodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactcodigo_N");
      gxTv_SdtLegajo_Legactcodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legactcodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legactcodigo_N = (byte)(0) ;
      SetDirty("Legactcodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legactcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Mprcod_N( )
   {
      return gxTv_SdtLegajo_Mprcod_N ;
   }

   public void setgxTv_SdtLegajo_Mprcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Mprcod_N");
      gxTv_SdtLegajo_Mprcod_N = value ;
   }

   public void setgxTv_SdtLegajo_Mprcod_N_SetNull( )
   {
      gxTv_SdtLegajo_Mprcod_N = (byte)(0) ;
      SetDirty("Mprcod_N");
   }

   public boolean getgxTv_SdtLegajo_Mprcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legcuentabanc_N( )
   {
      return gxTv_SdtLegajo_Legcuentabanc_N ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcuentabanc_N");
      gxTv_SdtLegajo_Legcuentabanc_N = value ;
   }

   public void setgxTv_SdtLegajo_Legcuentabanc_N_SetNull( )
   {
      gxTv_SdtLegajo_Legcuentabanc_N = (byte)(0) ;
      SetDirty("Legcuentabanc_N");
   }

   public boolean getgxTv_SdtLegajo_Legcuentabanc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Leglicinicio_N( )
   {
      return gxTv_SdtLegajo_Leglicinicio_N ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicinicio_N");
      gxTv_SdtLegajo_Leglicinicio_N = value ;
   }

   public void setgxTv_SdtLegajo_Leglicinicio_N_SetNull( )
   {
      gxTv_SdtLegajo_Leglicinicio_N = (byte)(0) ;
      SetDirty("Leglicinicio_N");
   }

   public boolean getgxTv_SdtLegajo_Leglicinicio_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Leglicfinal_N( )
   {
      return gxTv_SdtLegajo_Leglicfinal_N ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Leglicfinal_N");
      gxTv_SdtLegajo_Leglicfinal_N = value ;
   }

   public void setgxTv_SdtLegajo_Leglicfinal_N_SetNull( )
   {
      gxTv_SdtLegajo_Leglicfinal_N = (byte)(0) ;
      SetDirty("Leglicfinal_N");
   }

   public boolean getgxTv_SdtLegajo_Leglicfinal_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Zoncod_N( )
   {
      return gxTv_SdtLegajo_Zoncod_N ;
   }

   public void setgxTv_SdtLegajo_Zoncod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Zoncod_N");
      gxTv_SdtLegajo_Zoncod_N = value ;
   }

   public void setgxTv_SdtLegajo_Zoncod_N_SetNull( )
   {
      gxTv_SdtLegajo_Zoncod_N = (byte)(0) ;
      SetDirty("Zoncod_N");
   }

   public boolean getgxTv_SdtLegajo_Zoncod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legcbu_N( )
   {
      return gxTv_SdtLegajo_Legcbu_N ;
   }

   public void setgxTv_SdtLegajo_Legcbu_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legcbu_N");
      gxTv_SdtLegajo_Legcbu_N = value ;
   }

   public void setgxTv_SdtLegajo_Legcbu_N_SetNull( )
   {
      gxTv_SdtLegajo_Legcbu_N = (byte)(0) ;
      SetDirty("Legcbu_N");
   }

   public boolean getgxTv_SdtLegajo_Legcbu_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Condicodigo_N( )
   {
      return gxTv_SdtLegajo_Condicodigo_N ;
   }

   public void setgxTv_SdtLegajo_Condicodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Condicodigo_N");
      gxTv_SdtLegajo_Condicodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Condicodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Condicodigo_N = (byte)(0) ;
      SetDirty("Condicodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Condicodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Siniecodigo_N( )
   {
      return gxTv_SdtLegajo_Siniecodigo_N ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Siniecodigo_N");
      gxTv_SdtLegajo_Siniecodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Siniecodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Siniecodigo_N = (byte)(0) ;
      SetDirty("Siniecodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Siniecodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legid_N( )
   {
      return gxTv_SdtLegajo_Legid_N ;
   }

   public void setgxTv_SdtLegajo_Legid_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legid_N");
      gxTv_SdtLegajo_Legid_N = value ;
   }

   public void setgxTv_SdtLegajo_Legid_N_SetNull( )
   {
      gxTv_SdtLegajo_Legid_N = (byte)(0) ;
      SetDirty("Legid_N");
   }

   public boolean getgxTv_SdtLegajo_Legid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legconvecodigo_N( )
   {
      return gxTv_SdtLegajo_Legconvecodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconvecodigo_N");
      gxTv_SdtLegajo_Legconvecodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legconvecodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legconvecodigo_N = (byte)(0) ;
      SetDirty("Legconvecodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legconvecodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Tipemplecod_N( )
   {
      return gxTv_SdtLegajo_Tipemplecod_N ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
      gxTv_SdtLegajo_Tipemplecod_N = value ;
   }

   public void setgxTv_SdtLegajo_Tipemplecod_N_SetNull( )
   {
      gxTv_SdtLegajo_Tipemplecod_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
   }

   public boolean getgxTv_SdtLegajo_Tipemplecod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Osoc3992_N( )
   {
      return gxTv_SdtLegajo_Osoc3992_N ;
   }

   public void setgxTv_SdtLegajo_Osoc3992_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Osoc3992_N");
      gxTv_SdtLegajo_Osoc3992_N = value ;
   }

   public void setgxTv_SdtLegajo_Osoc3992_N_SetNull( )
   {
      gxTv_SdtLegajo_Osoc3992_N = (byte)(0) ;
      SetDirty("Osoc3992_N");
   }

   public boolean getgxTv_SdtLegajo_Osoc3992_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legreligion_N( )
   {
      return gxTv_SdtLegajo_Legreligion_N ;
   }

   public void setgxTv_SdtLegajo_Legreligion_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legreligion_N");
      gxTv_SdtLegajo_Legreligion_N = value ;
   }

   public void setgxTv_SdtLegajo_Legreligion_N_SetNull( )
   {
      gxTv_SdtLegajo_Legreligion_N = (byte)(0) ;
      SetDirty("Legreligion_N");
   }

   public boolean getgxTv_SdtLegajo_Legreligion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legorigen_N( )
   {
      return gxTv_SdtLegajo_Legorigen_N ;
   }

   public void setgxTv_SdtLegajo_Legorigen_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legorigen_N");
      gxTv_SdtLegajo_Legorigen_N = value ;
   }

   public void setgxTv_SdtLegajo_Legorigen_N_SetNull( )
   {
      gxTv_SdtLegajo_Legorigen_N = (byte)(0) ;
      SetDirty("Legorigen_N");
   }

   public boolean getgxTv_SdtLegajo_Legorigen_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legpuescodigo_N( )
   {
      return gxTv_SdtLegajo_Legpuescodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpuescodigo_N");
      gxTv_SdtLegajo_Legpuescodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legpuescodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legpuescodigo_N = (byte)(0) ;
      SetDirty("Legpuescodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legpuescodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legsuccodigo_N( )
   {
      return gxTv_SdtLegajo_Legsuccodigo_N ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsuccodigo_N");
      gxTv_SdtLegajo_Legsuccodigo_N = value ;
   }

   public void setgxTv_SdtLegajo_Legsuccodigo_N_SetNull( )
   {
      gxTv_SdtLegajo_Legsuccodigo_N = (byte)(0) ;
      SetDirty("Legsuccodigo_N");
   }

   public boolean getgxTv_SdtLegajo_Legsuccodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legconveversioncli_N( )
   {
      return gxTv_SdtLegajo_Legconveversioncli_N ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legconveversioncli_N");
      gxTv_SdtLegajo_Legconveversioncli_N = value ;
   }

   public void setgxTv_SdtLegajo_Legconveversioncli_N_SetNull( )
   {
      gxTv_SdtLegajo_Legconveversioncli_N = (byte)(0) ;
      SetDirty("Legconveversioncli_N");
   }

   public boolean getgxTv_SdtLegajo_Legconveversioncli_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legsitrevegreso_N( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso_N ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legsitrevegreso_N");
      gxTv_SdtLegajo_Legsitrevegreso_N = value ;
   }

   public void setgxTv_SdtLegajo_Legsitrevegreso_N_SetNull( )
   {
      gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(0) ;
      SetDirty("Legsitrevegreso_N");
   }

   public boolean getgxTv_SdtLegajo_Legsitrevegreso_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legactclasnro_N( )
   {
      return gxTv_SdtLegajo_Legactclasnro_N ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legactclasnro_N");
      gxTv_SdtLegajo_Legactclasnro_N = value ;
   }

   public void setgxTv_SdtLegajo_Legactclasnro_N_SetNull( )
   {
      gxTv_SdtLegajo_Legactclasnro_N = (byte)(0) ;
      SetDirty("Legactclasnro_N");
   }

   public boolean getgxTv_SdtLegajo_Legactclasnro_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legpueaficod_N( )
   {
      return gxTv_SdtLegajo_Legpueaficod_N ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legpueaficod_N");
      gxTv_SdtLegajo_Legpueaficod_N = value ;
   }

   public void setgxTv_SdtLegajo_Legpueaficod_N_SetNull( )
   {
      gxTv_SdtLegajo_Legpueaficod_N = (byte)(0) ;
      SetDirty("Legpueaficod_N");
   }

   public boolean getgxTv_SdtLegajo_Legpueaficod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Legmigrwarn_N( )
   {
      return gxTv_SdtLegajo_Legmigrwarn_N ;
   }

   public void setgxTv_SdtLegajo_Legmigrwarn_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      SetDirty("Legmigrwarn_N");
      gxTv_SdtLegajo_Legmigrwarn_N = value ;
   }

   public void setgxTv_SdtLegajo_Legmigrwarn_N_SetNull( )
   {
      gxTv_SdtLegajo_Legmigrwarn_N = (byte)(0) ;
      SetDirty("Legmigrwarn_N");
   }

   public boolean getgxTv_SdtLegajo_Legmigrwarn_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.legajo_bc obj;
      obj = new web.legajo_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_N = (byte)(1) ;
      gxTv_SdtLegajo_Empnom = "" ;
      gxTv_SdtLegajo_Legapellido = "" ;
      gxTv_SdtLegajo_Legnombre = "" ;
      gxTv_SdtLegajo_Legfoto = "" ;
      gxTv_SdtLegajo_Legfotonom = "" ;
      gxTv_SdtLegajo_Legfotoext = "" ;
      gxTv_SdtLegajo_Legnumdoc = "" ;
      gxTv_SdtLegajo_Legfecnac = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legnacionalidad = "" ;
      gxTv_SdtLegajo_Legdomici = "" ;
      gxTv_SdtLegajo_Legemail = "" ;
      gxTv_SdtLegajo_Legcodpos = "" ;
      gxTv_SdtLegajo_Legpainom = "" ;
      gxTv_SdtLegajo_Legprovnom = "" ;
      gxTv_SdtLegajo_Leglocnom = "" ;
      gxTv_SdtLegajo_Legtelefono = "" ;
      gxTv_SdtLegajo_Legfecingreso = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legfecegreso = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legmegcodigo = "" ;
      gxTv_SdtLegajo_Megdescrip = "" ;
      gxTv_SdtLegajo_Legcatcodigo = "" ;
      gxTv_SdtLegajo_Legseccodigo = "" ;
      gxTv_SdtLegajo_Secdescrip = "" ;
      gxTv_SdtLegajo_Leglpgcodigo = "" ;
      gxTv_SdtLegajo_Lpgdescri = "" ;
      gxTv_SdtLegajo_Legbasico = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legbancod = "" ;
      gxTv_SdtLegajo_Legbandes = "" ;
      gxTv_SdtLegajo_Legbansuc = "" ;
      gxTv_SdtLegajo_Legbantipcuen = "" ;
      gxTv_SdtLegajo_Legsincod = "" ;
      gxTv_SdtLegajo_Sindescrip = "" ;
      gxTv_SdtLegajo_Legosocod = "" ;
      gxTv_SdtLegajo_Legosodes = "" ;
      gxTv_SdtLegajo_Legosoafipcod = "" ;
      gxTv_SdtLegajo_Osodescrip = "" ;
      gxTv_SdtLegajo_Legactcodigo = "" ;
      gxTv_SdtLegajo_Legactdescri = "" ;
      gxTv_SdtLegajo_Mprcod = "" ;
      gxTv_SdtLegajo_Mprdescrip = "" ;
      gxTv_SdtLegajo_Legfecultmod = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legcuentabanc = "" ;
      gxTv_SdtLegajo_Leglicinicio = GXutil.nullDate() ;
      gxTv_SdtLegajo_Leglicfinal = GXutil.nullDate() ;
      gxTv_SdtLegajo_Zoncod = "" ;
      gxTv_SdtLegajo_Zondescrip = "" ;
      gxTv_SdtLegajo_Zonporcreduc = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legcbu = "" ;
      gxTv_SdtLegajo_Condidescri = "" ;
      gxTv_SdtLegajo_Siniecodigo = "" ;
      gxTv_SdtLegajo_Siniedescri = "" ;
      gxTv_SdtLegajo_Legsueldofuera = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legid = "" ;
      gxTv_SdtLegajo_Legconvecodigo = "" ;
      gxTv_SdtLegajo_Legidnomape = "" ;
      gxTv_SdtLegajo_Tipemplecod = "" ;
      gxTv_SdtLegajo_Osoc3992 = "" ;
      gxTv_SdtLegajo_Legobs = "" ;
      gxTv_SdtLegajo_Legnomape = "" ;
      gxTv_SdtLegajo_Legfecimportacion = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLegajo_Legcontinua = "" ;
      gxTv_SdtLegajo_Leghorasdia = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Leghorassem = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legreligion = "" ;
      gxTv_SdtLegajo_Legorigen = "" ;
      gxTv_SdtLegajo_Legpuescodigo = "" ;
      gxTv_SdtLegajo_Legsuccodigo = "" ;
      gxTv_SdtLegajo_Legfecpreaviso = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legpromdias = "" ;
      gxTv_SdtLegajo_Legtitulo = "" ;
      gxTv_SdtLegajo_Legpueaficod = "" ;
      gxTv_SdtLegajo_Legmigrwarn = "" ;
      gxTv_SdtLegajo_Legmodtra = "" ;
      gxTv_SdtLegajo_Legtipotarifa = "" ;
      gxTv_SdtLegajo_Mode = "" ;
      gxTv_SdtLegajo_Empnom_Z = "" ;
      gxTv_SdtLegajo_Legapellido_Z = "" ;
      gxTv_SdtLegajo_Legnombre_Z = "" ;
      gxTv_SdtLegajo_Legfotonom_Z = "" ;
      gxTv_SdtLegajo_Legfotoext_Z = "" ;
      gxTv_SdtLegajo_Legnumdoc_Z = "" ;
      gxTv_SdtLegajo_Legfecnac_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legnacionalidad_Z = "" ;
      gxTv_SdtLegajo_Legdomici_Z = "" ;
      gxTv_SdtLegajo_Legemail_Z = "" ;
      gxTv_SdtLegajo_Legcodpos_Z = "" ;
      gxTv_SdtLegajo_Legpainom_Z = "" ;
      gxTv_SdtLegajo_Legprovnom_Z = "" ;
      gxTv_SdtLegajo_Leglocnom_Z = "" ;
      gxTv_SdtLegajo_Legtelefono_Z = "" ;
      gxTv_SdtLegajo_Legfecingreso_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legfecegreso_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legmegcodigo_Z = "" ;
      gxTv_SdtLegajo_Megdescrip_Z = "" ;
      gxTv_SdtLegajo_Legcatcodigo_Z = "" ;
      gxTv_SdtLegajo_Legseccodigo_Z = "" ;
      gxTv_SdtLegajo_Secdescrip_Z = "" ;
      gxTv_SdtLegajo_Leglpgcodigo_Z = "" ;
      gxTv_SdtLegajo_Lpgdescri_Z = "" ;
      gxTv_SdtLegajo_Legbasico_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legbancod_Z = "" ;
      gxTv_SdtLegajo_Legbandes_Z = "" ;
      gxTv_SdtLegajo_Legbansuc_Z = "" ;
      gxTv_SdtLegajo_Legbantipcuen_Z = "" ;
      gxTv_SdtLegajo_Legsincod_Z = "" ;
      gxTv_SdtLegajo_Sindescrip_Z = "" ;
      gxTv_SdtLegajo_Legosocod_Z = "" ;
      gxTv_SdtLegajo_Legosodes_Z = "" ;
      gxTv_SdtLegajo_Legosoafipcod_Z = "" ;
      gxTv_SdtLegajo_Osodescrip_Z = "" ;
      gxTv_SdtLegajo_Legactcodigo_Z = "" ;
      gxTv_SdtLegajo_Legactdescri_Z = "" ;
      gxTv_SdtLegajo_Mprcod_Z = "" ;
      gxTv_SdtLegajo_Mprdescrip_Z = "" ;
      gxTv_SdtLegajo_Legfecultmod_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legcuentabanc_Z = "" ;
      gxTv_SdtLegajo_Leglicinicio_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Leglicfinal_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Zoncod_Z = "" ;
      gxTv_SdtLegajo_Zondescrip_Z = "" ;
      gxTv_SdtLegajo_Zonporcreduc_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legcbu_Z = "" ;
      gxTv_SdtLegajo_Condidescri_Z = "" ;
      gxTv_SdtLegajo_Siniecodigo_Z = "" ;
      gxTv_SdtLegajo_Siniedescri_Z = "" ;
      gxTv_SdtLegajo_Legsueldofuera_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legid_Z = "" ;
      gxTv_SdtLegajo_Legconvecodigo_Z = "" ;
      gxTv_SdtLegajo_Legidnomape_Z = "" ;
      gxTv_SdtLegajo_Tipemplecod_Z = "" ;
      gxTv_SdtLegajo_Osoc3992_Z = "" ;
      gxTv_SdtLegajo_Legnomape_Z = "" ;
      gxTv_SdtLegajo_Legfecimportacion_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLegajo_Legcontinua_Z = "" ;
      gxTv_SdtLegajo_Leghorasdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Leghorassem_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Legreligion_Z = "" ;
      gxTv_SdtLegajo_Legorigen_Z = "" ;
      gxTv_SdtLegajo_Legpuescodigo_Z = "" ;
      gxTv_SdtLegajo_Legsuccodigo_Z = "" ;
      gxTv_SdtLegajo_Legfecpreaviso_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Legpromdias_Z = "" ;
      gxTv_SdtLegajo_Legtitulo_Z = "" ;
      gxTv_SdtLegajo_Legpueaficod_Z = "" ;
      gxTv_SdtLegajo_Legmodtra_Z = "" ;
      gxTv_SdtLegajo_Legtipotarifa_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_N ;
   }

   public web.SdtLegajo Clone( )
   {
      web.SdtLegajo sdt;
      web.legajo_bc obj;
      sdt = (web.SdtLegajo)(clone()) ;
      obj = (web.legajo_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLegajo struct )
   {
      setgxTv_SdtLegajo_Clicod(struct.getClicod());
      setgxTv_SdtLegajo_Empcod(struct.getEmpcod());
      setgxTv_SdtLegajo_Empnom(struct.getEmpnom());
      setgxTv_SdtLegajo_Legnumero(struct.getLegnumero());
      setgxTv_SdtLegajo_Legapellido(struct.getLegapellido());
      setgxTv_SdtLegajo_Legnombre(struct.getLegnombre());
      setgxTv_SdtLegajo_Legfoto(struct.getLegfoto());
      GXBCLevelCollection<web.SdtLegajo_Salario> gxTv_SdtLegajo_Salario_aux = new GXBCLevelCollection<web.SdtLegajo_Salario>(web.SdtLegajo_Salario.class, "Legajo.Salario", "PayDay", remoteHandle);
      Vector<web.StructSdtLegajo_Salario> gxTv_SdtLegajo_Salario_aux1 = struct.getSalario();
      if (gxTv_SdtLegajo_Salario_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtLegajo_Salario_aux1.size(); i++)
         {
            gxTv_SdtLegajo_Salario_aux.add(new web.SdtLegajo_Salario(remoteHandle, gxTv_SdtLegajo_Salario_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtLegajo_Salario(gxTv_SdtLegajo_Salario_aux);
      GXBCLevelCollection<web.SdtLegajo_Familia> gxTv_SdtLegajo_Familia_aux = new GXBCLevelCollection<web.SdtLegajo_Familia>(web.SdtLegajo_Familia.class, "Legajo.Familia", "PayDay", remoteHandle);
      Vector<web.StructSdtLegajo_Familia> gxTv_SdtLegajo_Familia_aux1 = struct.getFamilia();
      if (gxTv_SdtLegajo_Familia_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtLegajo_Familia_aux1.size(); i++)
         {
            gxTv_SdtLegajo_Familia_aux.add(new web.SdtLegajo_Familia(remoteHandle, gxTv_SdtLegajo_Familia_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtLegajo_Familia(gxTv_SdtLegajo_Familia_aux);
      setgxTv_SdtLegajo_Legfotonom(struct.getLegfotonom());
      setgxTv_SdtLegajo_Legfotoext(struct.getLegfotoext());
      setgxTv_SdtLegajo_Legtipdoc(struct.getLegtipdoc());
      setgxTv_SdtLegajo_Legnumdoc(struct.getLegnumdoc());
      setgxTv_SdtLegajo_Legfecnac(struct.getLegfecnac());
      setgxTv_SdtLegajo_Legsexo(struct.getLegsexo());
      setgxTv_SdtLegajo_Legestadocivil(struct.getLegestadocivil());
      setgxTv_SdtLegajo_Legnacioncod(struct.getLegnacioncod());
      setgxTv_SdtLegajo_Legnacionalidad(struct.getLegnacionalidad());
      setgxTv_SdtLegajo_Legcuil(struct.getLegcuil());
      setgxTv_SdtLegajo_Legdiscapacidad(struct.getLegdiscapacidad());
      setgxTv_SdtLegajo_Legdomici(struct.getLegdomici());
      setgxTv_SdtLegajo_Legemail(struct.getLegemail());
      setgxTv_SdtLegajo_Legcodpos(struct.getLegcodpos());
      setgxTv_SdtLegajo_Legpaicod(struct.getLegpaicod());
      setgxTv_SdtLegajo_Legpainom(struct.getLegpainom());
      setgxTv_SdtLegajo_Legprovcod(struct.getLegprovcod());
      setgxTv_SdtLegajo_Legprovnom(struct.getLegprovnom());
      setgxTv_SdtLegajo_Legloccod(struct.getLegloccod());
      setgxTv_SdtLegajo_Leglocnom(struct.getLeglocnom());
      setgxTv_SdtLegajo_Legtelefono(struct.getLegtelefono());
      setgxTv_SdtLegajo_Legfecingreso(struct.getLegfecingreso());
      setgxTv_SdtLegajo_Legfecegreso(struct.getLegfecegreso());
      setgxTv_SdtLegajo_Legmegcodigo(struct.getLegmegcodigo());
      setgxTv_SdtLegajo_Megdescrip(struct.getMegdescrip());
      setgxTv_SdtLegajo_Legcatcodigo(struct.getLegcatcodigo());
      setgxTv_SdtLegajo_Legcatpuecod(struct.getLegcatpuecod());
      setgxTv_SdtLegajo_Legseccodigo(struct.getLegseccodigo());
      setgxTv_SdtLegajo_Secdescrip(struct.getSecdescrip());
      setgxTv_SdtLegajo_Leglpgcodigo(struct.getLeglpgcodigo());
      setgxTv_SdtLegajo_Lpgdescri(struct.getLpgdescri());
      setgxTv_SdtLegajo_Legclase(struct.getLegclase());
      setgxTv_SdtLegajo_Legbasico(struct.getLegbasico());
      setgxTv_SdtLegajo_Legformapago(struct.getLegformapago());
      setgxTv_SdtLegajo_Legbancod(struct.getLegbancod());
      setgxTv_SdtLegajo_Legbandes(struct.getLegbandes());
      setgxTv_SdtLegajo_Legbansuc(struct.getLegbansuc());
      setgxTv_SdtLegajo_Legbantipcuen(struct.getLegbantipcuen());
      setgxTv_SdtLegajo_Legsincod(struct.getLegsincod());
      setgxTv_SdtLegajo_Sindescrip(struct.getSindescrip());
      setgxTv_SdtLegajo_Legosocod(struct.getLegosocod());
      setgxTv_SdtLegajo_Legosodes(struct.getLegosodes());
      setgxTv_SdtLegajo_Legosoafipcod(struct.getLegosoafipcod());
      setgxTv_SdtLegajo_Osodescrip(struct.getOsodescrip());
      setgxTv_SdtLegajo_Legactcodigo(struct.getLegactcodigo());
      setgxTv_SdtLegajo_Legactdescri(struct.getLegactdescri());
      setgxTv_SdtLegajo_Mprcod(struct.getMprcod());
      setgxTv_SdtLegajo_Mprdescrip(struct.getMprdescrip());
      setgxTv_SdtLegajo_Legfecultmod(struct.getLegfecultmod());
      setgxTv_SdtLegajo_Legcuentabanc(struct.getLegcuentabanc());
      setgxTv_SdtLegajo_Leglicinicio(struct.getLeglicinicio());
      setgxTv_SdtLegajo_Leglicfinal(struct.getLeglicfinal());
      setgxTv_SdtLegajo_Zoncod(struct.getZoncod());
      setgxTv_SdtLegajo_Zondescrip(struct.getZondescrip());
      setgxTv_SdtLegajo_Zonporcreduc(struct.getZonporcreduc());
      setgxTv_SdtLegajo_Legcbu(struct.getLegcbu());
      setgxTv_SdtLegajo_Legconvenio(struct.getLegconvenio());
      setgxTv_SdtLegajo_Legscvo(struct.getLegscvo());
      setgxTv_SdtLegajo_Condicodigo(struct.getCondicodigo());
      setgxTv_SdtLegajo_Condidescri(struct.getCondidescri());
      setgxTv_SdtLegajo_Siniecodigo(struct.getSiniecodigo());
      setgxTv_SdtLegajo_Siniedescri(struct.getSiniedescri());
      setgxTv_SdtLegajo_Legactivo(struct.getLegactivo());
      setgxTv_SdtLegajo_Legsueldofuera(struct.getLegsueldofuera());
      setgxTv_SdtLegajo_Legid(struct.getLegid());
      setgxTv_SdtLegajo_Legconvecodigo(struct.getLegconvecodigo());
      setgxTv_SdtLegajo_Legidnomape(struct.getLegidnomape());
      setgxTv_SdtLegajo_Tipemplecod(struct.getTipemplecod());
      setgxTv_SdtLegajo_Osoc3992(struct.getOsoc3992());
      setgxTv_SdtLegajo_Legobs(struct.getLegobs());
      setgxTv_SdtLegajo_Legnomape(struct.getLegnomape());
      setgxTv_SdtLegajo_Legfecimportacion(struct.getLegfecimportacion());
      setgxTv_SdtLegajo_Legagenreten(struct.getLegagenreten());
      setgxTv_SdtLegajo_Legcontinua(struct.getLegcontinua());
      setgxTv_SdtLegajo_Legrecalcliq(struct.getLegrecalcliq());
      setgxTv_SdtLegajo_Legjubilado(struct.getLegjubilado());
      setgxTv_SdtLegajo_Leghorasdia(struct.getLeghorasdia());
      setgxTv_SdtLegajo_Leghorassem(struct.getLeghorassem());
      setgxTv_SdtLegajo_Legreligion(struct.getLegreligion());
      setgxTv_SdtLegajo_Legorigen(struct.getLegorigen());
      setgxTv_SdtLegajo_Legpuescodigo(struct.getLegpuescodigo());
      setgxTv_SdtLegajo_Legsuccodigo(struct.getLegsuccodigo());
      setgxTv_SdtLegajo_Legtrablun(struct.getLegtrablun());
      setgxTv_SdtLegajo_Legtrabmar(struct.getLegtrabmar());
      setgxTv_SdtLegajo_Legtrabmie(struct.getLegtrabmie());
      setgxTv_SdtLegajo_Legtrabjue(struct.getLegtrabjue());
      setgxTv_SdtLegajo_Legtrabvie(struct.getLegtrabvie());
      setgxTv_SdtLegajo_Legtrabsa(struct.getLegtrabsa());
      setgxTv_SdtLegajo_Legtrabdo(struct.getLegtrabdo());
      GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> gxTv_SdtLegajo_Tipos_de_trabajo_aux = new GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo>(web.SdtLegajo_tipos_de_trabajo.class, "Legajo.tipos_de_trabajo", "PayDay", remoteHandle);
      Vector<web.StructSdtLegajo_tipos_de_trabajo> gxTv_SdtLegajo_Tipos_de_trabajo_aux1 = struct.getTipos_de_trabajo();
      if (gxTv_SdtLegajo_Tipos_de_trabajo_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtLegajo_Tipos_de_trabajo_aux1.size(); i++)
         {
            gxTv_SdtLegajo_Tipos_de_trabajo_aux.add(new web.SdtLegajo_tipos_de_trabajo(remoteHandle, gxTv_SdtLegajo_Tipos_de_trabajo_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtLegajo_Tipos_de_trabajo(gxTv_SdtLegajo_Tipos_de_trabajo_aux);
      setgxTv_SdtLegajo_Legvacpend(struct.getLegvacpend());
      setgxTv_SdtLegajo_Legfecpreaviso(struct.getLegfecpreaviso());
      setgxTv_SdtLegajo_Legconveversioncli(struct.getLegconveversioncli());
      setgxTv_SdtLegajo_Legsitrevegreso(struct.getLegsitrevegreso());
      setgxTv_SdtLegajo_Legpromdias(struct.getLegpromdias());
      setgxTv_SdtLegajo_Legtitulo(struct.getLegtitulo());
      setgxTv_SdtLegajo_Legestado(struct.getLegestado());
      setgxTv_SdtLegajo_Legactclasnro(struct.getLegactclasnro());
      setgxTv_SdtLegajo_Legpueaficod(struct.getLegpueaficod());
      setgxTv_SdtLegajo_Legmigrwarn(struct.getLegmigrwarn());
      setgxTv_SdtLegajo_Legincompleto(struct.getLegincompleto());
      setgxTv_SdtLegajo_Legliqapo(struct.getLegliqapo());
      GXBCLevelCollection<web.SdtLegajo_Propiedades> gxTv_SdtLegajo_Propiedades_aux = new GXBCLevelCollection<web.SdtLegajo_Propiedades>(web.SdtLegajo_Propiedades.class, "Legajo.Propiedades", "PayDay", remoteHandle);
      Vector<web.StructSdtLegajo_Propiedades> gxTv_SdtLegajo_Propiedades_aux1 = struct.getPropiedades();
      if (gxTv_SdtLegajo_Propiedades_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtLegajo_Propiedades_aux1.size(); i++)
         {
            gxTv_SdtLegajo_Propiedades_aux.add(new web.SdtLegajo_Propiedades(remoteHandle, gxTv_SdtLegajo_Propiedades_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtLegajo_Propiedades(gxTv_SdtLegajo_Propiedades_aux);
      setgxTv_SdtLegajo_Legmodtra(struct.getLegmodtra());
      setgxTv_SdtLegajo_Legtipotarifa(struct.getLegtipotarifa());
      setgxTv_SdtLegajo_Mode(struct.getMode());
      setgxTv_SdtLegajo_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLegajo_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLegajo_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtLegajo_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtLegajo_Legapellido_Z(struct.getLegapellido_Z());
      setgxTv_SdtLegajo_Legnombre_Z(struct.getLegnombre_Z());
      setgxTv_SdtLegajo_Legfotonom_Z(struct.getLegfotonom_Z());
      setgxTv_SdtLegajo_Legfotoext_Z(struct.getLegfotoext_Z());
      setgxTv_SdtLegajo_Legtipdoc_Z(struct.getLegtipdoc_Z());
      setgxTv_SdtLegajo_Legnumdoc_Z(struct.getLegnumdoc_Z());
      setgxTv_SdtLegajo_Legfecnac_Z(struct.getLegfecnac_Z());
      setgxTv_SdtLegajo_Legsexo_Z(struct.getLegsexo_Z());
      setgxTv_SdtLegajo_Legestadocivil_Z(struct.getLegestadocivil_Z());
      setgxTv_SdtLegajo_Legnacioncod_Z(struct.getLegnacioncod_Z());
      setgxTv_SdtLegajo_Legnacionalidad_Z(struct.getLegnacionalidad_Z());
      setgxTv_SdtLegajo_Legcuil_Z(struct.getLegcuil_Z());
      setgxTv_SdtLegajo_Legdiscapacidad_Z(struct.getLegdiscapacidad_Z());
      setgxTv_SdtLegajo_Legdomici_Z(struct.getLegdomici_Z());
      setgxTv_SdtLegajo_Legemail_Z(struct.getLegemail_Z());
      setgxTv_SdtLegajo_Legcodpos_Z(struct.getLegcodpos_Z());
      setgxTv_SdtLegajo_Legpaicod_Z(struct.getLegpaicod_Z());
      setgxTv_SdtLegajo_Legpainom_Z(struct.getLegpainom_Z());
      setgxTv_SdtLegajo_Legprovcod_Z(struct.getLegprovcod_Z());
      setgxTv_SdtLegajo_Legprovnom_Z(struct.getLegprovnom_Z());
      setgxTv_SdtLegajo_Legloccod_Z(struct.getLegloccod_Z());
      setgxTv_SdtLegajo_Leglocnom_Z(struct.getLeglocnom_Z());
      setgxTv_SdtLegajo_Legtelefono_Z(struct.getLegtelefono_Z());
      setgxTv_SdtLegajo_Legfecingreso_Z(struct.getLegfecingreso_Z());
      setgxTv_SdtLegajo_Legfecegreso_Z(struct.getLegfecegreso_Z());
      setgxTv_SdtLegajo_Legmegcodigo_Z(struct.getLegmegcodigo_Z());
      setgxTv_SdtLegajo_Megdescrip_Z(struct.getMegdescrip_Z());
      setgxTv_SdtLegajo_Legcatcodigo_Z(struct.getLegcatcodigo_Z());
      setgxTv_SdtLegajo_Legcatpuecod_Z(struct.getLegcatpuecod_Z());
      setgxTv_SdtLegajo_Legseccodigo_Z(struct.getLegseccodigo_Z());
      setgxTv_SdtLegajo_Secdescrip_Z(struct.getSecdescrip_Z());
      setgxTv_SdtLegajo_Leglpgcodigo_Z(struct.getLeglpgcodigo_Z());
      setgxTv_SdtLegajo_Lpgdescri_Z(struct.getLpgdescri_Z());
      setgxTv_SdtLegajo_Legclase_Z(struct.getLegclase_Z());
      setgxTv_SdtLegajo_Legbasico_Z(struct.getLegbasico_Z());
      setgxTv_SdtLegajo_Legformapago_Z(struct.getLegformapago_Z());
      setgxTv_SdtLegajo_Legbancod_Z(struct.getLegbancod_Z());
      setgxTv_SdtLegajo_Legbandes_Z(struct.getLegbandes_Z());
      setgxTv_SdtLegajo_Legbansuc_Z(struct.getLegbansuc_Z());
      setgxTv_SdtLegajo_Legbantipcuen_Z(struct.getLegbantipcuen_Z());
      setgxTv_SdtLegajo_Legsincod_Z(struct.getLegsincod_Z());
      setgxTv_SdtLegajo_Sindescrip_Z(struct.getSindescrip_Z());
      setgxTv_SdtLegajo_Legosocod_Z(struct.getLegosocod_Z());
      setgxTv_SdtLegajo_Legosodes_Z(struct.getLegosodes_Z());
      setgxTv_SdtLegajo_Legosoafipcod_Z(struct.getLegosoafipcod_Z());
      setgxTv_SdtLegajo_Osodescrip_Z(struct.getOsodescrip_Z());
      setgxTv_SdtLegajo_Legactcodigo_Z(struct.getLegactcodigo_Z());
      setgxTv_SdtLegajo_Legactdescri_Z(struct.getLegactdescri_Z());
      setgxTv_SdtLegajo_Mprcod_Z(struct.getMprcod_Z());
      setgxTv_SdtLegajo_Mprdescrip_Z(struct.getMprdescrip_Z());
      setgxTv_SdtLegajo_Legfecultmod_Z(struct.getLegfecultmod_Z());
      setgxTv_SdtLegajo_Legcuentabanc_Z(struct.getLegcuentabanc_Z());
      setgxTv_SdtLegajo_Leglicinicio_Z(struct.getLeglicinicio_Z());
      setgxTv_SdtLegajo_Leglicfinal_Z(struct.getLeglicfinal_Z());
      setgxTv_SdtLegajo_Zoncod_Z(struct.getZoncod_Z());
      setgxTv_SdtLegajo_Zondescrip_Z(struct.getZondescrip_Z());
      setgxTv_SdtLegajo_Zonporcreduc_Z(struct.getZonporcreduc_Z());
      setgxTv_SdtLegajo_Legcbu_Z(struct.getLegcbu_Z());
      setgxTv_SdtLegajo_Legconvenio_Z(struct.getLegconvenio_Z());
      setgxTv_SdtLegajo_Legscvo_Z(struct.getLegscvo_Z());
      setgxTv_SdtLegajo_Condicodigo_Z(struct.getCondicodigo_Z());
      setgxTv_SdtLegajo_Condidescri_Z(struct.getCondidescri_Z());
      setgxTv_SdtLegajo_Siniecodigo_Z(struct.getSiniecodigo_Z());
      setgxTv_SdtLegajo_Siniedescri_Z(struct.getSiniedescri_Z());
      setgxTv_SdtLegajo_Legactivo_Z(struct.getLegactivo_Z());
      setgxTv_SdtLegajo_Legsueldofuera_Z(struct.getLegsueldofuera_Z());
      setgxTv_SdtLegajo_Legid_Z(struct.getLegid_Z());
      setgxTv_SdtLegajo_Legconvecodigo_Z(struct.getLegconvecodigo_Z());
      setgxTv_SdtLegajo_Legidnomape_Z(struct.getLegidnomape_Z());
      setgxTv_SdtLegajo_Tipemplecod_Z(struct.getTipemplecod_Z());
      setgxTv_SdtLegajo_Osoc3992_Z(struct.getOsoc3992_Z());
      setgxTv_SdtLegajo_Legnomape_Z(struct.getLegnomape_Z());
      setgxTv_SdtLegajo_Legfecimportacion_Z(struct.getLegfecimportacion_Z());
      setgxTv_SdtLegajo_Legagenreten_Z(struct.getLegagenreten_Z());
      setgxTv_SdtLegajo_Legcontinua_Z(struct.getLegcontinua_Z());
      setgxTv_SdtLegajo_Legrecalcliq_Z(struct.getLegrecalcliq_Z());
      setgxTv_SdtLegajo_Legjubilado_Z(struct.getLegjubilado_Z());
      setgxTv_SdtLegajo_Leghorasdia_Z(struct.getLeghorasdia_Z());
      setgxTv_SdtLegajo_Leghorassem_Z(struct.getLeghorassem_Z());
      setgxTv_SdtLegajo_Legreligion_Z(struct.getLegreligion_Z());
      setgxTv_SdtLegajo_Legorigen_Z(struct.getLegorigen_Z());
      setgxTv_SdtLegajo_Legpuescodigo_Z(struct.getLegpuescodigo_Z());
      setgxTv_SdtLegajo_Legsuccodigo_Z(struct.getLegsuccodigo_Z());
      setgxTv_SdtLegajo_Legtrablun_Z(struct.getLegtrablun_Z());
      setgxTv_SdtLegajo_Legtrabmar_Z(struct.getLegtrabmar_Z());
      setgxTv_SdtLegajo_Legtrabmie_Z(struct.getLegtrabmie_Z());
      setgxTv_SdtLegajo_Legtrabjue_Z(struct.getLegtrabjue_Z());
      setgxTv_SdtLegajo_Legtrabvie_Z(struct.getLegtrabvie_Z());
      setgxTv_SdtLegajo_Legtrabsa_Z(struct.getLegtrabsa_Z());
      setgxTv_SdtLegajo_Legtrabdo_Z(struct.getLegtrabdo_Z());
      setgxTv_SdtLegajo_Legvacpend_Z(struct.getLegvacpend_Z());
      setgxTv_SdtLegajo_Legfecpreaviso_Z(struct.getLegfecpreaviso_Z());
      setgxTv_SdtLegajo_Legconveversioncli_Z(struct.getLegconveversioncli_Z());
      setgxTv_SdtLegajo_Legsitrevegreso_Z(struct.getLegsitrevegreso_Z());
      setgxTv_SdtLegajo_Legpromdias_Z(struct.getLegpromdias_Z());
      setgxTv_SdtLegajo_Legtitulo_Z(struct.getLegtitulo_Z());
      setgxTv_SdtLegajo_Legestado_Z(struct.getLegestado_Z());
      setgxTv_SdtLegajo_Legactclasnro_Z(struct.getLegactclasnro_Z());
      setgxTv_SdtLegajo_Legpueaficod_Z(struct.getLegpueaficod_Z());
      setgxTv_SdtLegajo_Legincompleto_Z(struct.getLegincompleto_Z());
      setgxTv_SdtLegajo_Legliqapo_Z(struct.getLegliqapo_Z());
      setgxTv_SdtLegajo_Legmodtra_Z(struct.getLegmodtra_Z());
      setgxTv_SdtLegajo_Legtipotarifa_Z(struct.getLegtipotarifa_Z());
      setgxTv_SdtLegajo_Legfoto_N(struct.getLegfoto_N());
      setgxTv_SdtLegajo_Legsexo_N(struct.getLegsexo_N());
      setgxTv_SdtLegajo_Legestadocivil_N(struct.getLegestadocivil_N());
      setgxTv_SdtLegajo_Legnacioncod_N(struct.getLegnacioncod_N());
      setgxTv_SdtLegajo_Legpaicod_N(struct.getLegpaicod_N());
      setgxTv_SdtLegajo_Legprovcod_N(struct.getLegprovcod_N());
      setgxTv_SdtLegajo_Legloccod_N(struct.getLegloccod_N());
      setgxTv_SdtLegajo_Legtelefono_N(struct.getLegtelefono_N());
      setgxTv_SdtLegajo_Legfecegreso_N(struct.getLegfecegreso_N());
      setgxTv_SdtLegajo_Legmegcodigo_N(struct.getLegmegcodigo_N());
      setgxTv_SdtLegajo_Megdescrip_N(struct.getMegdescrip_N());
      setgxTv_SdtLegajo_Legcatcodigo_N(struct.getLegcatcodigo_N());
      setgxTv_SdtLegajo_Legcatpuecod_N(struct.getLegcatpuecod_N());
      setgxTv_SdtLegajo_Legseccodigo_N(struct.getLegseccodigo_N());
      setgxTv_SdtLegajo_Secdescrip_N(struct.getSecdescrip_N());
      setgxTv_SdtLegajo_Leglpgcodigo_N(struct.getLeglpgcodigo_N());
      setgxTv_SdtLegajo_Lpgdescri_N(struct.getLpgdescri_N());
      setgxTv_SdtLegajo_Legbancod_N(struct.getLegbancod_N());
      setgxTv_SdtLegajo_Legbansuc_N(struct.getLegbansuc_N());
      setgxTv_SdtLegajo_Legbantipcuen_N(struct.getLegbantipcuen_N());
      setgxTv_SdtLegajo_Legsincod_N(struct.getLegsincod_N());
      setgxTv_SdtLegajo_Sindescrip_N(struct.getSindescrip_N());
      setgxTv_SdtLegajo_Legosocod_N(struct.getLegosocod_N());
      setgxTv_SdtLegajo_Legosoafipcod_N(struct.getLegosoafipcod_N());
      setgxTv_SdtLegajo_Osodescrip_N(struct.getOsodescrip_N());
      setgxTv_SdtLegajo_Legactcodigo_N(struct.getLegactcodigo_N());
      setgxTv_SdtLegajo_Mprcod_N(struct.getMprcod_N());
      setgxTv_SdtLegajo_Legcuentabanc_N(struct.getLegcuentabanc_N());
      setgxTv_SdtLegajo_Leglicinicio_N(struct.getLeglicinicio_N());
      setgxTv_SdtLegajo_Leglicfinal_N(struct.getLeglicfinal_N());
      setgxTv_SdtLegajo_Zoncod_N(struct.getZoncod_N());
      setgxTv_SdtLegajo_Legcbu_N(struct.getLegcbu_N());
      setgxTv_SdtLegajo_Condicodigo_N(struct.getCondicodigo_N());
      setgxTv_SdtLegajo_Siniecodigo_N(struct.getSiniecodigo_N());
      setgxTv_SdtLegajo_Legid_N(struct.getLegid_N());
      setgxTv_SdtLegajo_Legconvecodigo_N(struct.getLegconvecodigo_N());
      setgxTv_SdtLegajo_Tipemplecod_N(struct.getTipemplecod_N());
      setgxTv_SdtLegajo_Osoc3992_N(struct.getOsoc3992_N());
      setgxTv_SdtLegajo_Legreligion_N(struct.getLegreligion_N());
      setgxTv_SdtLegajo_Legorigen_N(struct.getLegorigen_N());
      setgxTv_SdtLegajo_Legpuescodigo_N(struct.getLegpuescodigo_N());
      setgxTv_SdtLegajo_Legsuccodigo_N(struct.getLegsuccodigo_N());
      setgxTv_SdtLegajo_Legconveversioncli_N(struct.getLegconveversioncli_N());
      setgxTv_SdtLegajo_Legsitrevegreso_N(struct.getLegsitrevegreso_N());
      setgxTv_SdtLegajo_Legactclasnro_N(struct.getLegactclasnro_N());
      setgxTv_SdtLegajo_Legpueaficod_N(struct.getLegpueaficod_N());
      setgxTv_SdtLegajo_Legmigrwarn_N(struct.getLegmigrwarn_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo getStruct( )
   {
      web.StructSdtLegajo struct = new web.StructSdtLegajo ();
      struct.setClicod(getgxTv_SdtLegajo_Clicod());
      struct.setEmpcod(getgxTv_SdtLegajo_Empcod());
      struct.setEmpnom(getgxTv_SdtLegajo_Empnom());
      struct.setLegnumero(getgxTv_SdtLegajo_Legnumero());
      struct.setLegapellido(getgxTv_SdtLegajo_Legapellido());
      struct.setLegnombre(getgxTv_SdtLegajo_Legnombre());
      struct.setLegfoto(getgxTv_SdtLegajo_Legfoto());
      struct.setSalario(getgxTv_SdtLegajo_Salario().getStruct());
      struct.setFamilia(getgxTv_SdtLegajo_Familia().getStruct());
      struct.setLegfotonom(getgxTv_SdtLegajo_Legfotonom());
      struct.setLegfotoext(getgxTv_SdtLegajo_Legfotoext());
      struct.setLegtipdoc(getgxTv_SdtLegajo_Legtipdoc());
      struct.setLegnumdoc(getgxTv_SdtLegajo_Legnumdoc());
      struct.setLegfecnac(getgxTv_SdtLegajo_Legfecnac());
      struct.setLegsexo(getgxTv_SdtLegajo_Legsexo());
      struct.setLegestadocivil(getgxTv_SdtLegajo_Legestadocivil());
      struct.setLegnacioncod(getgxTv_SdtLegajo_Legnacioncod());
      struct.setLegnacionalidad(getgxTv_SdtLegajo_Legnacionalidad());
      struct.setLegcuil(getgxTv_SdtLegajo_Legcuil());
      struct.setLegdiscapacidad(getgxTv_SdtLegajo_Legdiscapacidad());
      struct.setLegdomici(getgxTv_SdtLegajo_Legdomici());
      struct.setLegemail(getgxTv_SdtLegajo_Legemail());
      struct.setLegcodpos(getgxTv_SdtLegajo_Legcodpos());
      struct.setLegpaicod(getgxTv_SdtLegajo_Legpaicod());
      struct.setLegpainom(getgxTv_SdtLegajo_Legpainom());
      struct.setLegprovcod(getgxTv_SdtLegajo_Legprovcod());
      struct.setLegprovnom(getgxTv_SdtLegajo_Legprovnom());
      struct.setLegloccod(getgxTv_SdtLegajo_Legloccod());
      struct.setLeglocnom(getgxTv_SdtLegajo_Leglocnom());
      struct.setLegtelefono(getgxTv_SdtLegajo_Legtelefono());
      struct.setLegfecingreso(getgxTv_SdtLegajo_Legfecingreso());
      struct.setLegfecegreso(getgxTv_SdtLegajo_Legfecegreso());
      struct.setLegmegcodigo(getgxTv_SdtLegajo_Legmegcodigo());
      struct.setMegdescrip(getgxTv_SdtLegajo_Megdescrip());
      struct.setLegcatcodigo(getgxTv_SdtLegajo_Legcatcodigo());
      struct.setLegcatpuecod(getgxTv_SdtLegajo_Legcatpuecod());
      struct.setLegseccodigo(getgxTv_SdtLegajo_Legseccodigo());
      struct.setSecdescrip(getgxTv_SdtLegajo_Secdescrip());
      struct.setLeglpgcodigo(getgxTv_SdtLegajo_Leglpgcodigo());
      struct.setLpgdescri(getgxTv_SdtLegajo_Lpgdescri());
      struct.setLegclase(getgxTv_SdtLegajo_Legclase());
      struct.setLegbasico(getgxTv_SdtLegajo_Legbasico());
      struct.setLegformapago(getgxTv_SdtLegajo_Legformapago());
      struct.setLegbancod(getgxTv_SdtLegajo_Legbancod());
      struct.setLegbandes(getgxTv_SdtLegajo_Legbandes());
      struct.setLegbansuc(getgxTv_SdtLegajo_Legbansuc());
      struct.setLegbantipcuen(getgxTv_SdtLegajo_Legbantipcuen());
      struct.setLegsincod(getgxTv_SdtLegajo_Legsincod());
      struct.setSindescrip(getgxTv_SdtLegajo_Sindescrip());
      struct.setLegosocod(getgxTv_SdtLegajo_Legosocod());
      struct.setLegosodes(getgxTv_SdtLegajo_Legosodes());
      struct.setLegosoafipcod(getgxTv_SdtLegajo_Legosoafipcod());
      struct.setOsodescrip(getgxTv_SdtLegajo_Osodescrip());
      struct.setLegactcodigo(getgxTv_SdtLegajo_Legactcodigo());
      struct.setLegactdescri(getgxTv_SdtLegajo_Legactdescri());
      struct.setMprcod(getgxTv_SdtLegajo_Mprcod());
      struct.setMprdescrip(getgxTv_SdtLegajo_Mprdescrip());
      struct.setLegfecultmod(getgxTv_SdtLegajo_Legfecultmod());
      struct.setLegcuentabanc(getgxTv_SdtLegajo_Legcuentabanc());
      struct.setLeglicinicio(getgxTv_SdtLegajo_Leglicinicio());
      struct.setLeglicfinal(getgxTv_SdtLegajo_Leglicfinal());
      struct.setZoncod(getgxTv_SdtLegajo_Zoncod());
      struct.setZondescrip(getgxTv_SdtLegajo_Zondescrip());
      struct.setZonporcreduc(getgxTv_SdtLegajo_Zonporcreduc());
      struct.setLegcbu(getgxTv_SdtLegajo_Legcbu());
      struct.setLegconvenio(getgxTv_SdtLegajo_Legconvenio());
      struct.setLegscvo(getgxTv_SdtLegajo_Legscvo());
      struct.setCondicodigo(getgxTv_SdtLegajo_Condicodigo());
      struct.setCondidescri(getgxTv_SdtLegajo_Condidescri());
      struct.setSiniecodigo(getgxTv_SdtLegajo_Siniecodigo());
      struct.setSiniedescri(getgxTv_SdtLegajo_Siniedescri());
      struct.setLegactivo(getgxTv_SdtLegajo_Legactivo());
      struct.setLegsueldofuera(getgxTv_SdtLegajo_Legsueldofuera());
      struct.setLegid(getgxTv_SdtLegajo_Legid());
      struct.setLegconvecodigo(getgxTv_SdtLegajo_Legconvecodigo());
      struct.setLegidnomape(getgxTv_SdtLegajo_Legidnomape());
      struct.setTipemplecod(getgxTv_SdtLegajo_Tipemplecod());
      struct.setOsoc3992(getgxTv_SdtLegajo_Osoc3992());
      struct.setLegobs(getgxTv_SdtLegajo_Legobs());
      struct.setLegnomape(getgxTv_SdtLegajo_Legnomape());
      struct.setLegfecimportacion(getgxTv_SdtLegajo_Legfecimportacion());
      struct.setLegagenreten(getgxTv_SdtLegajo_Legagenreten());
      struct.setLegcontinua(getgxTv_SdtLegajo_Legcontinua());
      struct.setLegrecalcliq(getgxTv_SdtLegajo_Legrecalcliq());
      struct.setLegjubilado(getgxTv_SdtLegajo_Legjubilado());
      struct.setLeghorasdia(getgxTv_SdtLegajo_Leghorasdia());
      struct.setLeghorassem(getgxTv_SdtLegajo_Leghorassem());
      struct.setLegreligion(getgxTv_SdtLegajo_Legreligion());
      struct.setLegorigen(getgxTv_SdtLegajo_Legorigen());
      struct.setLegpuescodigo(getgxTv_SdtLegajo_Legpuescodigo());
      struct.setLegsuccodigo(getgxTv_SdtLegajo_Legsuccodigo());
      struct.setLegtrablun(getgxTv_SdtLegajo_Legtrablun());
      struct.setLegtrabmar(getgxTv_SdtLegajo_Legtrabmar());
      struct.setLegtrabmie(getgxTv_SdtLegajo_Legtrabmie());
      struct.setLegtrabjue(getgxTv_SdtLegajo_Legtrabjue());
      struct.setLegtrabvie(getgxTv_SdtLegajo_Legtrabvie());
      struct.setLegtrabsa(getgxTv_SdtLegajo_Legtrabsa());
      struct.setLegtrabdo(getgxTv_SdtLegajo_Legtrabdo());
      struct.setTipos_de_trabajo(getgxTv_SdtLegajo_Tipos_de_trabajo().getStruct());
      struct.setLegvacpend(getgxTv_SdtLegajo_Legvacpend());
      struct.setLegfecpreaviso(getgxTv_SdtLegajo_Legfecpreaviso());
      struct.setLegconveversioncli(getgxTv_SdtLegajo_Legconveversioncli());
      struct.setLegsitrevegreso(getgxTv_SdtLegajo_Legsitrevegreso());
      struct.setLegpromdias(getgxTv_SdtLegajo_Legpromdias());
      struct.setLegtitulo(getgxTv_SdtLegajo_Legtitulo());
      struct.setLegestado(getgxTv_SdtLegajo_Legestado());
      struct.setLegactclasnro(getgxTv_SdtLegajo_Legactclasnro());
      struct.setLegpueaficod(getgxTv_SdtLegajo_Legpueaficod());
      struct.setLegmigrwarn(getgxTv_SdtLegajo_Legmigrwarn());
      struct.setLegincompleto(getgxTv_SdtLegajo_Legincompleto());
      struct.setLegliqapo(getgxTv_SdtLegajo_Legliqapo());
      struct.setPropiedades(getgxTv_SdtLegajo_Propiedades().getStruct());
      struct.setLegmodtra(getgxTv_SdtLegajo_Legmodtra());
      struct.setLegtipotarifa(getgxTv_SdtLegajo_Legtipotarifa());
      struct.setMode(getgxTv_SdtLegajo_Mode());
      struct.setInitialized(getgxTv_SdtLegajo_Initialized());
      struct.setClicod_Z(getgxTv_SdtLegajo_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLegajo_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtLegajo_Empnom_Z());
      struct.setLegnumero_Z(getgxTv_SdtLegajo_Legnumero_Z());
      struct.setLegapellido_Z(getgxTv_SdtLegajo_Legapellido_Z());
      struct.setLegnombre_Z(getgxTv_SdtLegajo_Legnombre_Z());
      struct.setLegfotonom_Z(getgxTv_SdtLegajo_Legfotonom_Z());
      struct.setLegfotoext_Z(getgxTv_SdtLegajo_Legfotoext_Z());
      struct.setLegtipdoc_Z(getgxTv_SdtLegajo_Legtipdoc_Z());
      struct.setLegnumdoc_Z(getgxTv_SdtLegajo_Legnumdoc_Z());
      struct.setLegfecnac_Z(getgxTv_SdtLegajo_Legfecnac_Z());
      struct.setLegsexo_Z(getgxTv_SdtLegajo_Legsexo_Z());
      struct.setLegestadocivil_Z(getgxTv_SdtLegajo_Legestadocivil_Z());
      struct.setLegnacioncod_Z(getgxTv_SdtLegajo_Legnacioncod_Z());
      struct.setLegnacionalidad_Z(getgxTv_SdtLegajo_Legnacionalidad_Z());
      struct.setLegcuil_Z(getgxTv_SdtLegajo_Legcuil_Z());
      struct.setLegdiscapacidad_Z(getgxTv_SdtLegajo_Legdiscapacidad_Z());
      struct.setLegdomici_Z(getgxTv_SdtLegajo_Legdomici_Z());
      struct.setLegemail_Z(getgxTv_SdtLegajo_Legemail_Z());
      struct.setLegcodpos_Z(getgxTv_SdtLegajo_Legcodpos_Z());
      struct.setLegpaicod_Z(getgxTv_SdtLegajo_Legpaicod_Z());
      struct.setLegpainom_Z(getgxTv_SdtLegajo_Legpainom_Z());
      struct.setLegprovcod_Z(getgxTv_SdtLegajo_Legprovcod_Z());
      struct.setLegprovnom_Z(getgxTv_SdtLegajo_Legprovnom_Z());
      struct.setLegloccod_Z(getgxTv_SdtLegajo_Legloccod_Z());
      struct.setLeglocnom_Z(getgxTv_SdtLegajo_Leglocnom_Z());
      struct.setLegtelefono_Z(getgxTv_SdtLegajo_Legtelefono_Z());
      struct.setLegfecingreso_Z(getgxTv_SdtLegajo_Legfecingreso_Z());
      struct.setLegfecegreso_Z(getgxTv_SdtLegajo_Legfecegreso_Z());
      struct.setLegmegcodigo_Z(getgxTv_SdtLegajo_Legmegcodigo_Z());
      struct.setMegdescrip_Z(getgxTv_SdtLegajo_Megdescrip_Z());
      struct.setLegcatcodigo_Z(getgxTv_SdtLegajo_Legcatcodigo_Z());
      struct.setLegcatpuecod_Z(getgxTv_SdtLegajo_Legcatpuecod_Z());
      struct.setLegseccodigo_Z(getgxTv_SdtLegajo_Legseccodigo_Z());
      struct.setSecdescrip_Z(getgxTv_SdtLegajo_Secdescrip_Z());
      struct.setLeglpgcodigo_Z(getgxTv_SdtLegajo_Leglpgcodigo_Z());
      struct.setLpgdescri_Z(getgxTv_SdtLegajo_Lpgdescri_Z());
      struct.setLegclase_Z(getgxTv_SdtLegajo_Legclase_Z());
      struct.setLegbasico_Z(getgxTv_SdtLegajo_Legbasico_Z());
      struct.setLegformapago_Z(getgxTv_SdtLegajo_Legformapago_Z());
      struct.setLegbancod_Z(getgxTv_SdtLegajo_Legbancod_Z());
      struct.setLegbandes_Z(getgxTv_SdtLegajo_Legbandes_Z());
      struct.setLegbansuc_Z(getgxTv_SdtLegajo_Legbansuc_Z());
      struct.setLegbantipcuen_Z(getgxTv_SdtLegajo_Legbantipcuen_Z());
      struct.setLegsincod_Z(getgxTv_SdtLegajo_Legsincod_Z());
      struct.setSindescrip_Z(getgxTv_SdtLegajo_Sindescrip_Z());
      struct.setLegosocod_Z(getgxTv_SdtLegajo_Legosocod_Z());
      struct.setLegosodes_Z(getgxTv_SdtLegajo_Legosodes_Z());
      struct.setLegosoafipcod_Z(getgxTv_SdtLegajo_Legosoafipcod_Z());
      struct.setOsodescrip_Z(getgxTv_SdtLegajo_Osodescrip_Z());
      struct.setLegactcodigo_Z(getgxTv_SdtLegajo_Legactcodigo_Z());
      struct.setLegactdescri_Z(getgxTv_SdtLegajo_Legactdescri_Z());
      struct.setMprcod_Z(getgxTv_SdtLegajo_Mprcod_Z());
      struct.setMprdescrip_Z(getgxTv_SdtLegajo_Mprdescrip_Z());
      struct.setLegfecultmod_Z(getgxTv_SdtLegajo_Legfecultmod_Z());
      struct.setLegcuentabanc_Z(getgxTv_SdtLegajo_Legcuentabanc_Z());
      struct.setLeglicinicio_Z(getgxTv_SdtLegajo_Leglicinicio_Z());
      struct.setLeglicfinal_Z(getgxTv_SdtLegajo_Leglicfinal_Z());
      struct.setZoncod_Z(getgxTv_SdtLegajo_Zoncod_Z());
      struct.setZondescrip_Z(getgxTv_SdtLegajo_Zondescrip_Z());
      struct.setZonporcreduc_Z(getgxTv_SdtLegajo_Zonporcreduc_Z());
      struct.setLegcbu_Z(getgxTv_SdtLegajo_Legcbu_Z());
      struct.setLegconvenio_Z(getgxTv_SdtLegajo_Legconvenio_Z());
      struct.setLegscvo_Z(getgxTv_SdtLegajo_Legscvo_Z());
      struct.setCondicodigo_Z(getgxTv_SdtLegajo_Condicodigo_Z());
      struct.setCondidescri_Z(getgxTv_SdtLegajo_Condidescri_Z());
      struct.setSiniecodigo_Z(getgxTv_SdtLegajo_Siniecodigo_Z());
      struct.setSiniedescri_Z(getgxTv_SdtLegajo_Siniedescri_Z());
      struct.setLegactivo_Z(getgxTv_SdtLegajo_Legactivo_Z());
      struct.setLegsueldofuera_Z(getgxTv_SdtLegajo_Legsueldofuera_Z());
      struct.setLegid_Z(getgxTv_SdtLegajo_Legid_Z());
      struct.setLegconvecodigo_Z(getgxTv_SdtLegajo_Legconvecodigo_Z());
      struct.setLegidnomape_Z(getgxTv_SdtLegajo_Legidnomape_Z());
      struct.setTipemplecod_Z(getgxTv_SdtLegajo_Tipemplecod_Z());
      struct.setOsoc3992_Z(getgxTv_SdtLegajo_Osoc3992_Z());
      struct.setLegnomape_Z(getgxTv_SdtLegajo_Legnomape_Z());
      struct.setLegfecimportacion_Z(getgxTv_SdtLegajo_Legfecimportacion_Z());
      struct.setLegagenreten_Z(getgxTv_SdtLegajo_Legagenreten_Z());
      struct.setLegcontinua_Z(getgxTv_SdtLegajo_Legcontinua_Z());
      struct.setLegrecalcliq_Z(getgxTv_SdtLegajo_Legrecalcliq_Z());
      struct.setLegjubilado_Z(getgxTv_SdtLegajo_Legjubilado_Z());
      struct.setLeghorasdia_Z(getgxTv_SdtLegajo_Leghorasdia_Z());
      struct.setLeghorassem_Z(getgxTv_SdtLegajo_Leghorassem_Z());
      struct.setLegreligion_Z(getgxTv_SdtLegajo_Legreligion_Z());
      struct.setLegorigen_Z(getgxTv_SdtLegajo_Legorigen_Z());
      struct.setLegpuescodigo_Z(getgxTv_SdtLegajo_Legpuescodigo_Z());
      struct.setLegsuccodigo_Z(getgxTv_SdtLegajo_Legsuccodigo_Z());
      struct.setLegtrablun_Z(getgxTv_SdtLegajo_Legtrablun_Z());
      struct.setLegtrabmar_Z(getgxTv_SdtLegajo_Legtrabmar_Z());
      struct.setLegtrabmie_Z(getgxTv_SdtLegajo_Legtrabmie_Z());
      struct.setLegtrabjue_Z(getgxTv_SdtLegajo_Legtrabjue_Z());
      struct.setLegtrabvie_Z(getgxTv_SdtLegajo_Legtrabvie_Z());
      struct.setLegtrabsa_Z(getgxTv_SdtLegajo_Legtrabsa_Z());
      struct.setLegtrabdo_Z(getgxTv_SdtLegajo_Legtrabdo_Z());
      struct.setLegvacpend_Z(getgxTv_SdtLegajo_Legvacpend_Z());
      struct.setLegfecpreaviso_Z(getgxTv_SdtLegajo_Legfecpreaviso_Z());
      struct.setLegconveversioncli_Z(getgxTv_SdtLegajo_Legconveversioncli_Z());
      struct.setLegsitrevegreso_Z(getgxTv_SdtLegajo_Legsitrevegreso_Z());
      struct.setLegpromdias_Z(getgxTv_SdtLegajo_Legpromdias_Z());
      struct.setLegtitulo_Z(getgxTv_SdtLegajo_Legtitulo_Z());
      struct.setLegestado_Z(getgxTv_SdtLegajo_Legestado_Z());
      struct.setLegactclasnro_Z(getgxTv_SdtLegajo_Legactclasnro_Z());
      struct.setLegpueaficod_Z(getgxTv_SdtLegajo_Legpueaficod_Z());
      struct.setLegincompleto_Z(getgxTv_SdtLegajo_Legincompleto_Z());
      struct.setLegliqapo_Z(getgxTv_SdtLegajo_Legliqapo_Z());
      struct.setLegmodtra_Z(getgxTv_SdtLegajo_Legmodtra_Z());
      struct.setLegtipotarifa_Z(getgxTv_SdtLegajo_Legtipotarifa_Z());
      struct.setLegfoto_N(getgxTv_SdtLegajo_Legfoto_N());
      struct.setLegsexo_N(getgxTv_SdtLegajo_Legsexo_N());
      struct.setLegestadocivil_N(getgxTv_SdtLegajo_Legestadocivil_N());
      struct.setLegnacioncod_N(getgxTv_SdtLegajo_Legnacioncod_N());
      struct.setLegpaicod_N(getgxTv_SdtLegajo_Legpaicod_N());
      struct.setLegprovcod_N(getgxTv_SdtLegajo_Legprovcod_N());
      struct.setLegloccod_N(getgxTv_SdtLegajo_Legloccod_N());
      struct.setLegtelefono_N(getgxTv_SdtLegajo_Legtelefono_N());
      struct.setLegfecegreso_N(getgxTv_SdtLegajo_Legfecegreso_N());
      struct.setLegmegcodigo_N(getgxTv_SdtLegajo_Legmegcodigo_N());
      struct.setMegdescrip_N(getgxTv_SdtLegajo_Megdescrip_N());
      struct.setLegcatcodigo_N(getgxTv_SdtLegajo_Legcatcodigo_N());
      struct.setLegcatpuecod_N(getgxTv_SdtLegajo_Legcatpuecod_N());
      struct.setLegseccodigo_N(getgxTv_SdtLegajo_Legseccodigo_N());
      struct.setSecdescrip_N(getgxTv_SdtLegajo_Secdescrip_N());
      struct.setLeglpgcodigo_N(getgxTv_SdtLegajo_Leglpgcodigo_N());
      struct.setLpgdescri_N(getgxTv_SdtLegajo_Lpgdescri_N());
      struct.setLegbancod_N(getgxTv_SdtLegajo_Legbancod_N());
      struct.setLegbansuc_N(getgxTv_SdtLegajo_Legbansuc_N());
      struct.setLegbantipcuen_N(getgxTv_SdtLegajo_Legbantipcuen_N());
      struct.setLegsincod_N(getgxTv_SdtLegajo_Legsincod_N());
      struct.setSindescrip_N(getgxTv_SdtLegajo_Sindescrip_N());
      struct.setLegosocod_N(getgxTv_SdtLegajo_Legosocod_N());
      struct.setLegosoafipcod_N(getgxTv_SdtLegajo_Legosoafipcod_N());
      struct.setOsodescrip_N(getgxTv_SdtLegajo_Osodescrip_N());
      struct.setLegactcodigo_N(getgxTv_SdtLegajo_Legactcodigo_N());
      struct.setMprcod_N(getgxTv_SdtLegajo_Mprcod_N());
      struct.setLegcuentabanc_N(getgxTv_SdtLegajo_Legcuentabanc_N());
      struct.setLeglicinicio_N(getgxTv_SdtLegajo_Leglicinicio_N());
      struct.setLeglicfinal_N(getgxTv_SdtLegajo_Leglicfinal_N());
      struct.setZoncod_N(getgxTv_SdtLegajo_Zoncod_N());
      struct.setLegcbu_N(getgxTv_SdtLegajo_Legcbu_N());
      struct.setCondicodigo_N(getgxTv_SdtLegajo_Condicodigo_N());
      struct.setSiniecodigo_N(getgxTv_SdtLegajo_Siniecodigo_N());
      struct.setLegid_N(getgxTv_SdtLegajo_Legid_N());
      struct.setLegconvecodigo_N(getgxTv_SdtLegajo_Legconvecodigo_N());
      struct.setTipemplecod_N(getgxTv_SdtLegajo_Tipemplecod_N());
      struct.setOsoc3992_N(getgxTv_SdtLegajo_Osoc3992_N());
      struct.setLegreligion_N(getgxTv_SdtLegajo_Legreligion_N());
      struct.setLegorigen_N(getgxTv_SdtLegajo_Legorigen_N());
      struct.setLegpuescodigo_N(getgxTv_SdtLegajo_Legpuescodigo_N());
      struct.setLegsuccodigo_N(getgxTv_SdtLegajo_Legsuccodigo_N());
      struct.setLegconveversioncli_N(getgxTv_SdtLegajo_Legconveversioncli_N());
      struct.setLegsitrevegreso_N(getgxTv_SdtLegajo_Legsitrevegreso_N());
      struct.setLegactclasnro_N(getgxTv_SdtLegajo_Legactclasnro_N());
      struct.setLegpueaficod_N(getgxTv_SdtLegajo_Legpueaficod_N());
      struct.setLegmigrwarn_N(getgxTv_SdtLegajo_Legmigrwarn_N());
      return struct ;
   }

   private byte gxTv_SdtLegajo_N ;
   private byte gxTv_SdtLegajo_Legtipdoc ;
   private byte gxTv_SdtLegajo_Legsexo ;
   private byte gxTv_SdtLegajo_Legdiscapacidad ;
   private byte gxTv_SdtLegajo_Legclase ;
   private byte gxTv_SdtLegajo_Legformapago ;
   private byte gxTv_SdtLegajo_Legestado ;
   private byte gxTv_SdtLegajo_Legtipdoc_Z ;
   private byte gxTv_SdtLegajo_Legsexo_Z ;
   private byte gxTv_SdtLegajo_Legdiscapacidad_Z ;
   private byte gxTv_SdtLegajo_Legclase_Z ;
   private byte gxTv_SdtLegajo_Legformapago_Z ;
   private byte gxTv_SdtLegajo_Legestado_Z ;
   private byte gxTv_SdtLegajo_Legfoto_N ;
   private byte gxTv_SdtLegajo_Legsexo_N ;
   private byte gxTv_SdtLegajo_Legestadocivil_N ;
   private byte gxTv_SdtLegajo_Legnacioncod_N ;
   private byte gxTv_SdtLegajo_Legpaicod_N ;
   private byte gxTv_SdtLegajo_Legprovcod_N ;
   private byte gxTv_SdtLegajo_Legloccod_N ;
   private byte gxTv_SdtLegajo_Legtelefono_N ;
   private byte gxTv_SdtLegajo_Legfecegreso_N ;
   private byte gxTv_SdtLegajo_Legmegcodigo_N ;
   private byte gxTv_SdtLegajo_Megdescrip_N ;
   private byte gxTv_SdtLegajo_Legcatcodigo_N ;
   private byte gxTv_SdtLegajo_Legcatpuecod_N ;
   private byte gxTv_SdtLegajo_Legseccodigo_N ;
   private byte gxTv_SdtLegajo_Secdescrip_N ;
   private byte gxTv_SdtLegajo_Leglpgcodigo_N ;
   private byte gxTv_SdtLegajo_Lpgdescri_N ;
   private byte gxTv_SdtLegajo_Legbancod_N ;
   private byte gxTv_SdtLegajo_Legbansuc_N ;
   private byte gxTv_SdtLegajo_Legbantipcuen_N ;
   private byte gxTv_SdtLegajo_Legsincod_N ;
   private byte gxTv_SdtLegajo_Sindescrip_N ;
   private byte gxTv_SdtLegajo_Legosocod_N ;
   private byte gxTv_SdtLegajo_Legosoafipcod_N ;
   private byte gxTv_SdtLegajo_Osodescrip_N ;
   private byte gxTv_SdtLegajo_Legactcodigo_N ;
   private byte gxTv_SdtLegajo_Mprcod_N ;
   private byte gxTv_SdtLegajo_Legcuentabanc_N ;
   private byte gxTv_SdtLegajo_Leglicinicio_N ;
   private byte gxTv_SdtLegajo_Leglicfinal_N ;
   private byte gxTv_SdtLegajo_Zoncod_N ;
   private byte gxTv_SdtLegajo_Legcbu_N ;
   private byte gxTv_SdtLegajo_Condicodigo_N ;
   private byte gxTv_SdtLegajo_Siniecodigo_N ;
   private byte gxTv_SdtLegajo_Legid_N ;
   private byte gxTv_SdtLegajo_Legconvecodigo_N ;
   private byte gxTv_SdtLegajo_Tipemplecod_N ;
   private byte gxTv_SdtLegajo_Osoc3992_N ;
   private byte gxTv_SdtLegajo_Legreligion_N ;
   private byte gxTv_SdtLegajo_Legorigen_N ;
   private byte gxTv_SdtLegajo_Legpuescodigo_N ;
   private byte gxTv_SdtLegajo_Legsuccodigo_N ;
   private byte gxTv_SdtLegajo_Legconveversioncli_N ;
   private byte gxTv_SdtLegajo_Legsitrevegreso_N ;
   private byte gxTv_SdtLegajo_Legactclasnro_N ;
   private byte gxTv_SdtLegajo_Legpueaficod_N ;
   private byte gxTv_SdtLegajo_Legmigrwarn_N ;
   private short gxTv_SdtLegajo_Empcod ;
   private short gxTv_SdtLegajo_Legestadocivil ;
   private short gxTv_SdtLegajo_Legnacioncod ;
   private short gxTv_SdtLegajo_Legpaicod ;
   private short gxTv_SdtLegajo_Legprovcod ;
   private short gxTv_SdtLegajo_Legloccod ;
   private short gxTv_SdtLegajo_Condicodigo ;
   private short gxTv_SdtLegajo_Legvacpend ;
   private short gxTv_SdtLegajo_Legsitrevegreso ;
   private short gxTv_SdtLegajo_Initialized ;
   private short gxTv_SdtLegajo_Empcod_Z ;
   private short gxTv_SdtLegajo_Legestadocivil_Z ;
   private short gxTv_SdtLegajo_Legnacioncod_Z ;
   private short gxTv_SdtLegajo_Legpaicod_Z ;
   private short gxTv_SdtLegajo_Legprovcod_Z ;
   private short gxTv_SdtLegajo_Legloccod_Z ;
   private short gxTv_SdtLegajo_Condicodigo_Z ;
   private short gxTv_SdtLegajo_Legvacpend_Z ;
   private short gxTv_SdtLegajo_Legsitrevegreso_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLegajo_Clicod ;
   private int gxTv_SdtLegajo_Legnumero ;
   private int gxTv_SdtLegajo_Legcatpuecod ;
   private int gxTv_SdtLegajo_Legconveversioncli ;
   private int gxTv_SdtLegajo_Legactclasnro ;
   private int gxTv_SdtLegajo_Clicod_Z ;
   private int gxTv_SdtLegajo_Legnumero_Z ;
   private int gxTv_SdtLegajo_Legcatpuecod_Z ;
   private int gxTv_SdtLegajo_Legconveversioncli_Z ;
   private int gxTv_SdtLegajo_Legactclasnro_Z ;
   private long gxTv_SdtLegajo_Legcuil ;
   private long gxTv_SdtLegajo_Legcuil_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Legbasico ;
   private java.math.BigDecimal gxTv_SdtLegajo_Zonporcreduc ;
   private java.math.BigDecimal gxTv_SdtLegajo_Legsueldofuera ;
   private java.math.BigDecimal gxTv_SdtLegajo_Leghorasdia ;
   private java.math.BigDecimal gxTv_SdtLegajo_Leghorassem ;
   private java.math.BigDecimal gxTv_SdtLegajo_Legbasico_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Zonporcreduc_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Legsueldofuera_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Leghorasdia_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Leghorassem_Z ;
   private String gxTv_SdtLegajo_Legfotoext ;
   private String gxTv_SdtLegajo_Legcodpos ;
   private String gxTv_SdtLegajo_Legmegcodigo ;
   private String gxTv_SdtLegajo_Legcatcodigo ;
   private String gxTv_SdtLegajo_Legseccodigo ;
   private String gxTv_SdtLegajo_Leglpgcodigo ;
   private String gxTv_SdtLegajo_Legbancod ;
   private String gxTv_SdtLegajo_Legbantipcuen ;
   private String gxTv_SdtLegajo_Legsincod ;
   private String gxTv_SdtLegajo_Legosocod ;
   private String gxTv_SdtLegajo_Legosoafipcod ;
   private String gxTv_SdtLegajo_Legactcodigo ;
   private String gxTv_SdtLegajo_Mprcod ;
   private String gxTv_SdtLegajo_Zoncod ;
   private String gxTv_SdtLegajo_Siniecodigo ;
   private String gxTv_SdtLegajo_Legid ;
   private String gxTv_SdtLegajo_Legconvecodigo ;
   private String gxTv_SdtLegajo_Tipemplecod ;
   private String gxTv_SdtLegajo_Osoc3992 ;
   private String gxTv_SdtLegajo_Legcontinua ;
   private String gxTv_SdtLegajo_Legreligion ;
   private String gxTv_SdtLegajo_Legorigen ;
   private String gxTv_SdtLegajo_Legpuescodigo ;
   private String gxTv_SdtLegajo_Legsuccodigo ;
   private String gxTv_SdtLegajo_Legtitulo ;
   private String gxTv_SdtLegajo_Legpueaficod ;
   private String gxTv_SdtLegajo_Legmodtra ;
   private String gxTv_SdtLegajo_Legtipotarifa ;
   private String gxTv_SdtLegajo_Mode ;
   private String gxTv_SdtLegajo_Legfotoext_Z ;
   private String gxTv_SdtLegajo_Legcodpos_Z ;
   private String gxTv_SdtLegajo_Legmegcodigo_Z ;
   private String gxTv_SdtLegajo_Legcatcodigo_Z ;
   private String gxTv_SdtLegajo_Legseccodigo_Z ;
   private String gxTv_SdtLegajo_Leglpgcodigo_Z ;
   private String gxTv_SdtLegajo_Legbancod_Z ;
   private String gxTv_SdtLegajo_Legbantipcuen_Z ;
   private String gxTv_SdtLegajo_Legsincod_Z ;
   private String gxTv_SdtLegajo_Legosocod_Z ;
   private String gxTv_SdtLegajo_Legosoafipcod_Z ;
   private String gxTv_SdtLegajo_Legactcodigo_Z ;
   private String gxTv_SdtLegajo_Mprcod_Z ;
   private String gxTv_SdtLegajo_Zoncod_Z ;
   private String gxTv_SdtLegajo_Siniecodigo_Z ;
   private String gxTv_SdtLegajo_Legid_Z ;
   private String gxTv_SdtLegajo_Legconvecodigo_Z ;
   private String gxTv_SdtLegajo_Tipemplecod_Z ;
   private String gxTv_SdtLegajo_Osoc3992_Z ;
   private String gxTv_SdtLegajo_Legcontinua_Z ;
   private String gxTv_SdtLegajo_Legreligion_Z ;
   private String gxTv_SdtLegajo_Legorigen_Z ;
   private String gxTv_SdtLegajo_Legpuescodigo_Z ;
   private String gxTv_SdtLegajo_Legsuccodigo_Z ;
   private String gxTv_SdtLegajo_Legtitulo_Z ;
   private String gxTv_SdtLegajo_Legpueaficod_Z ;
   private String gxTv_SdtLegajo_Legmodtra_Z ;
   private String gxTv_SdtLegajo_Legtipotarifa_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajo_Legfecimportacion ;
   private java.util.Date gxTv_SdtLegajo_Legfecimportacion_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtLegajo_Legfecnac ;
   private java.util.Date gxTv_SdtLegajo_Legfecingreso ;
   private java.util.Date gxTv_SdtLegajo_Legfecegreso ;
   private java.util.Date gxTv_SdtLegajo_Legfecultmod ;
   private java.util.Date gxTv_SdtLegajo_Leglicinicio ;
   private java.util.Date gxTv_SdtLegajo_Leglicfinal ;
   private java.util.Date gxTv_SdtLegajo_Legfecpreaviso ;
   private java.util.Date gxTv_SdtLegajo_Legfecnac_Z ;
   private java.util.Date gxTv_SdtLegajo_Legfecingreso_Z ;
   private java.util.Date gxTv_SdtLegajo_Legfecegreso_Z ;
   private java.util.Date gxTv_SdtLegajo_Legfecultmod_Z ;
   private java.util.Date gxTv_SdtLegajo_Leglicinicio_Z ;
   private java.util.Date gxTv_SdtLegajo_Leglicfinal_Z ;
   private java.util.Date gxTv_SdtLegajo_Legfecpreaviso_Z ;
   private boolean gxTv_SdtLegajo_Legconvenio ;
   private boolean gxTv_SdtLegajo_Legscvo ;
   private boolean gxTv_SdtLegajo_Legactivo ;
   private boolean gxTv_SdtLegajo_Legagenreten ;
   private boolean gxTv_SdtLegajo_Legrecalcliq ;
   private boolean gxTv_SdtLegajo_Legjubilado ;
   private boolean gxTv_SdtLegajo_Legtrablun ;
   private boolean gxTv_SdtLegajo_Legtrabmar ;
   private boolean gxTv_SdtLegajo_Legtrabmie ;
   private boolean gxTv_SdtLegajo_Legtrabjue ;
   private boolean gxTv_SdtLegajo_Legtrabvie ;
   private boolean gxTv_SdtLegajo_Legtrabsa ;
   private boolean gxTv_SdtLegajo_Legtrabdo ;
   private boolean gxTv_SdtLegajo_Legincompleto ;
   private boolean gxTv_SdtLegajo_Legliqapo ;
   private boolean gxTv_SdtLegajo_Legconvenio_Z ;
   private boolean gxTv_SdtLegajo_Legscvo_Z ;
   private boolean gxTv_SdtLegajo_Legactivo_Z ;
   private boolean gxTv_SdtLegajo_Legagenreten_Z ;
   private boolean gxTv_SdtLegajo_Legrecalcliq_Z ;
   private boolean gxTv_SdtLegajo_Legjubilado_Z ;
   private boolean gxTv_SdtLegajo_Legtrablun_Z ;
   private boolean gxTv_SdtLegajo_Legtrabmar_Z ;
   private boolean gxTv_SdtLegajo_Legtrabmie_Z ;
   private boolean gxTv_SdtLegajo_Legtrabjue_Z ;
   private boolean gxTv_SdtLegajo_Legtrabvie_Z ;
   private boolean gxTv_SdtLegajo_Legtrabsa_Z ;
   private boolean gxTv_SdtLegajo_Legtrabdo_Z ;
   private boolean gxTv_SdtLegajo_Legincompleto_Z ;
   private boolean gxTv_SdtLegajo_Legliqapo_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajo_Legobs ;
   private String gxTv_SdtLegajo_Legmigrwarn ;
   private String gxTv_SdtLegajo_Legfoto ;
   private String gxTv_SdtLegajo_Empnom ;
   private String gxTv_SdtLegajo_Legapellido ;
   private String gxTv_SdtLegajo_Legnombre ;
   private String gxTv_SdtLegajo_Legfotonom ;
   private String gxTv_SdtLegajo_Legnumdoc ;
   private String gxTv_SdtLegajo_Legnacionalidad ;
   private String gxTv_SdtLegajo_Legdomici ;
   private String gxTv_SdtLegajo_Legemail ;
   private String gxTv_SdtLegajo_Legpainom ;
   private String gxTv_SdtLegajo_Legprovnom ;
   private String gxTv_SdtLegajo_Leglocnom ;
   private String gxTv_SdtLegajo_Legtelefono ;
   private String gxTv_SdtLegajo_Megdescrip ;
   private String gxTv_SdtLegajo_Secdescrip ;
   private String gxTv_SdtLegajo_Lpgdescri ;
   private String gxTv_SdtLegajo_Legbandes ;
   private String gxTv_SdtLegajo_Legbansuc ;
   private String gxTv_SdtLegajo_Sindescrip ;
   private String gxTv_SdtLegajo_Legosodes ;
   private String gxTv_SdtLegajo_Osodescrip ;
   private String gxTv_SdtLegajo_Legactdescri ;
   private String gxTv_SdtLegajo_Mprdescrip ;
   private String gxTv_SdtLegajo_Legcuentabanc ;
   private String gxTv_SdtLegajo_Zondescrip ;
   private String gxTv_SdtLegajo_Legcbu ;
   private String gxTv_SdtLegajo_Condidescri ;
   private String gxTv_SdtLegajo_Siniedescri ;
   private String gxTv_SdtLegajo_Legidnomape ;
   private String gxTv_SdtLegajo_Legnomape ;
   private String gxTv_SdtLegajo_Legpromdias ;
   private String gxTv_SdtLegajo_Empnom_Z ;
   private String gxTv_SdtLegajo_Legapellido_Z ;
   private String gxTv_SdtLegajo_Legnombre_Z ;
   private String gxTv_SdtLegajo_Legfotonom_Z ;
   private String gxTv_SdtLegajo_Legnumdoc_Z ;
   private String gxTv_SdtLegajo_Legnacionalidad_Z ;
   private String gxTv_SdtLegajo_Legdomici_Z ;
   private String gxTv_SdtLegajo_Legemail_Z ;
   private String gxTv_SdtLegajo_Legpainom_Z ;
   private String gxTv_SdtLegajo_Legprovnom_Z ;
   private String gxTv_SdtLegajo_Leglocnom_Z ;
   private String gxTv_SdtLegajo_Legtelefono_Z ;
   private String gxTv_SdtLegajo_Megdescrip_Z ;
   private String gxTv_SdtLegajo_Secdescrip_Z ;
   private String gxTv_SdtLegajo_Lpgdescri_Z ;
   private String gxTv_SdtLegajo_Legbandes_Z ;
   private String gxTv_SdtLegajo_Legbansuc_Z ;
   private String gxTv_SdtLegajo_Sindescrip_Z ;
   private String gxTv_SdtLegajo_Legosodes_Z ;
   private String gxTv_SdtLegajo_Osodescrip_Z ;
   private String gxTv_SdtLegajo_Legactdescri_Z ;
   private String gxTv_SdtLegajo_Mprdescrip_Z ;
   private String gxTv_SdtLegajo_Legcuentabanc_Z ;
   private String gxTv_SdtLegajo_Zondescrip_Z ;
   private String gxTv_SdtLegajo_Legcbu_Z ;
   private String gxTv_SdtLegajo_Condidescri_Z ;
   private String gxTv_SdtLegajo_Siniedescri_Z ;
   private String gxTv_SdtLegajo_Legidnomape_Z ;
   private String gxTv_SdtLegajo_Legnomape_Z ;
   private String gxTv_SdtLegajo_Legpromdias_Z ;
   private GXBCLevelCollection<web.SdtLegajo_Salario> gxTv_SdtLegajo_Salario_aux ;
   private GXBCLevelCollection<web.SdtLegajo_Familia> gxTv_SdtLegajo_Familia_aux ;
   private GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> gxTv_SdtLegajo_Tipos_de_trabajo_aux ;
   private GXBCLevelCollection<web.SdtLegajo_Propiedades> gxTv_SdtLegajo_Propiedades_aux ;
   private GXBCLevelCollection<web.SdtLegajo_Salario> gxTv_SdtLegajo_Salario=null ;
   private GXBCLevelCollection<web.SdtLegajo_Familia> gxTv_SdtLegajo_Familia=null ;
   private GXBCLevelCollection<web.SdtLegajo_tipos_de_trabajo> gxTv_SdtLegajo_Tipos_de_trabajo=null ;
   private GXBCLevelCollection<web.SdtLegajo_Propiedades> gxTv_SdtLegajo_Propiedades=null ;
}

