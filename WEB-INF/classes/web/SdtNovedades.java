package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNovedades extends GxSilentTrnSdt
{
   public SdtNovedades( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtNovedades.class));
   }

   public SdtNovedades( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle, context, "SdtNovedades");
      initialize( remoteHandle) ;
   }

   public SdtNovedades( int remoteHandle ,
                        StructSdtNovedades struct )
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
                     int AV6LegNumero ,
                     short AV25AgeOrden )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),Short.valueOf(AV25AgeOrden)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"AgeOrden", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Novedades");
      metadata.set("BT", "AgendaNovedades");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"AgeOrden\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtNovedades_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtNovedades_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtNovedades_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtNovedades_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido") )
            {
               gxTv_SdtNovedades_Legapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre") )
            {
               gxTv_SdtNovedades_Legnombre = oReader.getValue() ;
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
                  gxTv_SdtNovedades_Legfecegreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Legfecegreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeOrden") )
            {
               gxTv_SdtNovedades_Ageorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_SdtNovedades_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_SdtNovedades_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti") )
            {
               gxTv_SdtNovedades_Agecanti = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit") )
            {
               gxTv_SdtNovedades_Agevunit = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte") )
            {
               gxTv_SdtNovedades_Ageimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro") )
            {
               gxTv_SdtNovedades_Ageliqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecDes") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedades_Agefecdes = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Agefecdes = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecHas") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedades_Agefechas = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Agefechas = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLegActivo") )
            {
               gxTv_SdtNovedades_Agelegactivo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId") )
            {
               gxTv_SdtNovedades_Legid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgePrevis") )
            {
               gxTv_SdtNovedades_Ageprevis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgePrevCalc") )
            {
               gxTv_SdtNovedades_Ageprevcalc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCUIL") )
            {
               gxTv_SdtNovedades_Legcuil = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgePerDescrip") )
            {
               gxTv_SdtNovedades_Ageperdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtNovedades_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtNovedades_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtNovedades_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtNovedades_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtNovedades_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtNovedades_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido_Z") )
            {
               gxTv_SdtNovedades_Legapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre_Z") )
            {
               gxTv_SdtNovedades_Legnombre_Z = oReader.getValue() ;
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
                  gxTv_SdtNovedades_Legfecegreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Legfecegreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeOrden_Z") )
            {
               gxTv_SdtNovedades_Ageorden_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo_Z") )
            {
               gxTv_SdtNovedades_Concodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip_Z") )
            {
               gxTv_SdtNovedades_Condescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti_Z") )
            {
               gxTv_SdtNovedades_Agecanti_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit_Z") )
            {
               gxTv_SdtNovedades_Agevunit_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte_Z") )
            {
               gxTv_SdtNovedades_Ageimporte_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro_Z") )
            {
               gxTv_SdtNovedades_Ageliqnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecDes_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedades_Agefecdes_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Agefecdes_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecHas_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedades_Agefechas_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedades_Agefechas_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLegActivo_Z") )
            {
               gxTv_SdtNovedades_Agelegactivo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_Z") )
            {
               gxTv_SdtNovedades_Legid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgePrevCalc_Z") )
            {
               gxTv_SdtNovedades_Ageprevcalc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCUIL_Z") )
            {
               gxTv_SdtNovedades_Legcuil_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgePerDescrip_Z") )
            {
               gxTv_SdtNovedades_Ageperdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecEgreso_N") )
            {
               gxTv_SdtNovedades_Legfecegreso_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti_N") )
            {
               gxTv_SdtNovedades_Agecanti_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit_N") )
            {
               gxTv_SdtNovedades_Agevunit_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte_N") )
            {
               gxTv_SdtNovedades_Ageimporte_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro_N") )
            {
               gxTv_SdtNovedades_Ageliqnro_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecDes_N") )
            {
               gxTv_SdtNovedades_Agefecdes_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecHas_N") )
            {
               gxTv_SdtNovedades_Agefechas_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_N") )
            {
               gxTv_SdtNovedades_Legid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Novedades" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtNovedades_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegApellido", gxTv_SdtNovedades_Legapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNombre", gxTv_SdtNovedades_Legnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecEgreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeOrden", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodigo", gxTv_SdtNovedades_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_SdtNovedades_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeCanti", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Agecanti, 9, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeVUnit", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Agevunit, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Ageimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeLiqNro", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageliqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("AgeFecDes", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("AgeFecHas", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeLegActivo", GXutil.booltostr( gxTv_SdtNovedades_Agelegactivo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegId", gxTv_SdtNovedades_Legid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgePrevis", gxTv_SdtNovedades_Ageprevis);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgePrevCalc", gxTv_SdtNovedades_Ageprevcalc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCUIL", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legcuil, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgePerDescrip", gxTv_SdtNovedades_Ageperdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtNovedades_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtNovedades_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegApellido_Z", gxTv_SdtNovedades_Legapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNombre_Z", gxTv_SdtNovedades_Legnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecEgreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageorden_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodigo_Z", gxTv_SdtNovedades_Concodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConDescrip_Z", gxTv_SdtNovedades_Condescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeCanti_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Agecanti_Z, 9, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeVUnit_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Agevunit_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeImporte_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtNovedades_Ageimporte_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLiqNro_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageliqnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("AgeFecDes_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("AgeFecHas_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLegActivo_Z", GXutil.booltostr( gxTv_SdtNovedades_Agelegactivo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_Z", gxTv_SdtNovedades_Legid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgePrevCalc_Z", gxTv_SdtNovedades_Ageprevcalc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCUIL_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legcuil_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgePerDescrip_Z", gxTv_SdtNovedades_Ageperdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFecEgreso_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legfecegreso_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeCanti_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Agecanti_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeVUnit_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Agevunit_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeImporte_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageimporte_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLiqNro_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Ageliqnro_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeFecDes_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Agefecdes_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeFecHas_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Agefechas_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_N", GXutil.trim( GXutil.str( gxTv_SdtNovedades_Legid_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtNovedades_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtNovedades_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtNovedades_Empnom, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtNovedades_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LegApellido", gxTv_SdtNovedades_Legapellido, false, includeNonInitialized);
      AddObjectProperty("LegNombre", gxTv_SdtNovedades_Legnombre, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecEgreso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegFecEgreso_N", gxTv_SdtNovedades_Legfecegreso_N, false, includeNonInitialized);
      AddObjectProperty("AgeOrden", gxTv_SdtNovedades_Ageorden, false, includeNonInitialized);
      AddObjectProperty("ConCodigo", gxTv_SdtNovedades_Concodigo, false, includeNonInitialized);
      AddObjectProperty("ConDescrip", gxTv_SdtNovedades_Condescrip, false, includeNonInitialized);
      AddObjectProperty("AgeCanti", gxTv_SdtNovedades_Agecanti, false, includeNonInitialized);
      AddObjectProperty("AgeCanti_N", gxTv_SdtNovedades_Agecanti_N, false, includeNonInitialized);
      AddObjectProperty("AgeVUnit", gxTv_SdtNovedades_Agevunit, false, includeNonInitialized);
      AddObjectProperty("AgeVUnit_N", gxTv_SdtNovedades_Agevunit_N, false, includeNonInitialized);
      AddObjectProperty("AgeImporte", gxTv_SdtNovedades_Ageimporte, false, includeNonInitialized);
      AddObjectProperty("AgeImporte_N", gxTv_SdtNovedades_Ageimporte_N, false, includeNonInitialized);
      AddObjectProperty("AgeLiqNro", gxTv_SdtNovedades_Ageliqnro, false, includeNonInitialized);
      AddObjectProperty("AgeLiqNro_N", gxTv_SdtNovedades_Ageliqnro_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("AgeFecDes", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("AgeFecDes_N", gxTv_SdtNovedades_Agefecdes_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("AgeFecHas", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("AgeFecHas_N", gxTv_SdtNovedades_Agefechas_N, false, includeNonInitialized);
      AddObjectProperty("AgeLegActivo", gxTv_SdtNovedades_Agelegactivo, false, includeNonInitialized);
      AddObjectProperty("LegId", gxTv_SdtNovedades_Legid, false, includeNonInitialized);
      AddObjectProperty("LegId_N", gxTv_SdtNovedades_Legid_N, false, includeNonInitialized);
      AddObjectProperty("AgePrevis", gxTv_SdtNovedades_Ageprevis, false, includeNonInitialized);
      AddObjectProperty("AgePrevCalc", gxTv_SdtNovedades_Ageprevcalc, false, includeNonInitialized);
      AddObjectProperty("LegCUIL", gxTv_SdtNovedades_Legcuil, false, includeNonInitialized);
      AddObjectProperty("AgePerDescrip", gxTv_SdtNovedades_Ageperdescrip, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtNovedades_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtNovedades_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtNovedades_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtNovedades_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtNovedades_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtNovedades_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LegApellido_Z", gxTv_SdtNovedades_Legapellido_Z, false, includeNonInitialized);
         AddObjectProperty("LegNombre_Z", gxTv_SdtNovedades_Legnombre_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecEgreso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("AgeOrden_Z", gxTv_SdtNovedades_Ageorden_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodigo_Z", gxTv_SdtNovedades_Concodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConDescrip_Z", gxTv_SdtNovedades_Condescrip_Z, false, includeNonInitialized);
         AddObjectProperty("AgeCanti_Z", gxTv_SdtNovedades_Agecanti_Z, false, includeNonInitialized);
         AddObjectProperty("AgeVUnit_Z", gxTv_SdtNovedades_Agevunit_Z, false, includeNonInitialized);
         AddObjectProperty("AgeImporte_Z", gxTv_SdtNovedades_Ageimporte_Z, false, includeNonInitialized);
         AddObjectProperty("AgeLiqNro_Z", gxTv_SdtNovedades_Ageliqnro_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("AgeFecDes_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("AgeFecHas_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("AgeLegActivo_Z", gxTv_SdtNovedades_Agelegactivo_Z, false, includeNonInitialized);
         AddObjectProperty("LegId_Z", gxTv_SdtNovedades_Legid_Z, false, includeNonInitialized);
         AddObjectProperty("AgePrevCalc_Z", gxTv_SdtNovedades_Ageprevcalc_Z, false, includeNonInitialized);
         AddObjectProperty("LegCUIL_Z", gxTv_SdtNovedades_Legcuil_Z, false, includeNonInitialized);
         AddObjectProperty("AgePerDescrip_Z", gxTv_SdtNovedades_Ageperdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegFecEgreso_N", gxTv_SdtNovedades_Legfecegreso_N, false, includeNonInitialized);
         AddObjectProperty("AgeCanti_N", gxTv_SdtNovedades_Agecanti_N, false, includeNonInitialized);
         AddObjectProperty("AgeVUnit_N", gxTv_SdtNovedades_Agevunit_N, false, includeNonInitialized);
         AddObjectProperty("AgeImporte_N", gxTv_SdtNovedades_Ageimporte_N, false, includeNonInitialized);
         AddObjectProperty("AgeLiqNro_N", gxTv_SdtNovedades_Ageliqnro_N, false, includeNonInitialized);
         AddObjectProperty("AgeFecDes_N", gxTv_SdtNovedades_Agefecdes_N, false, includeNonInitialized);
         AddObjectProperty("AgeFecHas_N", gxTv_SdtNovedades_Agefechas_N, false, includeNonInitialized);
         AddObjectProperty("LegId_N", gxTv_SdtNovedades_Legid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtNovedades sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Clicod = sdt.getgxTv_SdtNovedades_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Empcod = sdt.getgxTv_SdtNovedades_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Empnom = sdt.getgxTv_SdtNovedades_Empnom() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legnumero = sdt.getgxTv_SdtNovedades_Legnumero() ;
      }
      if ( sdt.IsDirty("LegApellido") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legapellido = sdt.getgxTv_SdtNovedades_Legapellido() ;
      }
      if ( sdt.IsDirty("LegNombre") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legnombre = sdt.getgxTv_SdtNovedades_Legnombre() ;
      }
      if ( sdt.IsDirty("LegFecEgreso") )
      {
         gxTv_SdtNovedades_Legfecegreso_N = sdt.getgxTv_SdtNovedades_Legfecegreso_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legfecegreso = sdt.getgxTv_SdtNovedades_Legfecegreso() ;
      }
      if ( sdt.IsDirty("AgeOrden") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageorden = sdt.getgxTv_SdtNovedades_Ageorden() ;
      }
      if ( sdt.IsDirty("ConCodigo") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Concodigo = sdt.getgxTv_SdtNovedades_Concodigo() ;
      }
      if ( sdt.IsDirty("ConDescrip") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Condescrip = sdt.getgxTv_SdtNovedades_Condescrip() ;
      }
      if ( sdt.IsDirty("AgeCanti") )
      {
         gxTv_SdtNovedades_Agecanti_N = sdt.getgxTv_SdtNovedades_Agecanti_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Agecanti = sdt.getgxTv_SdtNovedades_Agecanti() ;
      }
      if ( sdt.IsDirty("AgeVUnit") )
      {
         gxTv_SdtNovedades_Agevunit_N = sdt.getgxTv_SdtNovedades_Agevunit_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Agevunit = sdt.getgxTv_SdtNovedades_Agevunit() ;
      }
      if ( sdt.IsDirty("AgeImporte") )
      {
         gxTv_SdtNovedades_Ageimporte_N = sdt.getgxTv_SdtNovedades_Ageimporte_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageimporte = sdt.getgxTv_SdtNovedades_Ageimporte() ;
      }
      if ( sdt.IsDirty("AgeLiqNro") )
      {
         gxTv_SdtNovedades_Ageliqnro_N = sdt.getgxTv_SdtNovedades_Ageliqnro_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageliqnro = sdt.getgxTv_SdtNovedades_Ageliqnro() ;
      }
      if ( sdt.IsDirty("AgeFecDes") )
      {
         gxTv_SdtNovedades_Agefecdes_N = sdt.getgxTv_SdtNovedades_Agefecdes_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Agefecdes = sdt.getgxTv_SdtNovedades_Agefecdes() ;
      }
      if ( sdt.IsDirty("AgeFecHas") )
      {
         gxTv_SdtNovedades_Agefechas_N = sdt.getgxTv_SdtNovedades_Agefechas_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Agefechas = sdt.getgxTv_SdtNovedades_Agefechas() ;
      }
      if ( sdt.IsDirty("AgeLegActivo") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Agelegactivo = sdt.getgxTv_SdtNovedades_Agelegactivo() ;
      }
      if ( sdt.IsDirty("LegId") )
      {
         gxTv_SdtNovedades_Legid_N = sdt.getgxTv_SdtNovedades_Legid_N() ;
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legid = sdt.getgxTv_SdtNovedades_Legid() ;
      }
      if ( sdt.IsDirty("AgePrevis") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageprevis = sdt.getgxTv_SdtNovedades_Ageprevis() ;
      }
      if ( sdt.IsDirty("AgePrevCalc") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageprevcalc = sdt.getgxTv_SdtNovedades_Ageprevcalc() ;
      }
      if ( sdt.IsDirty("LegCUIL") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Legcuil = sdt.getgxTv_SdtNovedades_Legcuil() ;
      }
      if ( sdt.IsDirty("AgePerDescrip") )
      {
         gxTv_SdtNovedades_N = (byte)(0) ;
         gxTv_SdtNovedades_Ageperdescrip = sdt.getgxTv_SdtNovedades_Ageperdescrip() ;
      }
   }

   public int getgxTv_SdtNovedades_Clicod( )
   {
      return gxTv_SdtNovedades_Clicod ;
   }

   public void setgxTv_SdtNovedades_Clicod( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      if ( gxTv_SdtNovedades_Clicod != value )
      {
         gxTv_SdtNovedades_Mode = "INS" ;
         this.setgxTv_SdtNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageliqnro_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageprevcalc_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legcuil_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageperdescrip_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtNovedades_Clicod = value ;
   }

   public short getgxTv_SdtNovedades_Empcod( )
   {
      return gxTv_SdtNovedades_Empcod ;
   }

   public void setgxTv_SdtNovedades_Empcod( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      if ( gxTv_SdtNovedades_Empcod != value )
      {
         gxTv_SdtNovedades_Mode = "INS" ;
         this.setgxTv_SdtNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageliqnro_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageprevcalc_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legcuil_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageperdescrip_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtNovedades_Empcod = value ;
   }

   public String getgxTv_SdtNovedades_Empnom( )
   {
      return gxTv_SdtNovedades_Empnom ;
   }

   public void setgxTv_SdtNovedades_Empnom( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtNovedades_Empnom = value ;
   }

   public int getgxTv_SdtNovedades_Legnumero( )
   {
      return gxTv_SdtNovedades_Legnumero ;
   }

   public void setgxTv_SdtNovedades_Legnumero( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      if ( gxTv_SdtNovedades_Legnumero != value )
      {
         gxTv_SdtNovedades_Mode = "INS" ;
         this.setgxTv_SdtNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageliqnro_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageprevcalc_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legcuil_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageperdescrip_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtNovedades_Legnumero = value ;
   }

   public String getgxTv_SdtNovedades_Legapellido( )
   {
      return gxTv_SdtNovedades_Legapellido ;
   }

   public void setgxTv_SdtNovedades_Legapellido( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legapellido");
      gxTv_SdtNovedades_Legapellido = value ;
   }

   public String getgxTv_SdtNovedades_Legnombre( )
   {
      return gxTv_SdtNovedades_Legnombre ;
   }

   public void setgxTv_SdtNovedades_Legnombre( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legnombre");
      gxTv_SdtNovedades_Legnombre = value ;
   }

   public java.util.Date getgxTv_SdtNovedades_Legfecegreso( )
   {
      return gxTv_SdtNovedades_Legfecegreso ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso( java.util.Date value )
   {
      gxTv_SdtNovedades_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso");
      gxTv_SdtNovedades_Legfecegreso = value ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso_SetNull( )
   {
      gxTv_SdtNovedades_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtNovedades_Legfecegreso = GXutil.nullDate() ;
      SetDirty("Legfecegreso");
   }

   public boolean getgxTv_SdtNovedades_Legfecegreso_IsNull( )
   {
      return (gxTv_SdtNovedades_Legfecegreso_N==1) ;
   }

   public short getgxTv_SdtNovedades_Ageorden( )
   {
      return gxTv_SdtNovedades_Ageorden ;
   }

   public void setgxTv_SdtNovedades_Ageorden( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      if ( gxTv_SdtNovedades_Ageorden != value )
      {
         gxTv_SdtNovedades_Mode = "INS" ;
         this.setgxTv_SdtNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageliqnro_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageprevcalc_Z_SetNull( );
         this.setgxTv_SdtNovedades_Legcuil_Z_SetNull( );
         this.setgxTv_SdtNovedades_Ageperdescrip_Z_SetNull( );
      }
      SetDirty("Ageorden");
      gxTv_SdtNovedades_Ageorden = value ;
   }

   public String getgxTv_SdtNovedades_Concodigo( )
   {
      return gxTv_SdtNovedades_Concodigo ;
   }

   public void setgxTv_SdtNovedades_Concodigo( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Concodigo");
      gxTv_SdtNovedades_Concodigo = value ;
   }

   public String getgxTv_SdtNovedades_Condescrip( )
   {
      return gxTv_SdtNovedades_Condescrip ;
   }

   public void setgxTv_SdtNovedades_Condescrip( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Condescrip");
      gxTv_SdtNovedades_Condescrip = value ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Agecanti( )
   {
      return gxTv_SdtNovedades_Agecanti ;
   }

   public void setgxTv_SdtNovedades_Agecanti( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Agecanti_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agecanti");
      gxTv_SdtNovedades_Agecanti = value ;
   }

   public void setgxTv_SdtNovedades_Agecanti_SetNull( )
   {
      gxTv_SdtNovedades_Agecanti_N = (byte)(1) ;
      gxTv_SdtNovedades_Agecanti = DecimalUtil.ZERO ;
      SetDirty("Agecanti");
   }

   public boolean getgxTv_SdtNovedades_Agecanti_IsNull( )
   {
      return (gxTv_SdtNovedades_Agecanti_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Agevunit( )
   {
      return gxTv_SdtNovedades_Agevunit ;
   }

   public void setgxTv_SdtNovedades_Agevunit( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Agevunit_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agevunit");
      gxTv_SdtNovedades_Agevunit = value ;
   }

   public void setgxTv_SdtNovedades_Agevunit_SetNull( )
   {
      gxTv_SdtNovedades_Agevunit_N = (byte)(1) ;
      gxTv_SdtNovedades_Agevunit = DecimalUtil.ZERO ;
      SetDirty("Agevunit");
   }

   public boolean getgxTv_SdtNovedades_Agevunit_IsNull( )
   {
      return (gxTv_SdtNovedades_Agevunit_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Ageimporte( )
   {
      return gxTv_SdtNovedades_Ageimporte ;
   }

   public void setgxTv_SdtNovedades_Ageimporte( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Ageimporte_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte");
      gxTv_SdtNovedades_Ageimporte = value ;
   }

   public void setgxTv_SdtNovedades_Ageimporte_SetNull( )
   {
      gxTv_SdtNovedades_Ageimporte_N = (byte)(1) ;
      gxTv_SdtNovedades_Ageimporte = DecimalUtil.ZERO ;
      SetDirty("Ageimporte");
   }

   public boolean getgxTv_SdtNovedades_Ageimporte_IsNull( )
   {
      return (gxTv_SdtNovedades_Ageimporte_N==1) ;
   }

   public int getgxTv_SdtNovedades_Ageliqnro( )
   {
      return gxTv_SdtNovedades_Ageliqnro ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro( int value )
   {
      gxTv_SdtNovedades_Ageliqnro_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro");
      gxTv_SdtNovedades_Ageliqnro = value ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro_SetNull( )
   {
      gxTv_SdtNovedades_Ageliqnro_N = (byte)(1) ;
      gxTv_SdtNovedades_Ageliqnro = 0 ;
      SetDirty("Ageliqnro");
   }

   public boolean getgxTv_SdtNovedades_Ageliqnro_IsNull( )
   {
      return (gxTv_SdtNovedades_Ageliqnro_N==1) ;
   }

   public java.util.Date getgxTv_SdtNovedades_Agefecdes( )
   {
      return gxTv_SdtNovedades_Agefecdes ;
   }

   public void setgxTv_SdtNovedades_Agefecdes( java.util.Date value )
   {
      gxTv_SdtNovedades_Agefecdes_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes");
      gxTv_SdtNovedades_Agefecdes = value ;
   }

   public void setgxTv_SdtNovedades_Agefecdes_SetNull( )
   {
      gxTv_SdtNovedades_Agefecdes_N = (byte)(1) ;
      gxTv_SdtNovedades_Agefecdes = GXutil.nullDate() ;
      SetDirty("Agefecdes");
   }

   public boolean getgxTv_SdtNovedades_Agefecdes_IsNull( )
   {
      return (gxTv_SdtNovedades_Agefecdes_N==1) ;
   }

   public java.util.Date getgxTv_SdtNovedades_Agefechas( )
   {
      return gxTv_SdtNovedades_Agefechas ;
   }

   public void setgxTv_SdtNovedades_Agefechas( java.util.Date value )
   {
      gxTv_SdtNovedades_Agefechas_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefechas");
      gxTv_SdtNovedades_Agefechas = value ;
   }

   public void setgxTv_SdtNovedades_Agefechas_SetNull( )
   {
      gxTv_SdtNovedades_Agefechas_N = (byte)(1) ;
      gxTv_SdtNovedades_Agefechas = GXutil.nullDate() ;
      SetDirty("Agefechas");
   }

   public boolean getgxTv_SdtNovedades_Agefechas_IsNull( )
   {
      return (gxTv_SdtNovedades_Agefechas_N==1) ;
   }

   public boolean getgxTv_SdtNovedades_Agelegactivo( )
   {
      return gxTv_SdtNovedades_Agelegactivo ;
   }

   public void setgxTv_SdtNovedades_Agelegactivo( boolean value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agelegactivo");
      gxTv_SdtNovedades_Agelegactivo = value ;
   }

   public void setgxTv_SdtNovedades_Agelegactivo_SetNull( )
   {
      gxTv_SdtNovedades_Agelegactivo = false ;
      SetDirty("Agelegactivo");
   }

   public boolean getgxTv_SdtNovedades_Agelegactivo_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Legid( )
   {
      return gxTv_SdtNovedades_Legid ;
   }

   public void setgxTv_SdtNovedades_Legid( String value )
   {
      gxTv_SdtNovedades_Legid_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legid");
      gxTv_SdtNovedades_Legid = value ;
   }

   public void setgxTv_SdtNovedades_Legid_SetNull( )
   {
      gxTv_SdtNovedades_Legid_N = (byte)(1) ;
      gxTv_SdtNovedades_Legid = "" ;
      SetDirty("Legid");
   }

   public boolean getgxTv_SdtNovedades_Legid_IsNull( )
   {
      return (gxTv_SdtNovedades_Legid_N==1) ;
   }

   public String getgxTv_SdtNovedades_Ageprevis( )
   {
      return gxTv_SdtNovedades_Ageprevis ;
   }

   public void setgxTv_SdtNovedades_Ageprevis( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageprevis");
      gxTv_SdtNovedades_Ageprevis = value ;
   }

   public void setgxTv_SdtNovedades_Ageprevis_SetNull( )
   {
      gxTv_SdtNovedades_Ageprevis = "" ;
      SetDirty("Ageprevis");
   }

   public boolean getgxTv_SdtNovedades_Ageprevis_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Ageprevcalc( )
   {
      return gxTv_SdtNovedades_Ageprevcalc ;
   }

   public void setgxTv_SdtNovedades_Ageprevcalc( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageprevcalc");
      gxTv_SdtNovedades_Ageprevcalc = value ;
   }

   public void setgxTv_SdtNovedades_Ageprevcalc_SetNull( )
   {
      gxTv_SdtNovedades_Ageprevcalc = "" ;
      SetDirty("Ageprevcalc");
   }

   public boolean getgxTv_SdtNovedades_Ageprevcalc_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtNovedades_Legcuil( )
   {
      return gxTv_SdtNovedades_Legcuil ;
   }

   public void setgxTv_SdtNovedades_Legcuil( long value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legcuil");
      gxTv_SdtNovedades_Legcuil = value ;
   }

   public String getgxTv_SdtNovedades_Ageperdescrip( )
   {
      return gxTv_SdtNovedades_Ageperdescrip ;
   }

   public void setgxTv_SdtNovedades_Ageperdescrip( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageperdescrip");
      gxTv_SdtNovedades_Ageperdescrip = value ;
   }

   public String getgxTv_SdtNovedades_Mode( )
   {
      return gxTv_SdtNovedades_Mode ;
   }

   public void setgxTv_SdtNovedades_Mode( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtNovedades_Mode = value ;
   }

   public void setgxTv_SdtNovedades_Mode_SetNull( )
   {
      gxTv_SdtNovedades_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtNovedades_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedades_Initialized( )
   {
      return gxTv_SdtNovedades_Initialized ;
   }

   public void setgxTv_SdtNovedades_Initialized( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtNovedades_Initialized = value ;
   }

   public void setgxTv_SdtNovedades_Initialized_SetNull( )
   {
      gxTv_SdtNovedades_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtNovedades_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtNovedades_Clicod_Z( )
   {
      return gxTv_SdtNovedades_Clicod_Z ;
   }

   public void setgxTv_SdtNovedades_Clicod_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtNovedades_Clicod_Z = value ;
   }

   public void setgxTv_SdtNovedades_Clicod_Z_SetNull( )
   {
      gxTv_SdtNovedades_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtNovedades_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedades_Empcod_Z( )
   {
      return gxTv_SdtNovedades_Empcod_Z ;
   }

   public void setgxTv_SdtNovedades_Empcod_Z( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtNovedades_Empcod_Z = value ;
   }

   public void setgxTv_SdtNovedades_Empcod_Z_SetNull( )
   {
      gxTv_SdtNovedades_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtNovedades_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Empnom_Z( )
   {
      return gxTv_SdtNovedades_Empnom_Z ;
   }

   public void setgxTv_SdtNovedades_Empnom_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtNovedades_Empnom_Z = value ;
   }

   public void setgxTv_SdtNovedades_Empnom_Z_SetNull( )
   {
      gxTv_SdtNovedades_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtNovedades_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtNovedades_Legnumero_Z( )
   {
      return gxTv_SdtNovedades_Legnumero_Z ;
   }

   public void setgxTv_SdtNovedades_Legnumero_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtNovedades_Legnumero_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legnumero_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtNovedades_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Legapellido_Z( )
   {
      return gxTv_SdtNovedades_Legapellido_Z ;
   }

   public void setgxTv_SdtNovedades_Legapellido_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legapellido_Z");
      gxTv_SdtNovedades_Legapellido_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legapellido_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legapellido_Z = "" ;
      SetDirty("Legapellido_Z");
   }

   public boolean getgxTv_SdtNovedades_Legapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Legnombre_Z( )
   {
      return gxTv_SdtNovedades_Legnombre_Z ;
   }

   public void setgxTv_SdtNovedades_Legnombre_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legnombre_Z");
      gxTv_SdtNovedades_Legnombre_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legnombre_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legnombre_Z = "" ;
      SetDirty("Legnombre_Z");
   }

   public boolean getgxTv_SdtNovedades_Legnombre_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtNovedades_Legfecegreso_Z( )
   {
      return gxTv_SdtNovedades_Legfecegreso_Z ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso_Z");
      gxTv_SdtNovedades_Legfecegreso_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legfecegreso_Z = GXutil.nullDate() ;
      SetDirty("Legfecegreso_Z");
   }

   public boolean getgxTv_SdtNovedades_Legfecegreso_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedades_Ageorden_Z( )
   {
      return gxTv_SdtNovedades_Ageorden_Z ;
   }

   public void setgxTv_SdtNovedades_Ageorden_Z( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageorden_Z");
      gxTv_SdtNovedades_Ageorden_Z = value ;
   }

   public void setgxTv_SdtNovedades_Ageorden_Z_SetNull( )
   {
      gxTv_SdtNovedades_Ageorden_Z = (short)(0) ;
      SetDirty("Ageorden_Z");
   }

   public boolean getgxTv_SdtNovedades_Ageorden_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Concodigo_Z( )
   {
      return gxTv_SdtNovedades_Concodigo_Z ;
   }

   public void setgxTv_SdtNovedades_Concodigo_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Concodigo_Z");
      gxTv_SdtNovedades_Concodigo_Z = value ;
   }

   public void setgxTv_SdtNovedades_Concodigo_Z_SetNull( )
   {
      gxTv_SdtNovedades_Concodigo_Z = "" ;
      SetDirty("Concodigo_Z");
   }

   public boolean getgxTv_SdtNovedades_Concodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Condescrip_Z( )
   {
      return gxTv_SdtNovedades_Condescrip_Z ;
   }

   public void setgxTv_SdtNovedades_Condescrip_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Condescrip_Z");
      gxTv_SdtNovedades_Condescrip_Z = value ;
   }

   public void setgxTv_SdtNovedades_Condescrip_Z_SetNull( )
   {
      gxTv_SdtNovedades_Condescrip_Z = "" ;
      SetDirty("Condescrip_Z");
   }

   public boolean getgxTv_SdtNovedades_Condescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Agecanti_Z( )
   {
      return gxTv_SdtNovedades_Agecanti_Z ;
   }

   public void setgxTv_SdtNovedades_Agecanti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agecanti_Z");
      gxTv_SdtNovedades_Agecanti_Z = value ;
   }

   public void setgxTv_SdtNovedades_Agecanti_Z_SetNull( )
   {
      gxTv_SdtNovedades_Agecanti_Z = DecimalUtil.ZERO ;
      SetDirty("Agecanti_Z");
   }

   public boolean getgxTv_SdtNovedades_Agecanti_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Agevunit_Z( )
   {
      return gxTv_SdtNovedades_Agevunit_Z ;
   }

   public void setgxTv_SdtNovedades_Agevunit_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agevunit_Z");
      gxTv_SdtNovedades_Agevunit_Z = value ;
   }

   public void setgxTv_SdtNovedades_Agevunit_Z_SetNull( )
   {
      gxTv_SdtNovedades_Agevunit_Z = DecimalUtil.ZERO ;
      SetDirty("Agevunit_Z");
   }

   public boolean getgxTv_SdtNovedades_Agevunit_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtNovedades_Ageimporte_Z( )
   {
      return gxTv_SdtNovedades_Ageimporte_Z ;
   }

   public void setgxTv_SdtNovedades_Ageimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte_Z");
      gxTv_SdtNovedades_Ageimporte_Z = value ;
   }

   public void setgxTv_SdtNovedades_Ageimporte_Z_SetNull( )
   {
      gxTv_SdtNovedades_Ageimporte_Z = DecimalUtil.ZERO ;
      SetDirty("Ageimporte_Z");
   }

   public boolean getgxTv_SdtNovedades_Ageimporte_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtNovedades_Ageliqnro_Z( )
   {
      return gxTv_SdtNovedades_Ageliqnro_Z ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro_Z");
      gxTv_SdtNovedades_Ageliqnro_Z = value ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro_Z_SetNull( )
   {
      gxTv_SdtNovedades_Ageliqnro_Z = 0 ;
      SetDirty("Ageliqnro_Z");
   }

   public boolean getgxTv_SdtNovedades_Ageliqnro_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtNovedades_Agefecdes_Z( )
   {
      return gxTv_SdtNovedades_Agefecdes_Z ;
   }

   public void setgxTv_SdtNovedades_Agefecdes_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes_Z");
      gxTv_SdtNovedades_Agefecdes_Z = value ;
   }

   public void setgxTv_SdtNovedades_Agefecdes_Z_SetNull( )
   {
      gxTv_SdtNovedades_Agefecdes_Z = GXutil.nullDate() ;
      SetDirty("Agefecdes_Z");
   }

   public boolean getgxTv_SdtNovedades_Agefecdes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtNovedades_Agefechas_Z( )
   {
      return gxTv_SdtNovedades_Agefechas_Z ;
   }

   public void setgxTv_SdtNovedades_Agefechas_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefechas_Z");
      gxTv_SdtNovedades_Agefechas_Z = value ;
   }

   public void setgxTv_SdtNovedades_Agefechas_Z_SetNull( )
   {
      gxTv_SdtNovedades_Agefechas_Z = GXutil.nullDate() ;
      SetDirty("Agefechas_Z");
   }

   public boolean getgxTv_SdtNovedades_Agefechas_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtNovedades_Agelegactivo_Z( )
   {
      return gxTv_SdtNovedades_Agelegactivo_Z ;
   }

   public void setgxTv_SdtNovedades_Agelegactivo_Z( boolean value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agelegactivo_Z");
      gxTv_SdtNovedades_Agelegactivo_Z = value ;
   }

   public void setgxTv_SdtNovedades_Agelegactivo_Z_SetNull( )
   {
      gxTv_SdtNovedades_Agelegactivo_Z = false ;
      SetDirty("Agelegactivo_Z");
   }

   public boolean getgxTv_SdtNovedades_Agelegactivo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Legid_Z( )
   {
      return gxTv_SdtNovedades_Legid_Z ;
   }

   public void setgxTv_SdtNovedades_Legid_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legid_Z");
      gxTv_SdtNovedades_Legid_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legid_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legid_Z = "" ;
      SetDirty("Legid_Z");
   }

   public boolean getgxTv_SdtNovedades_Legid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Ageprevcalc_Z( )
   {
      return gxTv_SdtNovedades_Ageprevcalc_Z ;
   }

   public void setgxTv_SdtNovedades_Ageprevcalc_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageprevcalc_Z");
      gxTv_SdtNovedades_Ageprevcalc_Z = value ;
   }

   public void setgxTv_SdtNovedades_Ageprevcalc_Z_SetNull( )
   {
      gxTv_SdtNovedades_Ageprevcalc_Z = "" ;
      SetDirty("Ageprevcalc_Z");
   }

   public boolean getgxTv_SdtNovedades_Ageprevcalc_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtNovedades_Legcuil_Z( )
   {
      return gxTv_SdtNovedades_Legcuil_Z ;
   }

   public void setgxTv_SdtNovedades_Legcuil_Z( long value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legcuil_Z");
      gxTv_SdtNovedades_Legcuil_Z = value ;
   }

   public void setgxTv_SdtNovedades_Legcuil_Z_SetNull( )
   {
      gxTv_SdtNovedades_Legcuil_Z = 0 ;
      SetDirty("Legcuil_Z");
   }

   public boolean getgxTv_SdtNovedades_Legcuil_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedades_Ageperdescrip_Z( )
   {
      return gxTv_SdtNovedades_Ageperdescrip_Z ;
   }

   public void setgxTv_SdtNovedades_Ageperdescrip_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageperdescrip_Z");
      gxTv_SdtNovedades_Ageperdescrip_Z = value ;
   }

   public void setgxTv_SdtNovedades_Ageperdescrip_Z_SetNull( )
   {
      gxTv_SdtNovedades_Ageperdescrip_Z = "" ;
      SetDirty("Ageperdescrip_Z");
   }

   public boolean getgxTv_SdtNovedades_Ageperdescrip_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Legfecegreso_N( )
   {
      return gxTv_SdtNovedades_Legfecegreso_N ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
      gxTv_SdtNovedades_Legfecegreso_N = value ;
   }

   public void setgxTv_SdtNovedades_Legfecegreso_N_SetNull( )
   {
      gxTv_SdtNovedades_Legfecegreso_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
   }

   public boolean getgxTv_SdtNovedades_Legfecegreso_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Agecanti_N( )
   {
      return gxTv_SdtNovedades_Agecanti_N ;
   }

   public void setgxTv_SdtNovedades_Agecanti_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agecanti_N");
      gxTv_SdtNovedades_Agecanti_N = value ;
   }

   public void setgxTv_SdtNovedades_Agecanti_N_SetNull( )
   {
      gxTv_SdtNovedades_Agecanti_N = (byte)(0) ;
      SetDirty("Agecanti_N");
   }

   public boolean getgxTv_SdtNovedades_Agecanti_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Agevunit_N( )
   {
      return gxTv_SdtNovedades_Agevunit_N ;
   }

   public void setgxTv_SdtNovedades_Agevunit_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agevunit_N");
      gxTv_SdtNovedades_Agevunit_N = value ;
   }

   public void setgxTv_SdtNovedades_Agevunit_N_SetNull( )
   {
      gxTv_SdtNovedades_Agevunit_N = (byte)(0) ;
      SetDirty("Agevunit_N");
   }

   public boolean getgxTv_SdtNovedades_Agevunit_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Ageimporte_N( )
   {
      return gxTv_SdtNovedades_Ageimporte_N ;
   }

   public void setgxTv_SdtNovedades_Ageimporte_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte_N");
      gxTv_SdtNovedades_Ageimporte_N = value ;
   }

   public void setgxTv_SdtNovedades_Ageimporte_N_SetNull( )
   {
      gxTv_SdtNovedades_Ageimporte_N = (byte)(0) ;
      SetDirty("Ageimporte_N");
   }

   public boolean getgxTv_SdtNovedades_Ageimporte_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Ageliqnro_N( )
   {
      return gxTv_SdtNovedades_Ageliqnro_N ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro_N");
      gxTv_SdtNovedades_Ageliqnro_N = value ;
   }

   public void setgxTv_SdtNovedades_Ageliqnro_N_SetNull( )
   {
      gxTv_SdtNovedades_Ageliqnro_N = (byte)(0) ;
      SetDirty("Ageliqnro_N");
   }

   public boolean getgxTv_SdtNovedades_Ageliqnro_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Agefecdes_N( )
   {
      return gxTv_SdtNovedades_Agefecdes_N ;
   }

   public void setgxTv_SdtNovedades_Agefecdes_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes_N");
      gxTv_SdtNovedades_Agefecdes_N = value ;
   }

   public void setgxTv_SdtNovedades_Agefecdes_N_SetNull( )
   {
      gxTv_SdtNovedades_Agefecdes_N = (byte)(0) ;
      SetDirty("Agefecdes_N");
   }

   public boolean getgxTv_SdtNovedades_Agefecdes_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Agefechas_N( )
   {
      return gxTv_SdtNovedades_Agefechas_N ;
   }

   public void setgxTv_SdtNovedades_Agefechas_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Agefechas_N");
      gxTv_SdtNovedades_Agefechas_N = value ;
   }

   public void setgxTv_SdtNovedades_Agefechas_N_SetNull( )
   {
      gxTv_SdtNovedades_Agefechas_N = (byte)(0) ;
      SetDirty("Agefechas_N");
   }

   public boolean getgxTv_SdtNovedades_Agefechas_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedades_Legid_N( )
   {
      return gxTv_SdtNovedades_Legid_N ;
   }

   public void setgxTv_SdtNovedades_Legid_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      SetDirty("Legid_N");
      gxTv_SdtNovedades_Legid_N = value ;
   }

   public void setgxTv_SdtNovedades_Legid_N_SetNull( )
   {
      gxTv_SdtNovedades_Legid_N = (byte)(0) ;
      SetDirty("Legid_N");
   }

   public boolean getgxTv_SdtNovedades_Legid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.novedades_bc obj;
      obj = new web.novedades_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtNovedades_N = (byte)(1) ;
      gxTv_SdtNovedades_Empnom = "" ;
      gxTv_SdtNovedades_Legapellido = "" ;
      gxTv_SdtNovedades_Legnombre = "" ;
      gxTv_SdtNovedades_Legfecegreso = GXutil.nullDate() ;
      gxTv_SdtNovedades_Concodigo = "" ;
      gxTv_SdtNovedades_Condescrip = "" ;
      gxTv_SdtNovedades_Agecanti = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Agevunit = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Ageimporte = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Agefecdes = GXutil.nullDate() ;
      gxTv_SdtNovedades_Agefechas = GXutil.nullDate() ;
      gxTv_SdtNovedades_Legid = "" ;
      gxTv_SdtNovedades_Ageprevis = "" ;
      gxTv_SdtNovedades_Ageprevcalc = "" ;
      gxTv_SdtNovedades_Ageperdescrip = "" ;
      gxTv_SdtNovedades_Mode = "" ;
      gxTv_SdtNovedades_Empnom_Z = "" ;
      gxTv_SdtNovedades_Legapellido_Z = "" ;
      gxTv_SdtNovedades_Legnombre_Z = "" ;
      gxTv_SdtNovedades_Legfecegreso_Z = GXutil.nullDate() ;
      gxTv_SdtNovedades_Concodigo_Z = "" ;
      gxTv_SdtNovedades_Condescrip_Z = "" ;
      gxTv_SdtNovedades_Agecanti_Z = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Agevunit_Z = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Ageimporte_Z = DecimalUtil.ZERO ;
      gxTv_SdtNovedades_Agefecdes_Z = GXutil.nullDate() ;
      gxTv_SdtNovedades_Agefechas_Z = GXutil.nullDate() ;
      gxTv_SdtNovedades_Legid_Z = "" ;
      gxTv_SdtNovedades_Ageprevcalc_Z = "" ;
      gxTv_SdtNovedades_Ageperdescrip_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNovedades_N ;
   }

   public web.SdtNovedades Clone( )
   {
      web.SdtNovedades sdt;
      web.novedades_bc obj;
      sdt = (web.SdtNovedades)(clone()) ;
      obj = (web.novedades_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtNovedades struct )
   {
      setgxTv_SdtNovedades_Clicod(struct.getClicod());
      setgxTv_SdtNovedades_Empcod(struct.getEmpcod());
      setgxTv_SdtNovedades_Empnom(struct.getEmpnom());
      setgxTv_SdtNovedades_Legnumero(struct.getLegnumero());
      setgxTv_SdtNovedades_Legapellido(struct.getLegapellido());
      setgxTv_SdtNovedades_Legnombre(struct.getLegnombre());
      setgxTv_SdtNovedades_Legfecegreso(struct.getLegfecegreso());
      setgxTv_SdtNovedades_Ageorden(struct.getAgeorden());
      setgxTv_SdtNovedades_Concodigo(struct.getConcodigo());
      setgxTv_SdtNovedades_Condescrip(struct.getCondescrip());
      setgxTv_SdtNovedades_Agecanti(struct.getAgecanti());
      setgxTv_SdtNovedades_Agevunit(struct.getAgevunit());
      setgxTv_SdtNovedades_Ageimporte(struct.getAgeimporte());
      setgxTv_SdtNovedades_Ageliqnro(struct.getAgeliqnro());
      setgxTv_SdtNovedades_Agefecdes(struct.getAgefecdes());
      setgxTv_SdtNovedades_Agefechas(struct.getAgefechas());
      setgxTv_SdtNovedades_Agelegactivo(struct.getAgelegactivo());
      setgxTv_SdtNovedades_Legid(struct.getLegid());
      setgxTv_SdtNovedades_Ageprevis(struct.getAgeprevis());
      setgxTv_SdtNovedades_Ageprevcalc(struct.getAgeprevcalc());
      setgxTv_SdtNovedades_Legcuil(struct.getLegcuil());
      setgxTv_SdtNovedades_Ageperdescrip(struct.getAgeperdescrip());
      setgxTv_SdtNovedades_Mode(struct.getMode());
      setgxTv_SdtNovedades_Initialized(struct.getInitialized());
      setgxTv_SdtNovedades_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtNovedades_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtNovedades_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtNovedades_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtNovedades_Legapellido_Z(struct.getLegapellido_Z());
      setgxTv_SdtNovedades_Legnombre_Z(struct.getLegnombre_Z());
      setgxTv_SdtNovedades_Legfecegreso_Z(struct.getLegfecegreso_Z());
      setgxTv_SdtNovedades_Ageorden_Z(struct.getAgeorden_Z());
      setgxTv_SdtNovedades_Concodigo_Z(struct.getConcodigo_Z());
      setgxTv_SdtNovedades_Condescrip_Z(struct.getCondescrip_Z());
      setgxTv_SdtNovedades_Agecanti_Z(struct.getAgecanti_Z());
      setgxTv_SdtNovedades_Agevunit_Z(struct.getAgevunit_Z());
      setgxTv_SdtNovedades_Ageimporte_Z(struct.getAgeimporte_Z());
      setgxTv_SdtNovedades_Ageliqnro_Z(struct.getAgeliqnro_Z());
      setgxTv_SdtNovedades_Agefecdes_Z(struct.getAgefecdes_Z());
      setgxTv_SdtNovedades_Agefechas_Z(struct.getAgefechas_Z());
      setgxTv_SdtNovedades_Agelegactivo_Z(struct.getAgelegactivo_Z());
      setgxTv_SdtNovedades_Legid_Z(struct.getLegid_Z());
      setgxTv_SdtNovedades_Ageprevcalc_Z(struct.getAgeprevcalc_Z());
      setgxTv_SdtNovedades_Legcuil_Z(struct.getLegcuil_Z());
      setgxTv_SdtNovedades_Ageperdescrip_Z(struct.getAgeperdescrip_Z());
      setgxTv_SdtNovedades_Legfecegreso_N(struct.getLegfecegreso_N());
      setgxTv_SdtNovedades_Agecanti_N(struct.getAgecanti_N());
      setgxTv_SdtNovedades_Agevunit_N(struct.getAgevunit_N());
      setgxTv_SdtNovedades_Ageimporte_N(struct.getAgeimporte_N());
      setgxTv_SdtNovedades_Ageliqnro_N(struct.getAgeliqnro_N());
      setgxTv_SdtNovedades_Agefecdes_N(struct.getAgefecdes_N());
      setgxTv_SdtNovedades_Agefechas_N(struct.getAgefechas_N());
      setgxTv_SdtNovedades_Legid_N(struct.getLegid_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtNovedades getStruct( )
   {
      web.StructSdtNovedades struct = new web.StructSdtNovedades ();
      struct.setClicod(getgxTv_SdtNovedades_Clicod());
      struct.setEmpcod(getgxTv_SdtNovedades_Empcod());
      struct.setEmpnom(getgxTv_SdtNovedades_Empnom());
      struct.setLegnumero(getgxTv_SdtNovedades_Legnumero());
      struct.setLegapellido(getgxTv_SdtNovedades_Legapellido());
      struct.setLegnombre(getgxTv_SdtNovedades_Legnombre());
      struct.setLegfecegreso(getgxTv_SdtNovedades_Legfecegreso());
      struct.setAgeorden(getgxTv_SdtNovedades_Ageorden());
      struct.setConcodigo(getgxTv_SdtNovedades_Concodigo());
      struct.setCondescrip(getgxTv_SdtNovedades_Condescrip());
      struct.setAgecanti(getgxTv_SdtNovedades_Agecanti());
      struct.setAgevunit(getgxTv_SdtNovedades_Agevunit());
      struct.setAgeimporte(getgxTv_SdtNovedades_Ageimporte());
      struct.setAgeliqnro(getgxTv_SdtNovedades_Ageliqnro());
      struct.setAgefecdes(getgxTv_SdtNovedades_Agefecdes());
      struct.setAgefechas(getgxTv_SdtNovedades_Agefechas());
      struct.setAgelegactivo(getgxTv_SdtNovedades_Agelegactivo());
      struct.setLegid(getgxTv_SdtNovedades_Legid());
      struct.setAgeprevis(getgxTv_SdtNovedades_Ageprevis());
      struct.setAgeprevcalc(getgxTv_SdtNovedades_Ageprevcalc());
      struct.setLegcuil(getgxTv_SdtNovedades_Legcuil());
      struct.setAgeperdescrip(getgxTv_SdtNovedades_Ageperdescrip());
      struct.setMode(getgxTv_SdtNovedades_Mode());
      struct.setInitialized(getgxTv_SdtNovedades_Initialized());
      struct.setClicod_Z(getgxTv_SdtNovedades_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtNovedades_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtNovedades_Empnom_Z());
      struct.setLegnumero_Z(getgxTv_SdtNovedades_Legnumero_Z());
      struct.setLegapellido_Z(getgxTv_SdtNovedades_Legapellido_Z());
      struct.setLegnombre_Z(getgxTv_SdtNovedades_Legnombre_Z());
      struct.setLegfecegreso_Z(getgxTv_SdtNovedades_Legfecegreso_Z());
      struct.setAgeorden_Z(getgxTv_SdtNovedades_Ageorden_Z());
      struct.setConcodigo_Z(getgxTv_SdtNovedades_Concodigo_Z());
      struct.setCondescrip_Z(getgxTv_SdtNovedades_Condescrip_Z());
      struct.setAgecanti_Z(getgxTv_SdtNovedades_Agecanti_Z());
      struct.setAgevunit_Z(getgxTv_SdtNovedades_Agevunit_Z());
      struct.setAgeimporte_Z(getgxTv_SdtNovedades_Ageimporte_Z());
      struct.setAgeliqnro_Z(getgxTv_SdtNovedades_Ageliqnro_Z());
      struct.setAgefecdes_Z(getgxTv_SdtNovedades_Agefecdes_Z());
      struct.setAgefechas_Z(getgxTv_SdtNovedades_Agefechas_Z());
      struct.setAgelegactivo_Z(getgxTv_SdtNovedades_Agelegactivo_Z());
      struct.setLegid_Z(getgxTv_SdtNovedades_Legid_Z());
      struct.setAgeprevcalc_Z(getgxTv_SdtNovedades_Ageprevcalc_Z());
      struct.setLegcuil_Z(getgxTv_SdtNovedades_Legcuil_Z());
      struct.setAgeperdescrip_Z(getgxTv_SdtNovedades_Ageperdescrip_Z());
      struct.setLegfecegreso_N(getgxTv_SdtNovedades_Legfecegreso_N());
      struct.setAgecanti_N(getgxTv_SdtNovedades_Agecanti_N());
      struct.setAgevunit_N(getgxTv_SdtNovedades_Agevunit_N());
      struct.setAgeimporte_N(getgxTv_SdtNovedades_Ageimporte_N());
      struct.setAgeliqnro_N(getgxTv_SdtNovedades_Ageliqnro_N());
      struct.setAgefecdes_N(getgxTv_SdtNovedades_Agefecdes_N());
      struct.setAgefechas_N(getgxTv_SdtNovedades_Agefechas_N());
      struct.setLegid_N(getgxTv_SdtNovedades_Legid_N());
      return struct ;
   }

   private byte gxTv_SdtNovedades_N ;
   private byte gxTv_SdtNovedades_Legfecegreso_N ;
   private byte gxTv_SdtNovedades_Agecanti_N ;
   private byte gxTv_SdtNovedades_Agevunit_N ;
   private byte gxTv_SdtNovedades_Ageimporte_N ;
   private byte gxTv_SdtNovedades_Ageliqnro_N ;
   private byte gxTv_SdtNovedades_Agefecdes_N ;
   private byte gxTv_SdtNovedades_Agefechas_N ;
   private byte gxTv_SdtNovedades_Legid_N ;
   private short gxTv_SdtNovedades_Empcod ;
   private short gxTv_SdtNovedades_Ageorden ;
   private short gxTv_SdtNovedades_Initialized ;
   private short gxTv_SdtNovedades_Empcod_Z ;
   private short gxTv_SdtNovedades_Ageorden_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtNovedades_Clicod ;
   private int gxTv_SdtNovedades_Legnumero ;
   private int gxTv_SdtNovedades_Ageliqnro ;
   private int gxTv_SdtNovedades_Clicod_Z ;
   private int gxTv_SdtNovedades_Legnumero_Z ;
   private int gxTv_SdtNovedades_Ageliqnro_Z ;
   private long gxTv_SdtNovedades_Legcuil ;
   private long gxTv_SdtNovedades_Legcuil_Z ;
   private java.math.BigDecimal gxTv_SdtNovedades_Agecanti ;
   private java.math.BigDecimal gxTv_SdtNovedades_Agevunit ;
   private java.math.BigDecimal gxTv_SdtNovedades_Ageimporte ;
   private java.math.BigDecimal gxTv_SdtNovedades_Agecanti_Z ;
   private java.math.BigDecimal gxTv_SdtNovedades_Agevunit_Z ;
   private java.math.BigDecimal gxTv_SdtNovedades_Ageimporte_Z ;
   private String gxTv_SdtNovedades_Concodigo ;
   private String gxTv_SdtNovedades_Legid ;
   private String gxTv_SdtNovedades_Ageprevcalc ;
   private String gxTv_SdtNovedades_Mode ;
   private String gxTv_SdtNovedades_Concodigo_Z ;
   private String gxTv_SdtNovedades_Legid_Z ;
   private String gxTv_SdtNovedades_Ageprevcalc_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtNovedades_Legfecegreso ;
   private java.util.Date gxTv_SdtNovedades_Agefecdes ;
   private java.util.Date gxTv_SdtNovedades_Agefechas ;
   private java.util.Date gxTv_SdtNovedades_Legfecegreso_Z ;
   private java.util.Date gxTv_SdtNovedades_Agefecdes_Z ;
   private java.util.Date gxTv_SdtNovedades_Agefechas_Z ;
   private boolean gxTv_SdtNovedades_Agelegactivo ;
   private boolean gxTv_SdtNovedades_Agelegactivo_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtNovedades_Ageprevis ;
   private String gxTv_SdtNovedades_Empnom ;
   private String gxTv_SdtNovedades_Legapellido ;
   private String gxTv_SdtNovedades_Legnombre ;
   private String gxTv_SdtNovedades_Condescrip ;
   private String gxTv_SdtNovedades_Ageperdescrip ;
   private String gxTv_SdtNovedades_Empnom_Z ;
   private String gxTv_SdtNovedades_Legapellido_Z ;
   private String gxTv_SdtNovedades_Legnombre_Z ;
   private String gxTv_SdtNovedades_Condescrip_Z ;
   private String gxTv_SdtNovedades_Ageperdescrip_Z ;
}

