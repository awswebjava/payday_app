package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtObligacion extends GxSilentTrnSdt
{
   public SdtObligacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtObligacion.class));
   }

   public SdtObligacion( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtObligacion");
      initialize( remoteHandle) ;
   }

   public SdtObligacion( int remoteHandle ,
                         StructSdtObligacion struct )
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
                     short AV1172OblSecuencial )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),Short.valueOf(AV1172OblSecuencial)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"OblSecuencial", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Obligacion");
      metadata.set("BT", "Obligacion");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"OblSecuencial\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"Excepciones\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"OblConCodigo-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"OblConcepto-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LiqNro\" ],\"FKMap\":[ \"OblLiqNro-LiqNro\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LiqNro\",\"LegNumero\" ],\"FKMap\":[ \"OblLiqNro-LiqNro\" ] },{ \"FK\":[ \"TipoOblSec\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtObligacion_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtObligacion_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtObligacion_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblSecuencial") )
            {
               gxTv_SdtObligacion_Oblsecuencial = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe") )
            {
               gxTv_SdtObligacion_Legidnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblSec") )
            {
               gxTv_SdtObligacion_Tipooblsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblDescrip") )
            {
               gxTv_SdtObligacion_Tipoobldescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblCodigo") )
            {
               gxTv_SdtObligacion_Tipooblcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblEstado") )
            {
               gxTv_SdtObligacion_Oblestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblObs") )
            {
               gxTv_SdtObligacion_Oblobs = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblOriPer") )
            {
               gxTv_SdtObligacion_Obloriper = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblTotTipo") )
            {
               gxTv_SdtObligacion_Tipoobltottipo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmbargaSec") )
            {
               gxTv_SdtObligacion_Embargasec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblConCodigo") )
            {
               gxTv_SdtObligacion_Oblconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblTotal") )
            {
               gxTv_SdtObligacion_Obltotal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblCanCuo") )
            {
               gxTv_SdtObligacion_Oblcancuo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblImpFij") )
            {
               gxTv_SdtObligacion_Oblimpfij = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblPorc") )
            {
               gxTv_SdtObligacion_Oblporc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblNoRemu") )
            {
               gxTv_SdtObligacion_Oblnoremu = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblDescu") )
            {
               gxTv_SdtObligacion_Obldescu = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblLiqNro") )
            {
               gxTv_SdtObligacion_Oblliqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblAntiRelaLiq") )
            {
               gxTv_SdtObligacion_Oblantirelaliq = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblConcepto") )
            {
               gxTv_SdtObligacion_Oblconcepto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblTipoMov") )
            {
               gxTv_SdtObligacion_Obltipomov = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblSoloDescu") )
            {
               gxTv_SdtObligacion_Tipooblsolodescu = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Excepciones") )
            {
               if ( gxTv_SdtObligacion_Excepciones == null )
               {
                  gxTv_SdtObligacion_Excepciones = new GXBCLevelCollection<web.SdtObligacion_Excepciones>(web.SdtObligacion_Excepciones.class, "Obligacion.Excepciones", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtObligacion_Excepciones.readxml(oReader, "Excepciones") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Excepciones") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtObligacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtObligacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtObligacion_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtObligacion_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtObligacion_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblSecuencial_Z") )
            {
               gxTv_SdtObligacion_Oblsecuencial_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe_Z") )
            {
               gxTv_SdtObligacion_Legidnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblSec_Z") )
            {
               gxTv_SdtObligacion_Tipooblsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblDescrip_Z") )
            {
               gxTv_SdtObligacion_Tipoobldescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblCodigo_Z") )
            {
               gxTv_SdtObligacion_Tipooblcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblEstado_Z") )
            {
               gxTv_SdtObligacion_Oblestado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblOriPer_Z") )
            {
               gxTv_SdtObligacion_Obloriper_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblTotTipo_Z") )
            {
               gxTv_SdtObligacion_Tipoobltottipo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmbargaSec_Z") )
            {
               gxTv_SdtObligacion_Embargasec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblConCodigo_Z") )
            {
               gxTv_SdtObligacion_Oblconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblTotal_Z") )
            {
               gxTv_SdtObligacion_Obltotal_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblCanCuo_Z") )
            {
               gxTv_SdtObligacion_Oblcancuo_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblImpFij_Z") )
            {
               gxTv_SdtObligacion_Oblimpfij_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblPorc_Z") )
            {
               gxTv_SdtObligacion_Oblporc_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblNoRemu_Z") )
            {
               gxTv_SdtObligacion_Oblnoremu_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblDescu_Z") )
            {
               gxTv_SdtObligacion_Obldescu_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblLiqNro_Z") )
            {
               gxTv_SdtObligacion_Oblliqnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblAntiRelaLiq_Z") )
            {
               gxTv_SdtObligacion_Oblantirelaliq_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblConcepto_Z") )
            {
               gxTv_SdtObligacion_Oblconcepto_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblTipoMov_Z") )
            {
               gxTv_SdtObligacion_Obltipomov_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoOblSoloDescu_Z") )
            {
               gxTv_SdtObligacion_Tipooblsolodescu_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmbargaSec_N") )
            {
               gxTv_SdtObligacion_Embargasec_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblConCodigo_N") )
            {
               gxTv_SdtObligacion_Oblconcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblLiqNro_N") )
            {
               gxTv_SdtObligacion_Oblliqnro_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Obligacion" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblSecuencial", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblsecuencial, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegIdNomApe", gxTv_SdtObligacion_Legidnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoOblSec", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Tipooblsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoOblDescrip", gxTv_SdtObligacion_Tipoobldescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoOblCodigo", gxTv_SdtObligacion_Tipooblcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblEstado", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblObs", gxTv_SdtObligacion_Oblobs);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblOriPer", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Obloriper, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoOblTotTipo", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Tipoobltottipo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmbargaSec", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Embargasec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblConCodigo", gxTv_SdtObligacion_Oblconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblTotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Obltotal, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblCanCuo", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblcancuo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblImpFij", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Oblimpfij, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblPorc", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Oblporc, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblNoRemu", GXutil.booltostr( gxTv_SdtObligacion_Oblnoremu));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblDescu", GXutil.booltostr( gxTv_SdtObligacion_Obldescu));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblLiqNro", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblliqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblAntiRelaLiq", GXutil.booltostr( gxTv_SdtObligacion_Oblantirelaliq));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblConcepto", gxTv_SdtObligacion_Oblconcepto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblTipoMov", gxTv_SdtObligacion_Obltipomov);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoOblSoloDescu", GXutil.booltostr( gxTv_SdtObligacion_Tipooblsolodescu));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtObligacion_Excepciones != null )
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
         gxTv_SdtObligacion_Excepciones.writexml(oWriter, "Excepciones", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtObligacion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblSecuencial_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblsecuencial_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegIdNomApe_Z", gxTv_SdtObligacion_Legidnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoOblSec_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Tipooblsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoOblDescrip_Z", gxTv_SdtObligacion_Tipoobldescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoOblCodigo_Z", gxTv_SdtObligacion_Tipooblcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblEstado_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblestado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblOriPer_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Obloriper_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoOblTotTipo_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Tipoobltottipo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmbargaSec_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Embargasec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblConCodigo_Z", gxTv_SdtObligacion_Oblconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblTotal_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Obltotal_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblCanCuo_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblcancuo_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblImpFij_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Oblimpfij_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblPorc_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtObligacion_Oblporc_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblNoRemu_Z", GXutil.booltostr( gxTv_SdtObligacion_Oblnoremu_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblDescu_Z", GXutil.booltostr( gxTv_SdtObligacion_Obldescu_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblLiqNro_Z", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblliqnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblAntiRelaLiq_Z", GXutil.booltostr( gxTv_SdtObligacion_Oblantirelaliq_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblConcepto_Z", gxTv_SdtObligacion_Oblconcepto_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblTipoMov_Z", gxTv_SdtObligacion_Obltipomov_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoOblSoloDescu_Z", GXutil.booltostr( gxTv_SdtObligacion_Tipooblsolodescu_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmbargaSec_N", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Embargasec_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblConCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblconcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblLiqNro_N", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Oblliqnro_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtObligacion_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtObligacion_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtObligacion_Legnumero, false, includeNonInitialized);
      AddObjectProperty("OblSecuencial", gxTv_SdtObligacion_Oblsecuencial, false, includeNonInitialized);
      AddObjectProperty("LegIdNomApe", gxTv_SdtObligacion_Legidnomape, false, includeNonInitialized);
      AddObjectProperty("TipoOblSec", gxTv_SdtObligacion_Tipooblsec, false, includeNonInitialized);
      AddObjectProperty("TipoOblDescrip", gxTv_SdtObligacion_Tipoobldescrip, false, includeNonInitialized);
      AddObjectProperty("TipoOblCodigo", gxTv_SdtObligacion_Tipooblcodigo, false, includeNonInitialized);
      AddObjectProperty("OblEstado", gxTv_SdtObligacion_Oblestado, false, includeNonInitialized);
      AddObjectProperty("OblObs", gxTv_SdtObligacion_Oblobs, false, includeNonInitialized);
      AddObjectProperty("OblOriPer", gxTv_SdtObligacion_Obloriper, false, includeNonInitialized);
      AddObjectProperty("TipoOblTotTipo", gxTv_SdtObligacion_Tipoobltottipo, false, includeNonInitialized);
      AddObjectProperty("EmbargaSec", gxTv_SdtObligacion_Embargasec, false, includeNonInitialized);
      AddObjectProperty("EmbargaSec_N", gxTv_SdtObligacion_Embargasec_N, false, includeNonInitialized);
      AddObjectProperty("OblConCodigo", gxTv_SdtObligacion_Oblconcodigo, false, includeNonInitialized);
      AddObjectProperty("OblConCodigo_N", gxTv_SdtObligacion_Oblconcodigo_N, false, includeNonInitialized);
      AddObjectProperty("OblTotal", gxTv_SdtObligacion_Obltotal, false, includeNonInitialized);
      AddObjectProperty("OblCanCuo", gxTv_SdtObligacion_Oblcancuo, false, includeNonInitialized);
      AddObjectProperty("OblImpFij", gxTv_SdtObligacion_Oblimpfij, false, includeNonInitialized);
      AddObjectProperty("OblPorc", gxTv_SdtObligacion_Oblporc, false, includeNonInitialized);
      AddObjectProperty("OblNoRemu", gxTv_SdtObligacion_Oblnoremu, false, includeNonInitialized);
      AddObjectProperty("OblDescu", gxTv_SdtObligacion_Obldescu, false, includeNonInitialized);
      AddObjectProperty("OblLiqNro", gxTv_SdtObligacion_Oblliqnro, false, includeNonInitialized);
      AddObjectProperty("OblLiqNro_N", gxTv_SdtObligacion_Oblliqnro_N, false, includeNonInitialized);
      AddObjectProperty("OblAntiRelaLiq", gxTv_SdtObligacion_Oblantirelaliq, false, includeNonInitialized);
      AddObjectProperty("OblConcepto", gxTv_SdtObligacion_Oblconcepto, false, includeNonInitialized);
      AddObjectProperty("OblTipoMov", gxTv_SdtObligacion_Obltipomov, false, includeNonInitialized);
      AddObjectProperty("TipoOblSoloDescu", gxTv_SdtObligacion_Tipooblsolodescu, false, includeNonInitialized);
      if ( gxTv_SdtObligacion_Excepciones != null )
      {
         AddObjectProperty("Excepciones", gxTv_SdtObligacion_Excepciones, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtObligacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtObligacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtObligacion_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtObligacion_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtObligacion_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("OblSecuencial_Z", gxTv_SdtObligacion_Oblsecuencial_Z, false, includeNonInitialized);
         AddObjectProperty("LegIdNomApe_Z", gxTv_SdtObligacion_Legidnomape_Z, false, includeNonInitialized);
         AddObjectProperty("TipoOblSec_Z", gxTv_SdtObligacion_Tipooblsec_Z, false, includeNonInitialized);
         AddObjectProperty("TipoOblDescrip_Z", gxTv_SdtObligacion_Tipoobldescrip_Z, false, includeNonInitialized);
         AddObjectProperty("TipoOblCodigo_Z", gxTv_SdtObligacion_Tipooblcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("OblEstado_Z", gxTv_SdtObligacion_Oblestado_Z, false, includeNonInitialized);
         AddObjectProperty("OblOriPer_Z", gxTv_SdtObligacion_Obloriper_Z, false, includeNonInitialized);
         AddObjectProperty("TipoOblTotTipo_Z", gxTv_SdtObligacion_Tipoobltottipo_Z, false, includeNonInitialized);
         AddObjectProperty("EmbargaSec_Z", gxTv_SdtObligacion_Embargasec_Z, false, includeNonInitialized);
         AddObjectProperty("OblConCodigo_Z", gxTv_SdtObligacion_Oblconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("OblTotal_Z", gxTv_SdtObligacion_Obltotal_Z, false, includeNonInitialized);
         AddObjectProperty("OblCanCuo_Z", gxTv_SdtObligacion_Oblcancuo_Z, false, includeNonInitialized);
         AddObjectProperty("OblImpFij_Z", gxTv_SdtObligacion_Oblimpfij_Z, false, includeNonInitialized);
         AddObjectProperty("OblPorc_Z", gxTv_SdtObligacion_Oblporc_Z, false, includeNonInitialized);
         AddObjectProperty("OblNoRemu_Z", gxTv_SdtObligacion_Oblnoremu_Z, false, includeNonInitialized);
         AddObjectProperty("OblDescu_Z", gxTv_SdtObligacion_Obldescu_Z, false, includeNonInitialized);
         AddObjectProperty("OblLiqNro_Z", gxTv_SdtObligacion_Oblliqnro_Z, false, includeNonInitialized);
         AddObjectProperty("OblAntiRelaLiq_Z", gxTv_SdtObligacion_Oblantirelaliq_Z, false, includeNonInitialized);
         AddObjectProperty("OblConcepto_Z", gxTv_SdtObligacion_Oblconcepto_Z, false, includeNonInitialized);
         AddObjectProperty("OblTipoMov_Z", gxTv_SdtObligacion_Obltipomov_Z, false, includeNonInitialized);
         AddObjectProperty("TipoOblSoloDescu_Z", gxTv_SdtObligacion_Tipooblsolodescu_Z, false, includeNonInitialized);
         AddObjectProperty("EmbargaSec_N", gxTv_SdtObligacion_Embargasec_N, false, includeNonInitialized);
         AddObjectProperty("OblConCodigo_N", gxTv_SdtObligacion_Oblconcodigo_N, false, includeNonInitialized);
         AddObjectProperty("OblLiqNro_N", gxTv_SdtObligacion_Oblliqnro_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtObligacion sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Clicod = sdt.getgxTv_SdtObligacion_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Empcod = sdt.getgxTv_SdtObligacion_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Legnumero = sdt.getgxTv_SdtObligacion_Legnumero() ;
      }
      if ( sdt.IsDirty("OblSecuencial") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblsecuencial = sdt.getgxTv_SdtObligacion_Oblsecuencial() ;
      }
      if ( sdt.IsDirty("LegIdNomApe") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Legidnomape = sdt.getgxTv_SdtObligacion_Legidnomape() ;
      }
      if ( sdt.IsDirty("TipoOblSec") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Tipooblsec = sdt.getgxTv_SdtObligacion_Tipooblsec() ;
      }
      if ( sdt.IsDirty("TipoOblDescrip") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Tipoobldescrip = sdt.getgxTv_SdtObligacion_Tipoobldescrip() ;
      }
      if ( sdt.IsDirty("TipoOblCodigo") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Tipooblcodigo = sdt.getgxTv_SdtObligacion_Tipooblcodigo() ;
      }
      if ( sdt.IsDirty("OblEstado") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblestado = sdt.getgxTv_SdtObligacion_Oblestado() ;
      }
      if ( sdt.IsDirty("OblObs") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblobs = sdt.getgxTv_SdtObligacion_Oblobs() ;
      }
      if ( sdt.IsDirty("OblOriPer") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Obloriper = sdt.getgxTv_SdtObligacion_Obloriper() ;
      }
      if ( sdt.IsDirty("TipoOblTotTipo") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Tipoobltottipo = sdt.getgxTv_SdtObligacion_Tipoobltottipo() ;
      }
      if ( sdt.IsDirty("EmbargaSec") )
      {
         gxTv_SdtObligacion_Embargasec_N = sdt.getgxTv_SdtObligacion_Embargasec_N() ;
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Embargasec = sdt.getgxTv_SdtObligacion_Embargasec() ;
      }
      if ( sdt.IsDirty("OblConCodigo") )
      {
         gxTv_SdtObligacion_Oblconcodigo_N = sdt.getgxTv_SdtObligacion_Oblconcodigo_N() ;
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblconcodigo = sdt.getgxTv_SdtObligacion_Oblconcodigo() ;
      }
      if ( sdt.IsDirty("OblTotal") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Obltotal = sdt.getgxTv_SdtObligacion_Obltotal() ;
      }
      if ( sdt.IsDirty("OblCanCuo") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblcancuo = sdt.getgxTv_SdtObligacion_Oblcancuo() ;
      }
      if ( sdt.IsDirty("OblImpFij") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblimpfij = sdt.getgxTv_SdtObligacion_Oblimpfij() ;
      }
      if ( sdt.IsDirty("OblPorc") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblporc = sdt.getgxTv_SdtObligacion_Oblporc() ;
      }
      if ( sdt.IsDirty("OblNoRemu") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblnoremu = sdt.getgxTv_SdtObligacion_Oblnoremu() ;
      }
      if ( sdt.IsDirty("OblDescu") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Obldescu = sdt.getgxTv_SdtObligacion_Obldescu() ;
      }
      if ( sdt.IsDirty("OblLiqNro") )
      {
         gxTv_SdtObligacion_Oblliqnro_N = sdt.getgxTv_SdtObligacion_Oblliqnro_N() ;
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblliqnro = sdt.getgxTv_SdtObligacion_Oblliqnro() ;
      }
      if ( sdt.IsDirty("OblAntiRelaLiq") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblantirelaliq = sdt.getgxTv_SdtObligacion_Oblantirelaliq() ;
      }
      if ( sdt.IsDirty("OblConcepto") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Oblconcepto = sdt.getgxTv_SdtObligacion_Oblconcepto() ;
      }
      if ( sdt.IsDirty("OblTipoMov") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Obltipomov = sdt.getgxTv_SdtObligacion_Obltipomov() ;
      }
      if ( sdt.IsDirty("TipoOblSoloDescu") )
      {
         gxTv_SdtObligacion_N = (byte)(0) ;
         gxTv_SdtObligacion_Tipooblsolodescu = sdt.getgxTv_SdtObligacion_Tipooblsolodescu() ;
      }
      if ( gxTv_SdtObligacion_Excepciones != null )
      {
         GXBCLevelCollection<web.SdtObligacion_Excepciones> newCollectionExcepciones = sdt.getgxTv_SdtObligacion_Excepciones();
         web.SdtObligacion_Excepciones currItemExcepciones;
         web.SdtObligacion_Excepciones newItemExcepciones;
         short idx = 1;
         while ( idx <= newCollectionExcepciones.size() )
         {
            newItemExcepciones = (web.SdtObligacion_Excepciones)((web.SdtObligacion_Excepciones)newCollectionExcepciones.elementAt(-1+idx));
            currItemExcepciones = (web.SdtObligacion_Excepciones)gxTv_SdtObligacion_Excepciones.getByKey(newItemExcepciones.getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo());
            if ( GXutil.strcmp(currItemExcepciones.getgxTv_SdtObligacion_Excepciones_Mode(), "UPD") == 0 )
            {
               currItemExcepciones.updateDirties(newItemExcepciones);
               if ( GXutil.strcmp(newItemExcepciones.getgxTv_SdtObligacion_Excepciones_Mode(), "DLT") == 0 )
               {
                  currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Mode( "DLT" );
               }
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtObligacion_Excepciones.add(newItemExcepciones, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtObligacion_Clicod( )
   {
      return gxTv_SdtObligacion_Clicod ;
   }

   public void setgxTv_SdtObligacion_Clicod( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      if ( gxTv_SdtObligacion_Clicod != value )
      {
         gxTv_SdtObligacion_Mode = "INS" ;
         this.setgxTv_SdtObligacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legnumero_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblsecuencial_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobldescrip_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblestado_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obloriper_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobltottipo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Embargasec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltotal_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblcancuo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblimpfij_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblporc_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblnoremu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obldescu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblliqnro_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblantirelaliq_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcepto_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltipomov_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsolodescu_Z_SetNull( );
         if ( gxTv_SdtObligacion_Excepciones != null )
         {
            GXBCLevelCollection<web.SdtObligacion_Excepciones> collectionExcepciones = gxTv_SdtObligacion_Excepciones;
            web.SdtObligacion_Excepciones currItemExcepciones;
            short idx = 1;
            while ( idx <= collectionExcepciones.size() )
            {
               currItemExcepciones = (web.SdtObligacion_Excepciones)((web.SdtObligacion_Excepciones)collectionExcepciones.elementAt(-1+idx));
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Mode( "INS" );
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtObligacion_Clicod = value ;
   }

   public short getgxTv_SdtObligacion_Empcod( )
   {
      return gxTv_SdtObligacion_Empcod ;
   }

   public void setgxTv_SdtObligacion_Empcod( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      if ( gxTv_SdtObligacion_Empcod != value )
      {
         gxTv_SdtObligacion_Mode = "INS" ;
         this.setgxTv_SdtObligacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legnumero_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblsecuencial_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobldescrip_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblestado_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obloriper_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobltottipo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Embargasec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltotal_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblcancuo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblimpfij_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblporc_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblnoremu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obldescu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblliqnro_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblantirelaliq_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcepto_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltipomov_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsolodescu_Z_SetNull( );
         if ( gxTv_SdtObligacion_Excepciones != null )
         {
            GXBCLevelCollection<web.SdtObligacion_Excepciones> collectionExcepciones = gxTv_SdtObligacion_Excepciones;
            web.SdtObligacion_Excepciones currItemExcepciones;
            short idx = 1;
            while ( idx <= collectionExcepciones.size() )
            {
               currItemExcepciones = (web.SdtObligacion_Excepciones)((web.SdtObligacion_Excepciones)collectionExcepciones.elementAt(-1+idx));
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Mode( "INS" );
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Empcod");
      gxTv_SdtObligacion_Empcod = value ;
   }

   public int getgxTv_SdtObligacion_Legnumero( )
   {
      return gxTv_SdtObligacion_Legnumero ;
   }

   public void setgxTv_SdtObligacion_Legnumero( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      if ( gxTv_SdtObligacion_Legnumero != value )
      {
         gxTv_SdtObligacion_Mode = "INS" ;
         this.setgxTv_SdtObligacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legnumero_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblsecuencial_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobldescrip_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblestado_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obloriper_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobltottipo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Embargasec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltotal_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblcancuo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblimpfij_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblporc_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblnoremu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obldescu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblliqnro_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblantirelaliq_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcepto_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltipomov_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsolodescu_Z_SetNull( );
         if ( gxTv_SdtObligacion_Excepciones != null )
         {
            GXBCLevelCollection<web.SdtObligacion_Excepciones> collectionExcepciones = gxTv_SdtObligacion_Excepciones;
            web.SdtObligacion_Excepciones currItemExcepciones;
            short idx = 1;
            while ( idx <= collectionExcepciones.size() )
            {
               currItemExcepciones = (web.SdtObligacion_Excepciones)((web.SdtObligacion_Excepciones)collectionExcepciones.elementAt(-1+idx));
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Mode( "INS" );
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Legnumero");
      gxTv_SdtObligacion_Legnumero = value ;
   }

   public short getgxTv_SdtObligacion_Oblsecuencial( )
   {
      return gxTv_SdtObligacion_Oblsecuencial ;
   }

   public void setgxTv_SdtObligacion_Oblsecuencial( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      if ( gxTv_SdtObligacion_Oblsecuencial != value )
      {
         gxTv_SdtObligacion_Mode = "INS" ;
         this.setgxTv_SdtObligacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legnumero_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblsecuencial_Z_SetNull( );
         this.setgxTv_SdtObligacion_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobldescrip_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblestado_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obloriper_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipoobltottipo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Embargasec_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcodigo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltotal_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblcancuo_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblimpfij_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblporc_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblnoremu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obldescu_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblliqnro_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblantirelaliq_Z_SetNull( );
         this.setgxTv_SdtObligacion_Oblconcepto_Z_SetNull( );
         this.setgxTv_SdtObligacion_Obltipomov_Z_SetNull( );
         this.setgxTv_SdtObligacion_Tipooblsolodescu_Z_SetNull( );
         if ( gxTv_SdtObligacion_Excepciones != null )
         {
            GXBCLevelCollection<web.SdtObligacion_Excepciones> collectionExcepciones = gxTv_SdtObligacion_Excepciones;
            web.SdtObligacion_Excepciones currItemExcepciones;
            short idx = 1;
            while ( idx <= collectionExcepciones.size() )
            {
               currItemExcepciones = (web.SdtObligacion_Excepciones)((web.SdtObligacion_Excepciones)collectionExcepciones.elementAt(-1+idx));
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Mode( "INS" );
               currItemExcepciones.setgxTv_SdtObligacion_Excepciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Oblsecuencial");
      gxTv_SdtObligacion_Oblsecuencial = value ;
   }

   public String getgxTv_SdtObligacion_Legidnomape( )
   {
      return gxTv_SdtObligacion_Legidnomape ;
   }

   public void setgxTv_SdtObligacion_Legidnomape( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Legidnomape");
      gxTv_SdtObligacion_Legidnomape = value ;
   }

   public short getgxTv_SdtObligacion_Tipooblsec( )
   {
      return gxTv_SdtObligacion_Tipooblsec ;
   }

   public void setgxTv_SdtObligacion_Tipooblsec( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblsec");
      gxTv_SdtObligacion_Tipooblsec = value ;
   }

   public String getgxTv_SdtObligacion_Tipoobldescrip( )
   {
      return gxTv_SdtObligacion_Tipoobldescrip ;
   }

   public void setgxTv_SdtObligacion_Tipoobldescrip( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipoobldescrip");
      gxTv_SdtObligacion_Tipoobldescrip = value ;
   }

   public String getgxTv_SdtObligacion_Tipooblcodigo( )
   {
      return gxTv_SdtObligacion_Tipooblcodigo ;
   }

   public void setgxTv_SdtObligacion_Tipooblcodigo( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblcodigo");
      gxTv_SdtObligacion_Tipooblcodigo = value ;
   }

   public byte getgxTv_SdtObligacion_Oblestado( )
   {
      return gxTv_SdtObligacion_Oblestado ;
   }

   public void setgxTv_SdtObligacion_Oblestado( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblestado");
      gxTv_SdtObligacion_Oblestado = value ;
   }

   public String getgxTv_SdtObligacion_Oblobs( )
   {
      return gxTv_SdtObligacion_Oblobs ;
   }

   public void setgxTv_SdtObligacion_Oblobs( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblobs");
      gxTv_SdtObligacion_Oblobs = value ;
   }

   public byte getgxTv_SdtObligacion_Obloriper( )
   {
      return gxTv_SdtObligacion_Obloriper ;
   }

   public void setgxTv_SdtObligacion_Obloriper( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obloriper");
      gxTv_SdtObligacion_Obloriper = value ;
   }

   public byte getgxTv_SdtObligacion_Tipoobltottipo( )
   {
      return gxTv_SdtObligacion_Tipoobltottipo ;
   }

   public void setgxTv_SdtObligacion_Tipoobltottipo( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipoobltottipo");
      gxTv_SdtObligacion_Tipoobltottipo = value ;
   }

   public short getgxTv_SdtObligacion_Embargasec( )
   {
      return gxTv_SdtObligacion_Embargasec ;
   }

   public void setgxTv_SdtObligacion_Embargasec( short value )
   {
      gxTv_SdtObligacion_Embargasec_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Embargasec");
      gxTv_SdtObligacion_Embargasec = value ;
   }

   public void setgxTv_SdtObligacion_Embargasec_SetNull( )
   {
      gxTv_SdtObligacion_Embargasec_N = (byte)(1) ;
      gxTv_SdtObligacion_Embargasec = (short)(0) ;
      SetDirty("Embargasec");
   }

   public boolean getgxTv_SdtObligacion_Embargasec_IsNull( )
   {
      return (gxTv_SdtObligacion_Embargasec_N==1) ;
   }

   public String getgxTv_SdtObligacion_Oblconcodigo( )
   {
      return gxTv_SdtObligacion_Oblconcodigo ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo( String value )
   {
      gxTv_SdtObligacion_Oblconcodigo_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblconcodigo");
      gxTv_SdtObligacion_Oblconcodigo = value ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo_SetNull( )
   {
      gxTv_SdtObligacion_Oblconcodigo_N = (byte)(1) ;
      gxTv_SdtObligacion_Oblconcodigo = "" ;
      SetDirty("Oblconcodigo");
   }

   public boolean getgxTv_SdtObligacion_Oblconcodigo_IsNull( )
   {
      return (gxTv_SdtObligacion_Oblconcodigo_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Obltotal( )
   {
      return gxTv_SdtObligacion_Obltotal ;
   }

   public void setgxTv_SdtObligacion_Obltotal( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obltotal");
      gxTv_SdtObligacion_Obltotal = value ;
   }

   public short getgxTv_SdtObligacion_Oblcancuo( )
   {
      return gxTv_SdtObligacion_Oblcancuo ;
   }

   public void setgxTv_SdtObligacion_Oblcancuo( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblcancuo");
      gxTv_SdtObligacion_Oblcancuo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Oblimpfij( )
   {
      return gxTv_SdtObligacion_Oblimpfij ;
   }

   public void setgxTv_SdtObligacion_Oblimpfij( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblimpfij");
      gxTv_SdtObligacion_Oblimpfij = value ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Oblporc( )
   {
      return gxTv_SdtObligacion_Oblporc ;
   }

   public void setgxTv_SdtObligacion_Oblporc( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblporc");
      gxTv_SdtObligacion_Oblporc = value ;
   }

   public boolean getgxTv_SdtObligacion_Oblnoremu( )
   {
      return gxTv_SdtObligacion_Oblnoremu ;
   }

   public void setgxTv_SdtObligacion_Oblnoremu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblnoremu");
      gxTv_SdtObligacion_Oblnoremu = value ;
   }

   public boolean getgxTv_SdtObligacion_Obldescu( )
   {
      return gxTv_SdtObligacion_Obldescu ;
   }

   public void setgxTv_SdtObligacion_Obldescu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obldescu");
      gxTv_SdtObligacion_Obldescu = value ;
   }

   public int getgxTv_SdtObligacion_Oblliqnro( )
   {
      return gxTv_SdtObligacion_Oblliqnro ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro( int value )
   {
      gxTv_SdtObligacion_Oblliqnro_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblliqnro");
      gxTv_SdtObligacion_Oblliqnro = value ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro_SetNull( )
   {
      gxTv_SdtObligacion_Oblliqnro_N = (byte)(1) ;
      gxTv_SdtObligacion_Oblliqnro = 0 ;
      SetDirty("Oblliqnro");
   }

   public boolean getgxTv_SdtObligacion_Oblliqnro_IsNull( )
   {
      return (gxTv_SdtObligacion_Oblliqnro_N==1) ;
   }

   public boolean getgxTv_SdtObligacion_Oblantirelaliq( )
   {
      return gxTv_SdtObligacion_Oblantirelaliq ;
   }

   public void setgxTv_SdtObligacion_Oblantirelaliq( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblantirelaliq");
      gxTv_SdtObligacion_Oblantirelaliq = value ;
   }

   public String getgxTv_SdtObligacion_Oblconcepto( )
   {
      return gxTv_SdtObligacion_Oblconcepto ;
   }

   public void setgxTv_SdtObligacion_Oblconcepto( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblconcepto");
      gxTv_SdtObligacion_Oblconcepto = value ;
   }

   public String getgxTv_SdtObligacion_Obltipomov( )
   {
      return gxTv_SdtObligacion_Obltipomov ;
   }

   public void setgxTv_SdtObligacion_Obltipomov( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obltipomov");
      gxTv_SdtObligacion_Obltipomov = value ;
   }

   public boolean getgxTv_SdtObligacion_Tipooblsolodescu( )
   {
      return gxTv_SdtObligacion_Tipooblsolodescu ;
   }

   public void setgxTv_SdtObligacion_Tipooblsolodescu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblsolodescu");
      gxTv_SdtObligacion_Tipooblsolodescu = value ;
   }

   public GXBCLevelCollection<web.SdtObligacion_Excepciones> getgxTv_SdtObligacion_Excepciones( )
   {
      if ( gxTv_SdtObligacion_Excepciones == null )
      {
         gxTv_SdtObligacion_Excepciones = new GXBCLevelCollection<web.SdtObligacion_Excepciones>(web.SdtObligacion_Excepciones.class, "Obligacion.Excepciones", "PayDay", remoteHandle);
      }
      gxTv_SdtObligacion_N = (byte)(0) ;
      return gxTv_SdtObligacion_Excepciones ;
   }

   public void setgxTv_SdtObligacion_Excepciones( GXBCLevelCollection<web.SdtObligacion_Excepciones> value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Excepciones");
      gxTv_SdtObligacion_Excepciones = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones = null ;
      SetDirty("Excepciones");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_IsNull( )
   {
      if ( gxTv_SdtObligacion_Excepciones == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtObligacion_Mode( )
   {
      return gxTv_SdtObligacion_Mode ;
   }

   public void setgxTv_SdtObligacion_Mode( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtObligacion_Mode = value ;
   }

   public void setgxTv_SdtObligacion_Mode_SetNull( )
   {
      gxTv_SdtObligacion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtObligacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Initialized( )
   {
      return gxTv_SdtObligacion_Initialized ;
   }

   public void setgxTv_SdtObligacion_Initialized( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtObligacion_Initialized = value ;
   }

   public void setgxTv_SdtObligacion_Initialized_SetNull( )
   {
      gxTv_SdtObligacion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtObligacion_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtObligacion_Clicod_Z( )
   {
      return gxTv_SdtObligacion_Clicod_Z ;
   }

   public void setgxTv_SdtObligacion_Clicod_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtObligacion_Clicod_Z = value ;
   }

   public void setgxTv_SdtObligacion_Clicod_Z_SetNull( )
   {
      gxTv_SdtObligacion_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtObligacion_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Empcod_Z( )
   {
      return gxTv_SdtObligacion_Empcod_Z ;
   }

   public void setgxTv_SdtObligacion_Empcod_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtObligacion_Empcod_Z = value ;
   }

   public void setgxTv_SdtObligacion_Empcod_Z_SetNull( )
   {
      gxTv_SdtObligacion_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtObligacion_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtObligacion_Legnumero_Z( )
   {
      return gxTv_SdtObligacion_Legnumero_Z ;
   }

   public void setgxTv_SdtObligacion_Legnumero_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtObligacion_Legnumero_Z = value ;
   }

   public void setgxTv_SdtObligacion_Legnumero_Z_SetNull( )
   {
      gxTv_SdtObligacion_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtObligacion_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Oblsecuencial_Z( )
   {
      return gxTv_SdtObligacion_Oblsecuencial_Z ;
   }

   public void setgxTv_SdtObligacion_Oblsecuencial_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblsecuencial_Z");
      gxTv_SdtObligacion_Oblsecuencial_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblsecuencial_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblsecuencial_Z = (short)(0) ;
      SetDirty("Oblsecuencial_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblsecuencial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Legidnomape_Z( )
   {
      return gxTv_SdtObligacion_Legidnomape_Z ;
   }

   public void setgxTv_SdtObligacion_Legidnomape_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Legidnomape_Z");
      gxTv_SdtObligacion_Legidnomape_Z = value ;
   }

   public void setgxTv_SdtObligacion_Legidnomape_Z_SetNull( )
   {
      gxTv_SdtObligacion_Legidnomape_Z = "" ;
      SetDirty("Legidnomape_Z");
   }

   public boolean getgxTv_SdtObligacion_Legidnomape_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Tipooblsec_Z( )
   {
      return gxTv_SdtObligacion_Tipooblsec_Z ;
   }

   public void setgxTv_SdtObligacion_Tipooblsec_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblsec_Z");
      gxTv_SdtObligacion_Tipooblsec_Z = value ;
   }

   public void setgxTv_SdtObligacion_Tipooblsec_Z_SetNull( )
   {
      gxTv_SdtObligacion_Tipooblsec_Z = (short)(0) ;
      SetDirty("Tipooblsec_Z");
   }

   public boolean getgxTv_SdtObligacion_Tipooblsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Tipoobldescrip_Z( )
   {
      return gxTv_SdtObligacion_Tipoobldescrip_Z ;
   }

   public void setgxTv_SdtObligacion_Tipoobldescrip_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipoobldescrip_Z");
      gxTv_SdtObligacion_Tipoobldescrip_Z = value ;
   }

   public void setgxTv_SdtObligacion_Tipoobldescrip_Z_SetNull( )
   {
      gxTv_SdtObligacion_Tipoobldescrip_Z = "" ;
      SetDirty("Tipoobldescrip_Z");
   }

   public boolean getgxTv_SdtObligacion_Tipoobldescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Tipooblcodigo_Z( )
   {
      return gxTv_SdtObligacion_Tipooblcodigo_Z ;
   }

   public void setgxTv_SdtObligacion_Tipooblcodigo_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblcodigo_Z");
      gxTv_SdtObligacion_Tipooblcodigo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Tipooblcodigo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Tipooblcodigo_Z = "" ;
      SetDirty("Tipooblcodigo_Z");
   }

   public boolean getgxTv_SdtObligacion_Tipooblcodigo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Oblestado_Z( )
   {
      return gxTv_SdtObligacion_Oblestado_Z ;
   }

   public void setgxTv_SdtObligacion_Oblestado_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblestado_Z");
      gxTv_SdtObligacion_Oblestado_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblestado_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblestado_Z = (byte)(0) ;
      SetDirty("Oblestado_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblestado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Obloriper_Z( )
   {
      return gxTv_SdtObligacion_Obloriper_Z ;
   }

   public void setgxTv_SdtObligacion_Obloriper_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obloriper_Z");
      gxTv_SdtObligacion_Obloriper_Z = value ;
   }

   public void setgxTv_SdtObligacion_Obloriper_Z_SetNull( )
   {
      gxTv_SdtObligacion_Obloriper_Z = (byte)(0) ;
      SetDirty("Obloriper_Z");
   }

   public boolean getgxTv_SdtObligacion_Obloriper_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Tipoobltottipo_Z( )
   {
      return gxTv_SdtObligacion_Tipoobltottipo_Z ;
   }

   public void setgxTv_SdtObligacion_Tipoobltottipo_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipoobltottipo_Z");
      gxTv_SdtObligacion_Tipoobltottipo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Tipoobltottipo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Tipoobltottipo_Z = (byte)(0) ;
      SetDirty("Tipoobltottipo_Z");
   }

   public boolean getgxTv_SdtObligacion_Tipoobltottipo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Embargasec_Z( )
   {
      return gxTv_SdtObligacion_Embargasec_Z ;
   }

   public void setgxTv_SdtObligacion_Embargasec_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Embargasec_Z");
      gxTv_SdtObligacion_Embargasec_Z = value ;
   }

   public void setgxTv_SdtObligacion_Embargasec_Z_SetNull( )
   {
      gxTv_SdtObligacion_Embargasec_Z = (short)(0) ;
      SetDirty("Embargasec_Z");
   }

   public boolean getgxTv_SdtObligacion_Embargasec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Oblconcodigo_Z( )
   {
      return gxTv_SdtObligacion_Oblconcodigo_Z ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblconcodigo_Z");
      gxTv_SdtObligacion_Oblconcodigo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblconcodigo_Z = "" ;
      SetDirty("Oblconcodigo_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Obltotal_Z( )
   {
      return gxTv_SdtObligacion_Obltotal_Z ;
   }

   public void setgxTv_SdtObligacion_Obltotal_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obltotal_Z");
      gxTv_SdtObligacion_Obltotal_Z = value ;
   }

   public void setgxTv_SdtObligacion_Obltotal_Z_SetNull( )
   {
      gxTv_SdtObligacion_Obltotal_Z = DecimalUtil.ZERO ;
      SetDirty("Obltotal_Z");
   }

   public boolean getgxTv_SdtObligacion_Obltotal_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Oblcancuo_Z( )
   {
      return gxTv_SdtObligacion_Oblcancuo_Z ;
   }

   public void setgxTv_SdtObligacion_Oblcancuo_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblcancuo_Z");
      gxTv_SdtObligacion_Oblcancuo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblcancuo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblcancuo_Z = (short)(0) ;
      SetDirty("Oblcancuo_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblcancuo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Oblimpfij_Z( )
   {
      return gxTv_SdtObligacion_Oblimpfij_Z ;
   }

   public void setgxTv_SdtObligacion_Oblimpfij_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblimpfij_Z");
      gxTv_SdtObligacion_Oblimpfij_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblimpfij_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblimpfij_Z = DecimalUtil.ZERO ;
      SetDirty("Oblimpfij_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblimpfij_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtObligacion_Oblporc_Z( )
   {
      return gxTv_SdtObligacion_Oblporc_Z ;
   }

   public void setgxTv_SdtObligacion_Oblporc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblporc_Z");
      gxTv_SdtObligacion_Oblporc_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblporc_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblporc_Z = DecimalUtil.ZERO ;
      SetDirty("Oblporc_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblporc_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtObligacion_Oblnoremu_Z( )
   {
      return gxTv_SdtObligacion_Oblnoremu_Z ;
   }

   public void setgxTv_SdtObligacion_Oblnoremu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblnoremu_Z");
      gxTv_SdtObligacion_Oblnoremu_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblnoremu_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblnoremu_Z = false ;
      SetDirty("Oblnoremu_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblnoremu_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtObligacion_Obldescu_Z( )
   {
      return gxTv_SdtObligacion_Obldescu_Z ;
   }

   public void setgxTv_SdtObligacion_Obldescu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obldescu_Z");
      gxTv_SdtObligacion_Obldescu_Z = value ;
   }

   public void setgxTv_SdtObligacion_Obldescu_Z_SetNull( )
   {
      gxTv_SdtObligacion_Obldescu_Z = false ;
      SetDirty("Obldescu_Z");
   }

   public boolean getgxTv_SdtObligacion_Obldescu_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtObligacion_Oblliqnro_Z( )
   {
      return gxTv_SdtObligacion_Oblliqnro_Z ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblliqnro_Z");
      gxTv_SdtObligacion_Oblliqnro_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblliqnro_Z = 0 ;
      SetDirty("Oblliqnro_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblliqnro_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtObligacion_Oblantirelaliq_Z( )
   {
      return gxTv_SdtObligacion_Oblantirelaliq_Z ;
   }

   public void setgxTv_SdtObligacion_Oblantirelaliq_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblantirelaliq_Z");
      gxTv_SdtObligacion_Oblantirelaliq_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblantirelaliq_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblantirelaliq_Z = false ;
      SetDirty("Oblantirelaliq_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblantirelaliq_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Oblconcepto_Z( )
   {
      return gxTv_SdtObligacion_Oblconcepto_Z ;
   }

   public void setgxTv_SdtObligacion_Oblconcepto_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblconcepto_Z");
      gxTv_SdtObligacion_Oblconcepto_Z = value ;
   }

   public void setgxTv_SdtObligacion_Oblconcepto_Z_SetNull( )
   {
      gxTv_SdtObligacion_Oblconcepto_Z = "" ;
      SetDirty("Oblconcepto_Z");
   }

   public boolean getgxTv_SdtObligacion_Oblconcepto_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Obltipomov_Z( )
   {
      return gxTv_SdtObligacion_Obltipomov_Z ;
   }

   public void setgxTv_SdtObligacion_Obltipomov_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Obltipomov_Z");
      gxTv_SdtObligacion_Obltipomov_Z = value ;
   }

   public void setgxTv_SdtObligacion_Obltipomov_Z_SetNull( )
   {
      gxTv_SdtObligacion_Obltipomov_Z = "" ;
      SetDirty("Obltipomov_Z");
   }

   public boolean getgxTv_SdtObligacion_Obltipomov_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtObligacion_Tipooblsolodescu_Z( )
   {
      return gxTv_SdtObligacion_Tipooblsolodescu_Z ;
   }

   public void setgxTv_SdtObligacion_Tipooblsolodescu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Tipooblsolodescu_Z");
      gxTv_SdtObligacion_Tipooblsolodescu_Z = value ;
   }

   public void setgxTv_SdtObligacion_Tipooblsolodescu_Z_SetNull( )
   {
      gxTv_SdtObligacion_Tipooblsolodescu_Z = false ;
      SetDirty("Tipooblsolodescu_Z");
   }

   public boolean getgxTv_SdtObligacion_Tipooblsolodescu_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Embargasec_N( )
   {
      return gxTv_SdtObligacion_Embargasec_N ;
   }

   public void setgxTv_SdtObligacion_Embargasec_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Embargasec_N");
      gxTv_SdtObligacion_Embargasec_N = value ;
   }

   public void setgxTv_SdtObligacion_Embargasec_N_SetNull( )
   {
      gxTv_SdtObligacion_Embargasec_N = (byte)(0) ;
      SetDirty("Embargasec_N");
   }

   public boolean getgxTv_SdtObligacion_Embargasec_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Oblconcodigo_N( )
   {
      return gxTv_SdtObligacion_Oblconcodigo_N ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblconcodigo_N");
      gxTv_SdtObligacion_Oblconcodigo_N = value ;
   }

   public void setgxTv_SdtObligacion_Oblconcodigo_N_SetNull( )
   {
      gxTv_SdtObligacion_Oblconcodigo_N = (byte)(0) ;
      SetDirty("Oblconcodigo_N");
   }

   public boolean getgxTv_SdtObligacion_Oblconcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtObligacion_Oblliqnro_N( )
   {
      return gxTv_SdtObligacion_Oblliqnro_N ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      SetDirty("Oblliqnro_N");
      gxTv_SdtObligacion_Oblliqnro_N = value ;
   }

   public void setgxTv_SdtObligacion_Oblliqnro_N_SetNull( )
   {
      gxTv_SdtObligacion_Oblliqnro_N = (byte)(0) ;
      SetDirty("Oblliqnro_N");
   }

   public boolean getgxTv_SdtObligacion_Oblliqnro_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.obligacion_bc obj;
      obj = new web.obligacion_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtObligacion_N = (byte)(1) ;
      gxTv_SdtObligacion_Legidnomape = "" ;
      gxTv_SdtObligacion_Tipoobldescrip = "" ;
      gxTv_SdtObligacion_Tipooblcodigo = "" ;
      gxTv_SdtObligacion_Oblobs = "" ;
      gxTv_SdtObligacion_Oblconcodigo = "" ;
      gxTv_SdtObligacion_Obltotal = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblimpfij = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblporc = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblconcepto = "" ;
      gxTv_SdtObligacion_Obltipomov = "" ;
      gxTv_SdtObligacion_Mode = "" ;
      gxTv_SdtObligacion_Legidnomape_Z = "" ;
      gxTv_SdtObligacion_Tipoobldescrip_Z = "" ;
      gxTv_SdtObligacion_Tipooblcodigo_Z = "" ;
      gxTv_SdtObligacion_Oblconcodigo_Z = "" ;
      gxTv_SdtObligacion_Obltotal_Z = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblimpfij_Z = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblporc_Z = DecimalUtil.ZERO ;
      gxTv_SdtObligacion_Oblconcepto_Z = "" ;
      gxTv_SdtObligacion_Obltipomov_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtObligacion_N ;
   }

   public web.SdtObligacion Clone( )
   {
      web.SdtObligacion sdt;
      web.obligacion_bc obj;
      sdt = (web.SdtObligacion)(clone()) ;
      obj = (web.obligacion_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtObligacion struct )
   {
      setgxTv_SdtObligacion_Clicod(struct.getClicod());
      setgxTv_SdtObligacion_Empcod(struct.getEmpcod());
      setgxTv_SdtObligacion_Legnumero(struct.getLegnumero());
      setgxTv_SdtObligacion_Oblsecuencial(struct.getOblsecuencial());
      setgxTv_SdtObligacion_Legidnomape(struct.getLegidnomape());
      setgxTv_SdtObligacion_Tipooblsec(struct.getTipooblsec());
      setgxTv_SdtObligacion_Tipoobldescrip(struct.getTipoobldescrip());
      setgxTv_SdtObligacion_Tipooblcodigo(struct.getTipooblcodigo());
      setgxTv_SdtObligacion_Oblestado(struct.getOblestado());
      setgxTv_SdtObligacion_Oblobs(struct.getOblobs());
      setgxTv_SdtObligacion_Obloriper(struct.getObloriper());
      setgxTv_SdtObligacion_Tipoobltottipo(struct.getTipoobltottipo());
      setgxTv_SdtObligacion_Embargasec(struct.getEmbargasec());
      setgxTv_SdtObligacion_Oblconcodigo(struct.getOblconcodigo());
      setgxTv_SdtObligacion_Obltotal(struct.getObltotal());
      setgxTv_SdtObligacion_Oblcancuo(struct.getOblcancuo());
      setgxTv_SdtObligacion_Oblimpfij(struct.getOblimpfij());
      setgxTv_SdtObligacion_Oblporc(struct.getOblporc());
      setgxTv_SdtObligacion_Oblnoremu(struct.getOblnoremu());
      setgxTv_SdtObligacion_Obldescu(struct.getObldescu());
      setgxTv_SdtObligacion_Oblliqnro(struct.getOblliqnro());
      setgxTv_SdtObligacion_Oblantirelaliq(struct.getOblantirelaliq());
      setgxTv_SdtObligacion_Oblconcepto(struct.getOblconcepto());
      setgxTv_SdtObligacion_Obltipomov(struct.getObltipomov());
      setgxTv_SdtObligacion_Tipooblsolodescu(struct.getTipooblsolodescu());
      GXBCLevelCollection<web.SdtObligacion_Excepciones> gxTv_SdtObligacion_Excepciones_aux = new GXBCLevelCollection<web.SdtObligacion_Excepciones>(web.SdtObligacion_Excepciones.class, "Obligacion.Excepciones", "PayDay", remoteHandle);
      Vector<web.StructSdtObligacion_Excepciones> gxTv_SdtObligacion_Excepciones_aux1 = struct.getExcepciones();
      if (gxTv_SdtObligacion_Excepciones_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtObligacion_Excepciones_aux1.size(); i++)
         {
            gxTv_SdtObligacion_Excepciones_aux.add(new web.SdtObligacion_Excepciones(remoteHandle, gxTv_SdtObligacion_Excepciones_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtObligacion_Excepciones(gxTv_SdtObligacion_Excepciones_aux);
      setgxTv_SdtObligacion_Mode(struct.getMode());
      setgxTv_SdtObligacion_Initialized(struct.getInitialized());
      setgxTv_SdtObligacion_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtObligacion_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtObligacion_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtObligacion_Oblsecuencial_Z(struct.getOblsecuencial_Z());
      setgxTv_SdtObligacion_Legidnomape_Z(struct.getLegidnomape_Z());
      setgxTv_SdtObligacion_Tipooblsec_Z(struct.getTipooblsec_Z());
      setgxTv_SdtObligacion_Tipoobldescrip_Z(struct.getTipoobldescrip_Z());
      setgxTv_SdtObligacion_Tipooblcodigo_Z(struct.getTipooblcodigo_Z());
      setgxTv_SdtObligacion_Oblestado_Z(struct.getOblestado_Z());
      setgxTv_SdtObligacion_Obloriper_Z(struct.getObloriper_Z());
      setgxTv_SdtObligacion_Tipoobltottipo_Z(struct.getTipoobltottipo_Z());
      setgxTv_SdtObligacion_Embargasec_Z(struct.getEmbargasec_Z());
      setgxTv_SdtObligacion_Oblconcodigo_Z(struct.getOblconcodigo_Z());
      setgxTv_SdtObligacion_Obltotal_Z(struct.getObltotal_Z());
      setgxTv_SdtObligacion_Oblcancuo_Z(struct.getOblcancuo_Z());
      setgxTv_SdtObligacion_Oblimpfij_Z(struct.getOblimpfij_Z());
      setgxTv_SdtObligacion_Oblporc_Z(struct.getOblporc_Z());
      setgxTv_SdtObligacion_Oblnoremu_Z(struct.getOblnoremu_Z());
      setgxTv_SdtObligacion_Obldescu_Z(struct.getObldescu_Z());
      setgxTv_SdtObligacion_Oblliqnro_Z(struct.getOblliqnro_Z());
      setgxTv_SdtObligacion_Oblantirelaliq_Z(struct.getOblantirelaliq_Z());
      setgxTv_SdtObligacion_Oblconcepto_Z(struct.getOblconcepto_Z());
      setgxTv_SdtObligacion_Obltipomov_Z(struct.getObltipomov_Z());
      setgxTv_SdtObligacion_Tipooblsolodescu_Z(struct.getTipooblsolodescu_Z());
      setgxTv_SdtObligacion_Embargasec_N(struct.getEmbargasec_N());
      setgxTv_SdtObligacion_Oblconcodigo_N(struct.getOblconcodigo_N());
      setgxTv_SdtObligacion_Oblliqnro_N(struct.getOblliqnro_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtObligacion getStruct( )
   {
      web.StructSdtObligacion struct = new web.StructSdtObligacion ();
      struct.setClicod(getgxTv_SdtObligacion_Clicod());
      struct.setEmpcod(getgxTv_SdtObligacion_Empcod());
      struct.setLegnumero(getgxTv_SdtObligacion_Legnumero());
      struct.setOblsecuencial(getgxTv_SdtObligacion_Oblsecuencial());
      struct.setLegidnomape(getgxTv_SdtObligacion_Legidnomape());
      struct.setTipooblsec(getgxTv_SdtObligacion_Tipooblsec());
      struct.setTipoobldescrip(getgxTv_SdtObligacion_Tipoobldescrip());
      struct.setTipooblcodigo(getgxTv_SdtObligacion_Tipooblcodigo());
      struct.setOblestado(getgxTv_SdtObligacion_Oblestado());
      struct.setOblobs(getgxTv_SdtObligacion_Oblobs());
      struct.setObloriper(getgxTv_SdtObligacion_Obloriper());
      struct.setTipoobltottipo(getgxTv_SdtObligacion_Tipoobltottipo());
      struct.setEmbargasec(getgxTv_SdtObligacion_Embargasec());
      struct.setOblconcodigo(getgxTv_SdtObligacion_Oblconcodigo());
      struct.setObltotal(getgxTv_SdtObligacion_Obltotal());
      struct.setOblcancuo(getgxTv_SdtObligacion_Oblcancuo());
      struct.setOblimpfij(getgxTv_SdtObligacion_Oblimpfij());
      struct.setOblporc(getgxTv_SdtObligacion_Oblporc());
      struct.setOblnoremu(getgxTv_SdtObligacion_Oblnoremu());
      struct.setObldescu(getgxTv_SdtObligacion_Obldescu());
      struct.setOblliqnro(getgxTv_SdtObligacion_Oblliqnro());
      struct.setOblantirelaliq(getgxTv_SdtObligacion_Oblantirelaliq());
      struct.setOblconcepto(getgxTv_SdtObligacion_Oblconcepto());
      struct.setObltipomov(getgxTv_SdtObligacion_Obltipomov());
      struct.setTipooblsolodescu(getgxTv_SdtObligacion_Tipooblsolodescu());
      struct.setExcepciones(getgxTv_SdtObligacion_Excepciones().getStruct());
      struct.setMode(getgxTv_SdtObligacion_Mode());
      struct.setInitialized(getgxTv_SdtObligacion_Initialized());
      struct.setClicod_Z(getgxTv_SdtObligacion_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtObligacion_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtObligacion_Legnumero_Z());
      struct.setOblsecuencial_Z(getgxTv_SdtObligacion_Oblsecuencial_Z());
      struct.setLegidnomape_Z(getgxTv_SdtObligacion_Legidnomape_Z());
      struct.setTipooblsec_Z(getgxTv_SdtObligacion_Tipooblsec_Z());
      struct.setTipoobldescrip_Z(getgxTv_SdtObligacion_Tipoobldescrip_Z());
      struct.setTipooblcodigo_Z(getgxTv_SdtObligacion_Tipooblcodigo_Z());
      struct.setOblestado_Z(getgxTv_SdtObligacion_Oblestado_Z());
      struct.setObloriper_Z(getgxTv_SdtObligacion_Obloriper_Z());
      struct.setTipoobltottipo_Z(getgxTv_SdtObligacion_Tipoobltottipo_Z());
      struct.setEmbargasec_Z(getgxTv_SdtObligacion_Embargasec_Z());
      struct.setOblconcodigo_Z(getgxTv_SdtObligacion_Oblconcodigo_Z());
      struct.setObltotal_Z(getgxTv_SdtObligacion_Obltotal_Z());
      struct.setOblcancuo_Z(getgxTv_SdtObligacion_Oblcancuo_Z());
      struct.setOblimpfij_Z(getgxTv_SdtObligacion_Oblimpfij_Z());
      struct.setOblporc_Z(getgxTv_SdtObligacion_Oblporc_Z());
      struct.setOblnoremu_Z(getgxTv_SdtObligacion_Oblnoremu_Z());
      struct.setObldescu_Z(getgxTv_SdtObligacion_Obldescu_Z());
      struct.setOblliqnro_Z(getgxTv_SdtObligacion_Oblliqnro_Z());
      struct.setOblantirelaliq_Z(getgxTv_SdtObligacion_Oblantirelaliq_Z());
      struct.setOblconcepto_Z(getgxTv_SdtObligacion_Oblconcepto_Z());
      struct.setObltipomov_Z(getgxTv_SdtObligacion_Obltipomov_Z());
      struct.setTipooblsolodescu_Z(getgxTv_SdtObligacion_Tipooblsolodescu_Z());
      struct.setEmbargasec_N(getgxTv_SdtObligacion_Embargasec_N());
      struct.setOblconcodigo_N(getgxTv_SdtObligacion_Oblconcodigo_N());
      struct.setOblliqnro_N(getgxTv_SdtObligacion_Oblliqnro_N());
      return struct ;
   }

   private byte gxTv_SdtObligacion_N ;
   private byte gxTv_SdtObligacion_Oblestado ;
   private byte gxTv_SdtObligacion_Obloriper ;
   private byte gxTv_SdtObligacion_Tipoobltottipo ;
   private byte gxTv_SdtObligacion_Oblestado_Z ;
   private byte gxTv_SdtObligacion_Obloriper_Z ;
   private byte gxTv_SdtObligacion_Tipoobltottipo_Z ;
   private byte gxTv_SdtObligacion_Embargasec_N ;
   private byte gxTv_SdtObligacion_Oblconcodigo_N ;
   private byte gxTv_SdtObligacion_Oblliqnro_N ;
   private short gxTv_SdtObligacion_Empcod ;
   private short gxTv_SdtObligacion_Oblsecuencial ;
   private short gxTv_SdtObligacion_Tipooblsec ;
   private short gxTv_SdtObligacion_Embargasec ;
   private short gxTv_SdtObligacion_Oblcancuo ;
   private short gxTv_SdtObligacion_Initialized ;
   private short gxTv_SdtObligacion_Empcod_Z ;
   private short gxTv_SdtObligacion_Oblsecuencial_Z ;
   private short gxTv_SdtObligacion_Tipooblsec_Z ;
   private short gxTv_SdtObligacion_Embargasec_Z ;
   private short gxTv_SdtObligacion_Oblcancuo_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtObligacion_Clicod ;
   private int gxTv_SdtObligacion_Legnumero ;
   private int gxTv_SdtObligacion_Oblliqnro ;
   private int gxTv_SdtObligacion_Clicod_Z ;
   private int gxTv_SdtObligacion_Legnumero_Z ;
   private int gxTv_SdtObligacion_Oblliqnro_Z ;
   private java.math.BigDecimal gxTv_SdtObligacion_Obltotal ;
   private java.math.BigDecimal gxTv_SdtObligacion_Oblimpfij ;
   private java.math.BigDecimal gxTv_SdtObligacion_Oblporc ;
   private java.math.BigDecimal gxTv_SdtObligacion_Obltotal_Z ;
   private java.math.BigDecimal gxTv_SdtObligacion_Oblimpfij_Z ;
   private java.math.BigDecimal gxTv_SdtObligacion_Oblporc_Z ;
   private String gxTv_SdtObligacion_Tipooblcodigo ;
   private String gxTv_SdtObligacion_Oblconcodigo ;
   private String gxTv_SdtObligacion_Oblconcepto ;
   private String gxTv_SdtObligacion_Obltipomov ;
   private String gxTv_SdtObligacion_Mode ;
   private String gxTv_SdtObligacion_Tipooblcodigo_Z ;
   private String gxTv_SdtObligacion_Oblconcodigo_Z ;
   private String gxTv_SdtObligacion_Oblconcepto_Z ;
   private String gxTv_SdtObligacion_Obltipomov_Z ;
   private String sTagName ;
   private boolean gxTv_SdtObligacion_Oblnoremu ;
   private boolean gxTv_SdtObligacion_Obldescu ;
   private boolean gxTv_SdtObligacion_Oblantirelaliq ;
   private boolean gxTv_SdtObligacion_Tipooblsolodescu ;
   private boolean gxTv_SdtObligacion_Oblnoremu_Z ;
   private boolean gxTv_SdtObligacion_Obldescu_Z ;
   private boolean gxTv_SdtObligacion_Oblantirelaliq_Z ;
   private boolean gxTv_SdtObligacion_Tipooblsolodescu_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtObligacion_Oblobs ;
   private String gxTv_SdtObligacion_Legidnomape ;
   private String gxTv_SdtObligacion_Tipoobldescrip ;
   private String gxTv_SdtObligacion_Legidnomape_Z ;
   private String gxTv_SdtObligacion_Tipoobldescrip_Z ;
   private GXBCLevelCollection<web.SdtObligacion_Excepciones> gxTv_SdtObligacion_Excepciones_aux ;
   private GXBCLevelCollection<web.SdtObligacion_Excepciones> gxTv_SdtObligacion_Excepciones=null ;
}

