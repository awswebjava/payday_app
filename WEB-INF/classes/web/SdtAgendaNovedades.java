package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtAgendaNovedades extends GxSilentTrnSdt
{
   public SdtAgendaNovedades( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtAgendaNovedades.class));
   }

   public SdtAgendaNovedades( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtAgendaNovedades");
      initialize( remoteHandle) ;
   }

   public SdtAgendaNovedades( int remoteHandle ,
                              StructSdtAgendaNovedades struct )
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
      metadata.set("Name", "AgendaNovedades");
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
               gxTv_SdtAgendaNovedades_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtAgendaNovedades_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtAgendaNovedades_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtAgendaNovedades_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido") )
            {
               gxTv_SdtAgendaNovedades_Legapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre") )
            {
               gxTv_SdtAgendaNovedades_Legnombre = oReader.getValue() ;
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
                  gxTv_SdtAgendaNovedades_Legfecegreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Legfecegreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtAgendaNovedades_Ageorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_SdtAgendaNovedades_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_SdtAgendaNovedades_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti") )
            {
               gxTv_SdtAgendaNovedades_Agecanti = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit") )
            {
               gxTv_SdtAgendaNovedades_Agevunit = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte") )
            {
               gxTv_SdtAgendaNovedades_Ageimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
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
                  gxTv_SdtAgendaNovedades_Agefecdes = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Agefecdes = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtAgendaNovedades_Agefechas = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Agefechas = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtAgendaNovedades_Agelegactivo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId") )
            {
               gxTv_SdtAgendaNovedades_Legid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCanti") )
            {
               gxTv_SdtAgendaNovedades_Concanti = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValUni") )
            {
               gxTv_SdtAgendaNovedades_Convaluni = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImporte") )
            {
               gxTv_SdtAgendaNovedades_Conimporte = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro") )
            {
               gxTv_SdtAgendaNovedades_Ageliqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtAgendaNovedades_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtAgendaNovedades_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtAgendaNovedades_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtAgendaNovedades_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtAgendaNovedades_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtAgendaNovedades_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido_Z") )
            {
               gxTv_SdtAgendaNovedades_Legapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre_Z") )
            {
               gxTv_SdtAgendaNovedades_Legnombre_Z = oReader.getValue() ;
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
                  gxTv_SdtAgendaNovedades_Legfecegreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Legfecegreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtAgendaNovedades_Ageorden_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo_Z") )
            {
               gxTv_SdtAgendaNovedades_Concodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip_Z") )
            {
               gxTv_SdtAgendaNovedades_Condescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti_Z") )
            {
               gxTv_SdtAgendaNovedades_Agecanti_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit_Z") )
            {
               gxTv_SdtAgendaNovedades_Agevunit_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte_Z") )
            {
               gxTv_SdtAgendaNovedades_Ageimporte_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
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
                  gxTv_SdtAgendaNovedades_Agefecdes_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Agefecdes_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtAgendaNovedades_Agefechas_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtAgendaNovedades_Agefechas_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtAgendaNovedades_Agelegactivo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_Z") )
            {
               gxTv_SdtAgendaNovedades_Legid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCanti_Z") )
            {
               gxTv_SdtAgendaNovedades_Concanti_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValUni_Z") )
            {
               gxTv_SdtAgendaNovedades_Convaluni_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImporte_Z") )
            {
               gxTv_SdtAgendaNovedades_Conimporte_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro_Z") )
            {
               gxTv_SdtAgendaNovedades_Ageliqnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegFecEgreso_N") )
            {
               gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti_N") )
            {
               gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeVUnit_N") )
            {
               gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeImporte_N") )
            {
               gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecDes_N") )
            {
               gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeFecHas_N") )
            {
               gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_N") )
            {
               gxTv_SdtAgendaNovedades_Legid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeLiqNro_N") )
            {
               gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "AgendaNovedades" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtAgendaNovedades_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegApellido", gxTv_SdtAgendaNovedades_Legapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNombre", gxTv_SdtAgendaNovedades_Legnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegFecEgreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeOrden", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodigo", gxTv_SdtAgendaNovedades_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_SdtAgendaNovedades_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeCanti", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Agecanti, 9, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeVUnit", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Agevunit, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Ageimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("AgeFecDes", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("AgeFecHas", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeLegActivo", GXutil.booltostr( gxTv_SdtAgendaNovedades_Agelegactivo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegId", gxTv_SdtAgendaNovedades_Legid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCanti", GXutil.booltostr( gxTv_SdtAgendaNovedades_Concanti));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConValUni", GXutil.booltostr( gxTv_SdtAgendaNovedades_Convaluni));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConImporte", GXutil.booltostr( gxTv_SdtAgendaNovedades_Conimporte));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeLiqNro", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageliqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtAgendaNovedades_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtAgendaNovedades_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegApellido_Z", gxTv_SdtAgendaNovedades_Legapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNombre_Z", gxTv_SdtAgendaNovedades_Legnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegFecEgreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageorden_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodigo_Z", gxTv_SdtAgendaNovedades_Concodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConDescrip_Z", gxTv_SdtAgendaNovedades_Condescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeCanti_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Agecanti_Z, 9, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeVUnit_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Agevunit_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeImporte_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtAgendaNovedades_Ageimporte_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("AgeFecDes_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("AgeFecHas_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLegActivo_Z", GXutil.booltostr( gxTv_SdtAgendaNovedades_Agelegactivo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_Z", gxTv_SdtAgendaNovedades_Legid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCanti_Z", GXutil.booltostr( gxTv_SdtAgendaNovedades_Concanti_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConValUni_Z", GXutil.booltostr( gxTv_SdtAgendaNovedades_Convaluni_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConImporte_Z", GXutil.booltostr( gxTv_SdtAgendaNovedades_Conimporte_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLiqNro_Z", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageliqnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegFecEgreso_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Legfecegreso_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeCanti_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Agecanti_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeVUnit_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Agevunit_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeImporte_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageimporte_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeFecDes_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Agefecdes_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeFecHas_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Agefechas_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Legid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AgeLiqNro_N", GXutil.trim( GXutil.str( gxTv_SdtAgendaNovedades_Ageliqnro_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtAgendaNovedades_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtAgendaNovedades_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtAgendaNovedades_Empnom, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtAgendaNovedades_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LegApellido", gxTv_SdtAgendaNovedades_Legapellido, false, includeNonInitialized);
      AddObjectProperty("LegNombre", gxTv_SdtAgendaNovedades_Legnombre, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Legfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegFecEgreso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegFecEgreso_N", gxTv_SdtAgendaNovedades_Legfecegreso_N, false, includeNonInitialized);
      AddObjectProperty("AgeOrden", gxTv_SdtAgendaNovedades_Ageorden, false, includeNonInitialized);
      AddObjectProperty("ConCodigo", gxTv_SdtAgendaNovedades_Concodigo, false, includeNonInitialized);
      AddObjectProperty("ConDescrip", gxTv_SdtAgendaNovedades_Condescrip, false, includeNonInitialized);
      AddObjectProperty("AgeCanti", gxTv_SdtAgendaNovedades_Agecanti, false, includeNonInitialized);
      AddObjectProperty("AgeCanti_N", gxTv_SdtAgendaNovedades_Agecanti_N, false, includeNonInitialized);
      AddObjectProperty("AgeVUnit", gxTv_SdtAgendaNovedades_Agevunit, false, includeNonInitialized);
      AddObjectProperty("AgeVUnit_N", gxTv_SdtAgendaNovedades_Agevunit_N, false, includeNonInitialized);
      AddObjectProperty("AgeImporte", gxTv_SdtAgendaNovedades_Ageimporte, false, includeNonInitialized);
      AddObjectProperty("AgeImporte_N", gxTv_SdtAgendaNovedades_Ageimporte_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefecdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("AgeFecDes", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("AgeFecDes_N", gxTv_SdtAgendaNovedades_Agefecdes_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefechas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("AgeFecHas", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("AgeFecHas_N", gxTv_SdtAgendaNovedades_Agefechas_N, false, includeNonInitialized);
      AddObjectProperty("AgeLegActivo", gxTv_SdtAgendaNovedades_Agelegactivo, false, includeNonInitialized);
      AddObjectProperty("LegId", gxTv_SdtAgendaNovedades_Legid, false, includeNonInitialized);
      AddObjectProperty("LegId_N", gxTv_SdtAgendaNovedades_Legid_N, false, includeNonInitialized);
      AddObjectProperty("ConCanti", gxTv_SdtAgendaNovedades_Concanti, false, includeNonInitialized);
      AddObjectProperty("ConValUni", gxTv_SdtAgendaNovedades_Convaluni, false, includeNonInitialized);
      AddObjectProperty("ConImporte", gxTv_SdtAgendaNovedades_Conimporte, false, includeNonInitialized);
      AddObjectProperty("AgeLiqNro", gxTv_SdtAgendaNovedades_Ageliqnro, false, includeNonInitialized);
      AddObjectProperty("AgeLiqNro_N", gxTv_SdtAgendaNovedades_Ageliqnro_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtAgendaNovedades_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtAgendaNovedades_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtAgendaNovedades_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtAgendaNovedades_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtAgendaNovedades_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtAgendaNovedades_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LegApellido_Z", gxTv_SdtAgendaNovedades_Legapellido_Z, false, includeNonInitialized);
         AddObjectProperty("LegNombre_Z", gxTv_SdtAgendaNovedades_Legnombre_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Legfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegFecEgreso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("AgeOrden_Z", gxTv_SdtAgendaNovedades_Ageorden_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodigo_Z", gxTv_SdtAgendaNovedades_Concodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConDescrip_Z", gxTv_SdtAgendaNovedades_Condescrip_Z, false, includeNonInitialized);
         AddObjectProperty("AgeCanti_Z", gxTv_SdtAgendaNovedades_Agecanti_Z, false, includeNonInitialized);
         AddObjectProperty("AgeVUnit_Z", gxTv_SdtAgendaNovedades_Agevunit_Z, false, includeNonInitialized);
         AddObjectProperty("AgeImporte_Z", gxTv_SdtAgendaNovedades_Ageimporte_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefecdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("AgeFecDes_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtAgendaNovedades_Agefechas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("AgeFecHas_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("AgeLegActivo_Z", gxTv_SdtAgendaNovedades_Agelegactivo_Z, false, includeNonInitialized);
         AddObjectProperty("LegId_Z", gxTv_SdtAgendaNovedades_Legid_Z, false, includeNonInitialized);
         AddObjectProperty("ConCanti_Z", gxTv_SdtAgendaNovedades_Concanti_Z, false, includeNonInitialized);
         AddObjectProperty("ConValUni_Z", gxTv_SdtAgendaNovedades_Convaluni_Z, false, includeNonInitialized);
         AddObjectProperty("ConImporte_Z", gxTv_SdtAgendaNovedades_Conimporte_Z, false, includeNonInitialized);
         AddObjectProperty("AgeLiqNro_Z", gxTv_SdtAgendaNovedades_Ageliqnro_Z, false, includeNonInitialized);
         AddObjectProperty("LegFecEgreso_N", gxTv_SdtAgendaNovedades_Legfecegreso_N, false, includeNonInitialized);
         AddObjectProperty("AgeCanti_N", gxTv_SdtAgendaNovedades_Agecanti_N, false, includeNonInitialized);
         AddObjectProperty("AgeVUnit_N", gxTv_SdtAgendaNovedades_Agevunit_N, false, includeNonInitialized);
         AddObjectProperty("AgeImporte_N", gxTv_SdtAgendaNovedades_Ageimporte_N, false, includeNonInitialized);
         AddObjectProperty("AgeFecDes_N", gxTv_SdtAgendaNovedades_Agefecdes_N, false, includeNonInitialized);
         AddObjectProperty("AgeFecHas_N", gxTv_SdtAgendaNovedades_Agefechas_N, false, includeNonInitialized);
         AddObjectProperty("LegId_N", gxTv_SdtAgendaNovedades_Legid_N, false, includeNonInitialized);
         AddObjectProperty("AgeLiqNro_N", gxTv_SdtAgendaNovedades_Ageliqnro_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtAgendaNovedades sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Clicod = sdt.getgxTv_SdtAgendaNovedades_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Empcod = sdt.getgxTv_SdtAgendaNovedades_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Empnom = sdt.getgxTv_SdtAgendaNovedades_Empnom() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Legnumero = sdt.getgxTv_SdtAgendaNovedades_Legnumero() ;
      }
      if ( sdt.IsDirty("LegApellido") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Legapellido = sdt.getgxTv_SdtAgendaNovedades_Legapellido() ;
      }
      if ( sdt.IsDirty("LegNombre") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Legnombre = sdt.getgxTv_SdtAgendaNovedades_Legnombre() ;
      }
      if ( sdt.IsDirty("LegFecEgreso") )
      {
         gxTv_SdtAgendaNovedades_Legfecegreso_N = sdt.getgxTv_SdtAgendaNovedades_Legfecegreso_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Legfecegreso = sdt.getgxTv_SdtAgendaNovedades_Legfecegreso() ;
      }
      if ( sdt.IsDirty("AgeOrden") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Ageorden = sdt.getgxTv_SdtAgendaNovedades_Ageorden() ;
      }
      if ( sdt.IsDirty("ConCodigo") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Concodigo = sdt.getgxTv_SdtAgendaNovedades_Concodigo() ;
      }
      if ( sdt.IsDirty("ConDescrip") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Condescrip = sdt.getgxTv_SdtAgendaNovedades_Condescrip() ;
      }
      if ( sdt.IsDirty("AgeCanti") )
      {
         gxTv_SdtAgendaNovedades_Agecanti_N = sdt.getgxTv_SdtAgendaNovedades_Agecanti_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Agecanti = sdt.getgxTv_SdtAgendaNovedades_Agecanti() ;
      }
      if ( sdt.IsDirty("AgeVUnit") )
      {
         gxTv_SdtAgendaNovedades_Agevunit_N = sdt.getgxTv_SdtAgendaNovedades_Agevunit_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Agevunit = sdt.getgxTv_SdtAgendaNovedades_Agevunit() ;
      }
      if ( sdt.IsDirty("AgeImporte") )
      {
         gxTv_SdtAgendaNovedades_Ageimporte_N = sdt.getgxTv_SdtAgendaNovedades_Ageimporte_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Ageimporte = sdt.getgxTv_SdtAgendaNovedades_Ageimporte() ;
      }
      if ( sdt.IsDirty("AgeFecDes") )
      {
         gxTv_SdtAgendaNovedades_Agefecdes_N = sdt.getgxTv_SdtAgendaNovedades_Agefecdes_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Agefecdes = sdt.getgxTv_SdtAgendaNovedades_Agefecdes() ;
      }
      if ( sdt.IsDirty("AgeFecHas") )
      {
         gxTv_SdtAgendaNovedades_Agefechas_N = sdt.getgxTv_SdtAgendaNovedades_Agefechas_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Agefechas = sdt.getgxTv_SdtAgendaNovedades_Agefechas() ;
      }
      if ( sdt.IsDirty("AgeLegActivo") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Agelegactivo = sdt.getgxTv_SdtAgendaNovedades_Agelegactivo() ;
      }
      if ( sdt.IsDirty("LegId") )
      {
         gxTv_SdtAgendaNovedades_Legid_N = sdt.getgxTv_SdtAgendaNovedades_Legid_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Legid = sdt.getgxTv_SdtAgendaNovedades_Legid() ;
      }
      if ( sdt.IsDirty("ConCanti") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Concanti = sdt.getgxTv_SdtAgendaNovedades_Concanti() ;
      }
      if ( sdt.IsDirty("ConValUni") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Convaluni = sdt.getgxTv_SdtAgendaNovedades_Convaluni() ;
      }
      if ( sdt.IsDirty("ConImporte") )
      {
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Conimporte = sdt.getgxTv_SdtAgendaNovedades_Conimporte() ;
      }
      if ( sdt.IsDirty("AgeLiqNro") )
      {
         gxTv_SdtAgendaNovedades_Ageliqnro_N = sdt.getgxTv_SdtAgendaNovedades_Ageliqnro_N() ;
         gxTv_SdtAgendaNovedades_N = (byte)(0) ;
         gxTv_SdtAgendaNovedades_Ageliqnro = sdt.getgxTv_SdtAgendaNovedades_Ageliqnro() ;
      }
   }

   public int getgxTv_SdtAgendaNovedades_Clicod( )
   {
      return gxTv_SdtAgendaNovedades_Clicod ;
   }

   public void setgxTv_SdtAgendaNovedades_Clicod( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      if ( gxTv_SdtAgendaNovedades_Clicod != value )
      {
         gxTv_SdtAgendaNovedades_Mode = "INS" ;
         this.setgxTv_SdtAgendaNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Convaluni_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Conimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageliqnro_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtAgendaNovedades_Clicod = value ;
   }

   public short getgxTv_SdtAgendaNovedades_Empcod( )
   {
      return gxTv_SdtAgendaNovedades_Empcod ;
   }

   public void setgxTv_SdtAgendaNovedades_Empcod( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      if ( gxTv_SdtAgendaNovedades_Empcod != value )
      {
         gxTv_SdtAgendaNovedades_Mode = "INS" ;
         this.setgxTv_SdtAgendaNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Convaluni_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Conimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageliqnro_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtAgendaNovedades_Empcod = value ;
   }

   public String getgxTv_SdtAgendaNovedades_Empnom( )
   {
      return gxTv_SdtAgendaNovedades_Empnom ;
   }

   public void setgxTv_SdtAgendaNovedades_Empnom( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtAgendaNovedades_Empnom = value ;
   }

   public int getgxTv_SdtAgendaNovedades_Legnumero( )
   {
      return gxTv_SdtAgendaNovedades_Legnumero ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnumero( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      if ( gxTv_SdtAgendaNovedades_Legnumero != value )
      {
         gxTv_SdtAgendaNovedades_Mode = "INS" ;
         this.setgxTv_SdtAgendaNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Convaluni_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Conimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageliqnro_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtAgendaNovedades_Legnumero = value ;
   }

   public String getgxTv_SdtAgendaNovedades_Legapellido( )
   {
      return gxTv_SdtAgendaNovedades_Legapellido ;
   }

   public void setgxTv_SdtAgendaNovedades_Legapellido( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legapellido");
      gxTv_SdtAgendaNovedades_Legapellido = value ;
   }

   public String getgxTv_SdtAgendaNovedades_Legnombre( )
   {
      return gxTv_SdtAgendaNovedades_Legnombre ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnombre( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legnombre");
      gxTv_SdtAgendaNovedades_Legnombre = value ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Legfecegreso( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso");
      gxTv_SdtAgendaNovedades_Legfecegreso = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Legfecegreso = GXutil.nullDate() ;
      SetDirty("Legfecegreso");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legfecegreso_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Legfecegreso_N==1) ;
   }

   public short getgxTv_SdtAgendaNovedades_Ageorden( )
   {
      return gxTv_SdtAgendaNovedades_Ageorden ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageorden( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      if ( gxTv_SdtAgendaNovedades_Ageorden != value )
      {
         gxTv_SdtAgendaNovedades_Mode = "INS" ;
         this.setgxTv_SdtAgendaNovedades_Clicod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empcod_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Empnom_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnumero_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legapellido_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legnombre_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legfecegreso_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageorden_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concodigo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Condescrip_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agecanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agevunit_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefecdes_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agefechas_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Agelegactivo_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Legid_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Concanti_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Convaluni_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Conimporte_Z_SetNull( );
         this.setgxTv_SdtAgendaNovedades_Ageliqnro_Z_SetNull( );
      }
      SetDirty("Ageorden");
      gxTv_SdtAgendaNovedades_Ageorden = value ;
   }

   public String getgxTv_SdtAgendaNovedades_Concodigo( )
   {
      return gxTv_SdtAgendaNovedades_Concodigo ;
   }

   public void setgxTv_SdtAgendaNovedades_Concodigo( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Concodigo");
      gxTv_SdtAgendaNovedades_Concodigo = value ;
   }

   public String getgxTv_SdtAgendaNovedades_Condescrip( )
   {
      return gxTv_SdtAgendaNovedades_Condescrip ;
   }

   public void setgxTv_SdtAgendaNovedades_Condescrip( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Condescrip");
      gxTv_SdtAgendaNovedades_Condescrip = value ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Agecanti( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agecanti");
      gxTv_SdtAgendaNovedades_Agecanti = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agecanti = DecimalUtil.ZERO ;
      SetDirty("Agecanti");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agecanti_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Agecanti_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Agevunit( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agevunit");
      gxTv_SdtAgendaNovedades_Agevunit = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agevunit = DecimalUtil.ZERO ;
      SetDirty("Agevunit");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agevunit_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Agevunit_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Ageimporte( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte");
      gxTv_SdtAgendaNovedades_Ageimporte = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Ageimporte = DecimalUtil.ZERO ;
      SetDirty("Ageimporte");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageimporte_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Ageimporte_N==1) ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Agefecdes( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes");
      gxTv_SdtAgendaNovedades_Agefecdes = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agefecdes = GXutil.nullDate() ;
      SetDirty("Agefecdes");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefecdes_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Agefecdes_N==1) ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Agefechas( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefechas");
      gxTv_SdtAgendaNovedades_Agefechas = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agefechas = GXutil.nullDate() ;
      SetDirty("Agefechas");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefechas_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Agefechas_N==1) ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Agelegactivo( )
   {
      return gxTv_SdtAgendaNovedades_Agelegactivo ;
   }

   public void setgxTv_SdtAgendaNovedades_Agelegactivo( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agelegactivo");
      gxTv_SdtAgendaNovedades_Agelegactivo = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agelegactivo_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agelegactivo = false ;
      SetDirty("Agelegactivo");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agelegactivo_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Legid( )
   {
      return gxTv_SdtAgendaNovedades_Legid ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid( String value )
   {
      gxTv_SdtAgendaNovedades_Legid_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legid");
      gxTv_SdtAgendaNovedades_Legid = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legid_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Legid = "" ;
      SetDirty("Legid");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legid_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Legid_N==1) ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Concanti( )
   {
      return gxTv_SdtAgendaNovedades_Concanti ;
   }

   public void setgxTv_SdtAgendaNovedades_Concanti( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Concanti");
      gxTv_SdtAgendaNovedades_Concanti = value ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Convaluni( )
   {
      return gxTv_SdtAgendaNovedades_Convaluni ;
   }

   public void setgxTv_SdtAgendaNovedades_Convaluni( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Convaluni");
      gxTv_SdtAgendaNovedades_Convaluni = value ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Conimporte( )
   {
      return gxTv_SdtAgendaNovedades_Conimporte ;
   }

   public void setgxTv_SdtAgendaNovedades_Conimporte( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Conimporte");
      gxTv_SdtAgendaNovedades_Conimporte = value ;
   }

   public int getgxTv_SdtAgendaNovedades_Ageliqnro( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro( int value )
   {
      gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro");
      gxTv_SdtAgendaNovedades_Ageliqnro = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Ageliqnro = 0 ;
      SetDirty("Ageliqnro");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageliqnro_IsNull( )
   {
      return (gxTv_SdtAgendaNovedades_Ageliqnro_N==1) ;
   }

   public String getgxTv_SdtAgendaNovedades_Mode( )
   {
      return gxTv_SdtAgendaNovedades_Mode ;
   }

   public void setgxTv_SdtAgendaNovedades_Mode( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtAgendaNovedades_Mode = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Mode_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtAgendaNovedades_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtAgendaNovedades_Initialized( )
   {
      return gxTv_SdtAgendaNovedades_Initialized ;
   }

   public void setgxTv_SdtAgendaNovedades_Initialized( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtAgendaNovedades_Initialized = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Initialized_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtAgendaNovedades_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtAgendaNovedades_Clicod_Z( )
   {
      return gxTv_SdtAgendaNovedades_Clicod_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Clicod_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtAgendaNovedades_Clicod_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Clicod_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtAgendaNovedades_Empcod_Z( )
   {
      return gxTv_SdtAgendaNovedades_Empcod_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Empcod_Z( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtAgendaNovedades_Empcod_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Empcod_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Empnom_Z( )
   {
      return gxTv_SdtAgendaNovedades_Empnom_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Empnom_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtAgendaNovedades_Empnom_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Empnom_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtAgendaNovedades_Legnumero_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legnumero_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnumero_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtAgendaNovedades_Legnumero_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnumero_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Legapellido_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legapellido_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Legapellido_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legapellido_Z");
      gxTv_SdtAgendaNovedades_Legapellido_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legapellido_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legapellido_Z = "" ;
      SetDirty("Legapellido_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Legnombre_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legnombre_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnombre_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legnombre_Z");
      gxTv_SdtAgendaNovedades_Legnombre_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legnombre_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legnombre_Z = "" ;
      SetDirty("Legnombre_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legnombre_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Legfecegreso_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso_Z");
      gxTv_SdtAgendaNovedades_Legfecegreso_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legfecegreso_Z = GXutil.nullDate() ;
      SetDirty("Legfecegreso_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legfecegreso_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtAgendaNovedades_Ageorden_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageorden_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageorden_Z( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageorden_Z");
      gxTv_SdtAgendaNovedades_Ageorden_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageorden_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageorden_Z = (short)(0) ;
      SetDirty("Ageorden_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageorden_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Concodigo_Z( )
   {
      return gxTv_SdtAgendaNovedades_Concodigo_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Concodigo_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Concodigo_Z");
      gxTv_SdtAgendaNovedades_Concodigo_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Concodigo_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Concodigo_Z = "" ;
      SetDirty("Concodigo_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Concodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Condescrip_Z( )
   {
      return gxTv_SdtAgendaNovedades_Condescrip_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Condescrip_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Condescrip_Z");
      gxTv_SdtAgendaNovedades_Condescrip_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Condescrip_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Condescrip_Z = "" ;
      SetDirty("Condescrip_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Condescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Agecanti_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agecanti_Z");
      gxTv_SdtAgendaNovedades_Agecanti_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agecanti_Z = DecimalUtil.ZERO ;
      SetDirty("Agecanti_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agecanti_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Agevunit_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agevunit_Z");
      gxTv_SdtAgendaNovedades_Agevunit_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agevunit_Z = DecimalUtil.ZERO ;
      SetDirty("Agevunit_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agevunit_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtAgendaNovedades_Ageimporte_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte_Z");
      gxTv_SdtAgendaNovedades_Ageimporte_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageimporte_Z = DecimalUtil.ZERO ;
      SetDirty("Ageimporte_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageimporte_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Agefecdes_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes_Z");
      gxTv_SdtAgendaNovedades_Agefecdes_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefecdes_Z = GXutil.nullDate() ;
      SetDirty("Agefecdes_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefecdes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtAgendaNovedades_Agefechas_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefechas_Z");
      gxTv_SdtAgendaNovedades_Agefechas_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefechas_Z = GXutil.nullDate() ;
      SetDirty("Agefechas_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefechas_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Agelegactivo_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agelegactivo_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Agelegactivo_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agelegactivo_Z");
      gxTv_SdtAgendaNovedades_Agelegactivo_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agelegactivo_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agelegactivo_Z = false ;
      SetDirty("Agelegactivo_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agelegactivo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtAgendaNovedades_Legid_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legid_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legid_Z");
      gxTv_SdtAgendaNovedades_Legid_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legid_Z = "" ;
      SetDirty("Legid_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legid_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Concanti_Z( )
   {
      return gxTv_SdtAgendaNovedades_Concanti_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Concanti_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Concanti_Z");
      gxTv_SdtAgendaNovedades_Concanti_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Concanti_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Concanti_Z = false ;
      SetDirty("Concanti_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Concanti_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Convaluni_Z( )
   {
      return gxTv_SdtAgendaNovedades_Convaluni_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Convaluni_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Convaluni_Z");
      gxTv_SdtAgendaNovedades_Convaluni_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Convaluni_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Convaluni_Z = false ;
      SetDirty("Convaluni_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Convaluni_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtAgendaNovedades_Conimporte_Z( )
   {
      return gxTv_SdtAgendaNovedades_Conimporte_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Conimporte_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Conimporte_Z");
      gxTv_SdtAgendaNovedades_Conimporte_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Conimporte_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Conimporte_Z = false ;
      SetDirty("Conimporte_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Conimporte_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtAgendaNovedades_Ageliqnro_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro_Z ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro_Z");
      gxTv_SdtAgendaNovedades_Ageliqnro_Z = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro_Z_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageliqnro_Z = 0 ;
      SetDirty("Ageliqnro_Z");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageliqnro_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Legfecegreso_N( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
      gxTv_SdtAgendaNovedades_Legfecegreso_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legfecegreso_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(0) ;
      SetDirty("Legfecegreso_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legfecegreso_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Agecanti_N( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agecanti_N");
      gxTv_SdtAgendaNovedades_Agecanti_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agecanti_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(0) ;
      SetDirty("Agecanti_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agecanti_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Agevunit_N( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agevunit_N");
      gxTv_SdtAgendaNovedades_Agevunit_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agevunit_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(0) ;
      SetDirty("Agevunit_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agevunit_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Ageimporte_N( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageimporte_N");
      gxTv_SdtAgendaNovedades_Ageimporte_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageimporte_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(0) ;
      SetDirty("Ageimporte_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageimporte_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Agefecdes_N( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefecdes_N");
      gxTv_SdtAgendaNovedades_Agefecdes_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefecdes_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(0) ;
      SetDirty("Agefecdes_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefecdes_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Agefechas_N( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Agefechas_N");
      gxTv_SdtAgendaNovedades_Agefechas_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Agefechas_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(0) ;
      SetDirty("Agefechas_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Agefechas_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Legid_N( )
   {
      return gxTv_SdtAgendaNovedades_Legid_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Legid_N");
      gxTv_SdtAgendaNovedades_Legid_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Legid_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Legid_N = (byte)(0) ;
      SetDirty("Legid_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Legid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtAgendaNovedades_Ageliqnro_N( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro_N ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      SetDirty("Ageliqnro_N");
      gxTv_SdtAgendaNovedades_Ageliqnro_N = value ;
   }

   public void setgxTv_SdtAgendaNovedades_Ageliqnro_N_SetNull( )
   {
      gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(0) ;
      SetDirty("Ageliqnro_N");
   }

   public boolean getgxTv_SdtAgendaNovedades_Ageliqnro_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.agendanovedades_bc obj;
      obj = new web.agendanovedades_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Empnom = "" ;
      gxTv_SdtAgendaNovedades_Legapellido = "" ;
      gxTv_SdtAgendaNovedades_Legnombre = "" ;
      gxTv_SdtAgendaNovedades_Legfecegreso = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Concodigo = "" ;
      gxTv_SdtAgendaNovedades_Condescrip = "" ;
      gxTv_SdtAgendaNovedades_Agecanti = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Agevunit = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Ageimporte = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Agefecdes = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Agefechas = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Legid = "" ;
      gxTv_SdtAgendaNovedades_Mode = "" ;
      gxTv_SdtAgendaNovedades_Empnom_Z = "" ;
      gxTv_SdtAgendaNovedades_Legapellido_Z = "" ;
      gxTv_SdtAgendaNovedades_Legnombre_Z = "" ;
      gxTv_SdtAgendaNovedades_Legfecegreso_Z = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Concodigo_Z = "" ;
      gxTv_SdtAgendaNovedades_Condescrip_Z = "" ;
      gxTv_SdtAgendaNovedades_Agecanti_Z = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Agevunit_Z = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Ageimporte_Z = DecimalUtil.ZERO ;
      gxTv_SdtAgendaNovedades_Agefecdes_Z = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Agefechas_Z = GXutil.nullDate() ;
      gxTv_SdtAgendaNovedades_Legid_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtAgendaNovedades_N ;
   }

   public web.SdtAgendaNovedades Clone( )
   {
      web.SdtAgendaNovedades sdt;
      web.agendanovedades_bc obj;
      sdt = (web.SdtAgendaNovedades)(clone()) ;
      obj = (web.agendanovedades_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtAgendaNovedades struct )
   {
      setgxTv_SdtAgendaNovedades_Clicod(struct.getClicod());
      setgxTv_SdtAgendaNovedades_Empcod(struct.getEmpcod());
      setgxTv_SdtAgendaNovedades_Empnom(struct.getEmpnom());
      setgxTv_SdtAgendaNovedades_Legnumero(struct.getLegnumero());
      setgxTv_SdtAgendaNovedades_Legapellido(struct.getLegapellido());
      setgxTv_SdtAgendaNovedades_Legnombre(struct.getLegnombre());
      setgxTv_SdtAgendaNovedades_Legfecegreso(struct.getLegfecegreso());
      setgxTv_SdtAgendaNovedades_Ageorden(struct.getAgeorden());
      setgxTv_SdtAgendaNovedades_Concodigo(struct.getConcodigo());
      setgxTv_SdtAgendaNovedades_Condescrip(struct.getCondescrip());
      setgxTv_SdtAgendaNovedades_Agecanti(struct.getAgecanti());
      setgxTv_SdtAgendaNovedades_Agevunit(struct.getAgevunit());
      setgxTv_SdtAgendaNovedades_Ageimporte(struct.getAgeimporte());
      setgxTv_SdtAgendaNovedades_Agefecdes(struct.getAgefecdes());
      setgxTv_SdtAgendaNovedades_Agefechas(struct.getAgefechas());
      setgxTv_SdtAgendaNovedades_Agelegactivo(struct.getAgelegactivo());
      setgxTv_SdtAgendaNovedades_Legid(struct.getLegid());
      setgxTv_SdtAgendaNovedades_Concanti(struct.getConcanti());
      setgxTv_SdtAgendaNovedades_Convaluni(struct.getConvaluni());
      setgxTv_SdtAgendaNovedades_Conimporte(struct.getConimporte());
      setgxTv_SdtAgendaNovedades_Ageliqnro(struct.getAgeliqnro());
      setgxTv_SdtAgendaNovedades_Mode(struct.getMode());
      setgxTv_SdtAgendaNovedades_Initialized(struct.getInitialized());
      setgxTv_SdtAgendaNovedades_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtAgendaNovedades_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtAgendaNovedades_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtAgendaNovedades_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtAgendaNovedades_Legapellido_Z(struct.getLegapellido_Z());
      setgxTv_SdtAgendaNovedades_Legnombre_Z(struct.getLegnombre_Z());
      setgxTv_SdtAgendaNovedades_Legfecegreso_Z(struct.getLegfecegreso_Z());
      setgxTv_SdtAgendaNovedades_Ageorden_Z(struct.getAgeorden_Z());
      setgxTv_SdtAgendaNovedades_Concodigo_Z(struct.getConcodigo_Z());
      setgxTv_SdtAgendaNovedades_Condescrip_Z(struct.getCondescrip_Z());
      setgxTv_SdtAgendaNovedades_Agecanti_Z(struct.getAgecanti_Z());
      setgxTv_SdtAgendaNovedades_Agevunit_Z(struct.getAgevunit_Z());
      setgxTv_SdtAgendaNovedades_Ageimporte_Z(struct.getAgeimporte_Z());
      setgxTv_SdtAgendaNovedades_Agefecdes_Z(struct.getAgefecdes_Z());
      setgxTv_SdtAgendaNovedades_Agefechas_Z(struct.getAgefechas_Z());
      setgxTv_SdtAgendaNovedades_Agelegactivo_Z(struct.getAgelegactivo_Z());
      setgxTv_SdtAgendaNovedades_Legid_Z(struct.getLegid_Z());
      setgxTv_SdtAgendaNovedades_Concanti_Z(struct.getConcanti_Z());
      setgxTv_SdtAgendaNovedades_Convaluni_Z(struct.getConvaluni_Z());
      setgxTv_SdtAgendaNovedades_Conimporte_Z(struct.getConimporte_Z());
      setgxTv_SdtAgendaNovedades_Ageliqnro_Z(struct.getAgeliqnro_Z());
      setgxTv_SdtAgendaNovedades_Legfecegreso_N(struct.getLegfecegreso_N());
      setgxTv_SdtAgendaNovedades_Agecanti_N(struct.getAgecanti_N());
      setgxTv_SdtAgendaNovedades_Agevunit_N(struct.getAgevunit_N());
      setgxTv_SdtAgendaNovedades_Ageimporte_N(struct.getAgeimporte_N());
      setgxTv_SdtAgendaNovedades_Agefecdes_N(struct.getAgefecdes_N());
      setgxTv_SdtAgendaNovedades_Agefechas_N(struct.getAgefechas_N());
      setgxTv_SdtAgendaNovedades_Legid_N(struct.getLegid_N());
      setgxTv_SdtAgendaNovedades_Ageliqnro_N(struct.getAgeliqnro_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtAgendaNovedades getStruct( )
   {
      web.StructSdtAgendaNovedades struct = new web.StructSdtAgendaNovedades ();
      struct.setClicod(getgxTv_SdtAgendaNovedades_Clicod());
      struct.setEmpcod(getgxTv_SdtAgendaNovedades_Empcod());
      struct.setEmpnom(getgxTv_SdtAgendaNovedades_Empnom());
      struct.setLegnumero(getgxTv_SdtAgendaNovedades_Legnumero());
      struct.setLegapellido(getgxTv_SdtAgendaNovedades_Legapellido());
      struct.setLegnombre(getgxTv_SdtAgendaNovedades_Legnombre());
      struct.setLegfecegreso(getgxTv_SdtAgendaNovedades_Legfecegreso());
      struct.setAgeorden(getgxTv_SdtAgendaNovedades_Ageorden());
      struct.setConcodigo(getgxTv_SdtAgendaNovedades_Concodigo());
      struct.setCondescrip(getgxTv_SdtAgendaNovedades_Condescrip());
      struct.setAgecanti(getgxTv_SdtAgendaNovedades_Agecanti());
      struct.setAgevunit(getgxTv_SdtAgendaNovedades_Agevunit());
      struct.setAgeimporte(getgxTv_SdtAgendaNovedades_Ageimporte());
      struct.setAgefecdes(getgxTv_SdtAgendaNovedades_Agefecdes());
      struct.setAgefechas(getgxTv_SdtAgendaNovedades_Agefechas());
      struct.setAgelegactivo(getgxTv_SdtAgendaNovedades_Agelegactivo());
      struct.setLegid(getgxTv_SdtAgendaNovedades_Legid());
      struct.setConcanti(getgxTv_SdtAgendaNovedades_Concanti());
      struct.setConvaluni(getgxTv_SdtAgendaNovedades_Convaluni());
      struct.setConimporte(getgxTv_SdtAgendaNovedades_Conimporte());
      struct.setAgeliqnro(getgxTv_SdtAgendaNovedades_Ageliqnro());
      struct.setMode(getgxTv_SdtAgendaNovedades_Mode());
      struct.setInitialized(getgxTv_SdtAgendaNovedades_Initialized());
      struct.setClicod_Z(getgxTv_SdtAgendaNovedades_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtAgendaNovedades_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtAgendaNovedades_Empnom_Z());
      struct.setLegnumero_Z(getgxTv_SdtAgendaNovedades_Legnumero_Z());
      struct.setLegapellido_Z(getgxTv_SdtAgendaNovedades_Legapellido_Z());
      struct.setLegnombre_Z(getgxTv_SdtAgendaNovedades_Legnombre_Z());
      struct.setLegfecegreso_Z(getgxTv_SdtAgendaNovedades_Legfecegreso_Z());
      struct.setAgeorden_Z(getgxTv_SdtAgendaNovedades_Ageorden_Z());
      struct.setConcodigo_Z(getgxTv_SdtAgendaNovedades_Concodigo_Z());
      struct.setCondescrip_Z(getgxTv_SdtAgendaNovedades_Condescrip_Z());
      struct.setAgecanti_Z(getgxTv_SdtAgendaNovedades_Agecanti_Z());
      struct.setAgevunit_Z(getgxTv_SdtAgendaNovedades_Agevunit_Z());
      struct.setAgeimporte_Z(getgxTv_SdtAgendaNovedades_Ageimporte_Z());
      struct.setAgefecdes_Z(getgxTv_SdtAgendaNovedades_Agefecdes_Z());
      struct.setAgefechas_Z(getgxTv_SdtAgendaNovedades_Agefechas_Z());
      struct.setAgelegactivo_Z(getgxTv_SdtAgendaNovedades_Agelegactivo_Z());
      struct.setLegid_Z(getgxTv_SdtAgendaNovedades_Legid_Z());
      struct.setConcanti_Z(getgxTv_SdtAgendaNovedades_Concanti_Z());
      struct.setConvaluni_Z(getgxTv_SdtAgendaNovedades_Convaluni_Z());
      struct.setConimporte_Z(getgxTv_SdtAgendaNovedades_Conimporte_Z());
      struct.setAgeliqnro_Z(getgxTv_SdtAgendaNovedades_Ageliqnro_Z());
      struct.setLegfecegreso_N(getgxTv_SdtAgendaNovedades_Legfecegreso_N());
      struct.setAgecanti_N(getgxTv_SdtAgendaNovedades_Agecanti_N());
      struct.setAgevunit_N(getgxTv_SdtAgendaNovedades_Agevunit_N());
      struct.setAgeimporte_N(getgxTv_SdtAgendaNovedades_Ageimporte_N());
      struct.setAgefecdes_N(getgxTv_SdtAgendaNovedades_Agefecdes_N());
      struct.setAgefechas_N(getgxTv_SdtAgendaNovedades_Agefechas_N());
      struct.setLegid_N(getgxTv_SdtAgendaNovedades_Legid_N());
      struct.setAgeliqnro_N(getgxTv_SdtAgendaNovedades_Ageliqnro_N());
      return struct ;
   }

   private byte gxTv_SdtAgendaNovedades_N ;
   private byte gxTv_SdtAgendaNovedades_Legfecegreso_N ;
   private byte gxTv_SdtAgendaNovedades_Agecanti_N ;
   private byte gxTv_SdtAgendaNovedades_Agevunit_N ;
   private byte gxTv_SdtAgendaNovedades_Ageimporte_N ;
   private byte gxTv_SdtAgendaNovedades_Agefecdes_N ;
   private byte gxTv_SdtAgendaNovedades_Agefechas_N ;
   private byte gxTv_SdtAgendaNovedades_Legid_N ;
   private byte gxTv_SdtAgendaNovedades_Ageliqnro_N ;
   private short gxTv_SdtAgendaNovedades_Empcod ;
   private short gxTv_SdtAgendaNovedades_Ageorden ;
   private short gxTv_SdtAgendaNovedades_Initialized ;
   private short gxTv_SdtAgendaNovedades_Empcod_Z ;
   private short gxTv_SdtAgendaNovedades_Ageorden_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtAgendaNovedades_Clicod ;
   private int gxTv_SdtAgendaNovedades_Legnumero ;
   private int gxTv_SdtAgendaNovedades_Ageliqnro ;
   private int gxTv_SdtAgendaNovedades_Clicod_Z ;
   private int gxTv_SdtAgendaNovedades_Legnumero_Z ;
   private int gxTv_SdtAgendaNovedades_Ageliqnro_Z ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Agecanti ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Agevunit ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Ageimporte ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Agecanti_Z ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Agevunit_Z ;
   private java.math.BigDecimal gxTv_SdtAgendaNovedades_Ageimporte_Z ;
   private String gxTv_SdtAgendaNovedades_Concodigo ;
   private String gxTv_SdtAgendaNovedades_Legid ;
   private String gxTv_SdtAgendaNovedades_Mode ;
   private String gxTv_SdtAgendaNovedades_Concodigo_Z ;
   private String gxTv_SdtAgendaNovedades_Legid_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtAgendaNovedades_Legfecegreso ;
   private java.util.Date gxTv_SdtAgendaNovedades_Agefecdes ;
   private java.util.Date gxTv_SdtAgendaNovedades_Agefechas ;
   private java.util.Date gxTv_SdtAgendaNovedades_Legfecegreso_Z ;
   private java.util.Date gxTv_SdtAgendaNovedades_Agefecdes_Z ;
   private java.util.Date gxTv_SdtAgendaNovedades_Agefechas_Z ;
   private boolean gxTv_SdtAgendaNovedades_Agelegactivo ;
   private boolean gxTv_SdtAgendaNovedades_Concanti ;
   private boolean gxTv_SdtAgendaNovedades_Convaluni ;
   private boolean gxTv_SdtAgendaNovedades_Conimporte ;
   private boolean gxTv_SdtAgendaNovedades_Agelegactivo_Z ;
   private boolean gxTv_SdtAgendaNovedades_Concanti_Z ;
   private boolean gxTv_SdtAgendaNovedades_Convaluni_Z ;
   private boolean gxTv_SdtAgendaNovedades_Conimporte_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtAgendaNovedades_Empnom ;
   private String gxTv_SdtAgendaNovedades_Legapellido ;
   private String gxTv_SdtAgendaNovedades_Legnombre ;
   private String gxTv_SdtAgendaNovedades_Condescrip ;
   private String gxTv_SdtAgendaNovedades_Empnom_Z ;
   private String gxTv_SdtAgendaNovedades_Legapellido_Z ;
   private String gxTv_SdtAgendaNovedades_Legnombre_Z ;
   private String gxTv_SdtAgendaNovedades_Condescrip_Z ;
}

