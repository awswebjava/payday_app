package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_base_calculo extends GxSilentTrnSdt
{
   public SdtPais_base_calculo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_base_calculo.class));
   }

   public SdtPais_base_calculo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_base_calculo");
      initialize( remoteHandle) ;
   }

   public SdtPais_base_calculo( int remoteHandle ,
                                StructSdtPais_base_calculo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_base_calculo( )
   {
      super( new ModelContext(SdtPais_base_calculo.class), "SdtPais_base_calculo");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaiBaseClaseLeg", byte.class}, new Object[]{"PaiBaseTipo", String.class}, new Object[]{"PaiBaseCod1", String.class}, new Object[]{"PaiBaseCod2", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "base_calculo");
      metadata.set("BT", "Paisbase_calculo");
      metadata.set("PK", "[ \"PaiBaseClaseLeg\",\"PaiBaseTipo\",\"PaiBaseCod1\",\"PaiBaseCod2\" ]");
      metadata.set("Levels", "[ \"actual\",\"promedio\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseClaseLeg") )
            {
               gxTv_SdtPais_base_calculo_Paibaseclaseleg = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseTipo") )
            {
               gxTv_SdtPais_base_calculo_Paibasetipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCod1") )
            {
               gxTv_SdtPais_base_calculo_Paibasecod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCod2") )
            {
               gxTv_SdtPais_base_calculo_Paibasecod2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePlus") )
            {
               gxTv_SdtPais_base_calculo_Paibaseplus = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDLim") )
            {
               gxTv_SdtPais_base_calculo_Pailicdlim = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSeman") )
            {
               gxTv_SdtPais_base_calculo_Pailicdseman = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDMes") )
            {
               gxTv_SdtPais_base_calculo_Pailicdmes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSemes") )
            {
               gxTv_SdtPais_base_calculo_Pailicdsemes = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDAnual") )
            {
               gxTv_SdtPais_base_calculo_Pailicdanual = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdju") )
            {
               gxTv_SdtPais_base_calculo_Pailicadju = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdjuObl") )
            {
               gxTv_SdtPais_base_calculo_Pailicadjuobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicNecAut") )
            {
               gxTv_SdtPais_base_calculo_Pailicnecaut = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicIngMot") )
            {
               gxTv_SdtPais_base_calculo_Pailicingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicMotObl") )
            {
               gxTv_SdtPais_base_calculo_Pailicmotobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt1") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromcnt1 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt2") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromcnt2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromTCnt") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromtcnt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "actual") )
            {
               if ( gxTv_SdtPais_base_calculo_Actual == null )
               {
                  gxTv_SdtPais_base_calculo_Actual = new GXBCLevelCollection<web.SdtPais_base_calculo_actual>(web.SdtPais_base_calculo_actual.class, "Pais.base_calculo.actual", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_base_calculo_Actual.readxml(oReader, "actual") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "actual") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "promedio") )
            {
               if ( gxTv_SdtPais_base_calculo_Promedio == null )
               {
                  gxTv_SdtPais_base_calculo_Promedio = new GXBCLevelCollection<web.SdtPais_base_calculo_promedio>(web.SdtPais_base_calculo_promedio.class, "Pais.base_calculo.promedio", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_base_calculo_Promedio.readxml(oReader, "promedio") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "promedio") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_base_calculo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_base_calculo_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_base_calculo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseClaseLeg_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseTipo_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasetipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCod1_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasecod1_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCod2_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasecod2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePlus_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibaseplus_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDLim_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicdlim_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSeman_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicdseman_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDMes_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicdmes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSemes_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicdsemes_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDAnual_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicdanual_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdju_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicadju_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdjuObl_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicadjuobl_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicNecAut_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicnecaut_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicIngMot_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicingmot_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicMotObl_Z") )
            {
               gxTv_SdtPais_base_calculo_Pailicmotobl_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt1_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt2_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromTCnt_Z") )
            {
               gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = oReader.getValue() ;
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
         sName = "Pais.base_calculo" ;
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
      oWriter.writeElement("PaiBaseClaseLeg", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibaseclaseleg, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBaseTipo", gxTv_SdtPais_base_calculo_Paibasetipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBaseCod1", gxTv_SdtPais_base_calculo_Paibasecod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBaseCod2", gxTv_SdtPais_base_calculo_Paibasecod2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePlus", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_base_calculo_Paibaseplus, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDLim", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdlim, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDSeman", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdseman, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDMes", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdmes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDSemes", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdsemes, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDAnual", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdanual, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicAdju", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicadju));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicAdjuObl", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicadjuobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicNecAut", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicnecaut));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicIngMot", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicMotObl", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicmotobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromCnt1", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibasepromcnt1, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromCnt2", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibasepromcnt2, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromTCnt", gxTv_SdtPais_base_calculo_Paibasepromtcnt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtPais_base_calculo_Actual != null )
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
         gxTv_SdtPais_base_calculo_Actual.writexml(oWriter, "actual", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_base_calculo_Promedio != null )
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
         gxTv_SdtPais_base_calculo_Promedio.writexml(oWriter, "promedio", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_base_calculo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseClaseLeg_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseTipo_Z", gxTv_SdtPais_base_calculo_Paibasetipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseCod1_Z", gxTv_SdtPais_base_calculo_Paibasecod1_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseCod2_Z", gxTv_SdtPais_base_calculo_Paibasecod2_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePlus_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_base_calculo_Paibaseplus_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicDLim_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdlim_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicDSeman_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdseman_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicDMes_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdmes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicDSemes_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdsemes_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicDAnual_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Pailicdanual_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicAdju_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicadju_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicAdjuObl_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicadjuobl_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicNecAut_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicnecaut_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicIngMot_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicingmot_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiLicMotObl_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_Pailicmotobl_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromCnt1_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromCnt2_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromTCnt_Z", gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z);
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
      AddObjectProperty("PaiBaseClaseLeg", gxTv_SdtPais_base_calculo_Paibaseclaseleg, false, includeNonInitialized);
      AddObjectProperty("PaiBaseTipo", gxTv_SdtPais_base_calculo_Paibasetipo, false, includeNonInitialized);
      AddObjectProperty("PaiBaseCod1", gxTv_SdtPais_base_calculo_Paibasecod1, false, includeNonInitialized);
      AddObjectProperty("PaiBaseCod2", gxTv_SdtPais_base_calculo_Paibasecod2, false, includeNonInitialized);
      AddObjectProperty("PaiBasePlus", gxTv_SdtPais_base_calculo_Paibaseplus, false, includeNonInitialized);
      AddObjectProperty("PaiLicDLim", gxTv_SdtPais_base_calculo_Pailicdlim, false, includeNonInitialized);
      AddObjectProperty("PaiLicDSeman", gxTv_SdtPais_base_calculo_Pailicdseman, false, includeNonInitialized);
      AddObjectProperty("PaiLicDMes", gxTv_SdtPais_base_calculo_Pailicdmes, false, includeNonInitialized);
      AddObjectProperty("PaiLicDSemes", gxTv_SdtPais_base_calculo_Pailicdsemes, false, includeNonInitialized);
      AddObjectProperty("PaiLicDAnual", gxTv_SdtPais_base_calculo_Pailicdanual, false, includeNonInitialized);
      AddObjectProperty("PaiLicAdju", gxTv_SdtPais_base_calculo_Pailicadju, false, includeNonInitialized);
      AddObjectProperty("PaiLicAdjuObl", gxTv_SdtPais_base_calculo_Pailicadjuobl, false, includeNonInitialized);
      AddObjectProperty("PaiLicNecAut", gxTv_SdtPais_base_calculo_Pailicnecaut, false, includeNonInitialized);
      AddObjectProperty("PaiLicIngMot", gxTv_SdtPais_base_calculo_Pailicingmot, false, includeNonInitialized);
      AddObjectProperty("PaiLicMotObl", gxTv_SdtPais_base_calculo_Pailicmotobl, false, includeNonInitialized);
      AddObjectProperty("PaiBasePromCnt1", gxTv_SdtPais_base_calculo_Paibasepromcnt1, false, includeNonInitialized);
      AddObjectProperty("PaiBasePromCnt2", gxTv_SdtPais_base_calculo_Paibasepromcnt2, false, includeNonInitialized);
      AddObjectProperty("PaiBasePromTCnt", gxTv_SdtPais_base_calculo_Paibasepromtcnt, false, includeNonInitialized);
      if ( gxTv_SdtPais_base_calculo_Actual != null )
      {
         AddObjectProperty("actual", gxTv_SdtPais_base_calculo_Actual, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_base_calculo_Promedio != null )
      {
         AddObjectProperty("promedio", gxTv_SdtPais_base_calculo_Promedio, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_base_calculo_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_base_calculo_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_base_calculo_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiBaseClaseLeg_Z", gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBaseTipo_Z", gxTv_SdtPais_base_calculo_Paibasetipo_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBaseCod1_Z", gxTv_SdtPais_base_calculo_Paibasecod1_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBaseCod2_Z", gxTv_SdtPais_base_calculo_Paibasecod2_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePlus_Z", gxTv_SdtPais_base_calculo_Paibaseplus_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicDLim_Z", gxTv_SdtPais_base_calculo_Pailicdlim_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicDSeman_Z", gxTv_SdtPais_base_calculo_Pailicdseman_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicDMes_Z", gxTv_SdtPais_base_calculo_Pailicdmes_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicDSemes_Z", gxTv_SdtPais_base_calculo_Pailicdsemes_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicDAnual_Z", gxTv_SdtPais_base_calculo_Pailicdanual_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicAdju_Z", gxTv_SdtPais_base_calculo_Pailicadju_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicAdjuObl_Z", gxTv_SdtPais_base_calculo_Pailicadjuobl_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicNecAut_Z", gxTv_SdtPais_base_calculo_Pailicnecaut_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicIngMot_Z", gxTv_SdtPais_base_calculo_Pailicingmot_Z, false, includeNonInitialized);
         AddObjectProperty("PaiLicMotObl_Z", gxTv_SdtPais_base_calculo_Pailicmotobl_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromCnt1_Z", gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromCnt2_Z", gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromTCnt_Z", gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_base_calculo sdt )
   {
      if ( sdt.IsDirty("PaiBaseClaseLeg") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibaseclaseleg = sdt.getgxTv_SdtPais_base_calculo_Paibaseclaseleg() ;
      }
      if ( sdt.IsDirty("PaiBaseTipo") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasetipo = sdt.getgxTv_SdtPais_base_calculo_Paibasetipo() ;
      }
      if ( sdt.IsDirty("PaiBaseCod1") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasecod1 = sdt.getgxTv_SdtPais_base_calculo_Paibasecod1() ;
      }
      if ( sdt.IsDirty("PaiBaseCod2") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasecod2 = sdt.getgxTv_SdtPais_base_calculo_Paibasecod2() ;
      }
      if ( sdt.IsDirty("PaiBasePlus") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibaseplus = sdt.getgxTv_SdtPais_base_calculo_Paibaseplus() ;
      }
      if ( sdt.IsDirty("PaiLicDLim") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicdlim = sdt.getgxTv_SdtPais_base_calculo_Pailicdlim() ;
      }
      if ( sdt.IsDirty("PaiLicDSeman") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicdseman = sdt.getgxTv_SdtPais_base_calculo_Pailicdseman() ;
      }
      if ( sdt.IsDirty("PaiLicDMes") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicdmes = sdt.getgxTv_SdtPais_base_calculo_Pailicdmes() ;
      }
      if ( sdt.IsDirty("PaiLicDSemes") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicdsemes = sdt.getgxTv_SdtPais_base_calculo_Pailicdsemes() ;
      }
      if ( sdt.IsDirty("PaiLicDAnual") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicdanual = sdt.getgxTv_SdtPais_base_calculo_Pailicdanual() ;
      }
      if ( sdt.IsDirty("PaiLicAdju") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicadju = sdt.getgxTv_SdtPais_base_calculo_Pailicadju() ;
      }
      if ( sdt.IsDirty("PaiLicAdjuObl") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicadjuobl = sdt.getgxTv_SdtPais_base_calculo_Pailicadjuobl() ;
      }
      if ( sdt.IsDirty("PaiLicNecAut") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicnecaut = sdt.getgxTv_SdtPais_base_calculo_Pailicnecaut() ;
      }
      if ( sdt.IsDirty("PaiLicIngMot") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicingmot = sdt.getgxTv_SdtPais_base_calculo_Pailicingmot() ;
      }
      if ( sdt.IsDirty("PaiLicMotObl") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Pailicmotobl = sdt.getgxTv_SdtPais_base_calculo_Pailicmotobl() ;
      }
      if ( sdt.IsDirty("PaiBasePromCnt1") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasepromcnt1 = sdt.getgxTv_SdtPais_base_calculo_Paibasepromcnt1() ;
      }
      if ( sdt.IsDirty("PaiBasePromCnt2") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasepromcnt2 = sdt.getgxTv_SdtPais_base_calculo_Paibasepromcnt2() ;
      }
      if ( sdt.IsDirty("PaiBasePromTCnt") )
      {
         gxTv_SdtPais_base_calculo_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_Paibasepromtcnt = sdt.getgxTv_SdtPais_base_calculo_Paibasepromtcnt() ;
      }
      if ( gxTv_SdtPais_base_calculo_Actual != null )
      {
         GXBCLevelCollection<web.SdtPais_base_calculo_actual> newCollectionActual = sdt.getgxTv_SdtPais_base_calculo_Actual();
         web.SdtPais_base_calculo_actual currItemActual;
         web.SdtPais_base_calculo_actual newItemActual;
         short idx = 1;
         while ( idx <= newCollectionActual.size() )
         {
            newItemActual = (web.SdtPais_base_calculo_actual)((web.SdtPais_base_calculo_actual)newCollectionActual.elementAt(-1+idx));
            currItemActual = (web.SdtPais_base_calculo_actual)gxTv_SdtPais_base_calculo_Actual.getByKey(newItemActual.getgxTv_SdtPais_base_calculo_actual_Paibaseclicod(), newItemActual.getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo());
            if ( GXutil.strcmp(currItemActual.getgxTv_SdtPais_base_calculo_actual_Mode(), "UPD") == 0 )
            {
               currItemActual.updateDirties(newItemActual);
               if ( GXutil.strcmp(newItemActual.getgxTv_SdtPais_base_calculo_actual_Mode(), "DLT") == 0 )
               {
                  currItemActual.setgxTv_SdtPais_base_calculo_actual_Mode( "DLT" );
               }
               currItemActual.setgxTv_SdtPais_base_calculo_actual_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_base_calculo_Actual.add(newItemActual, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_base_calculo_Promedio != null )
      {
         GXBCLevelCollection<web.SdtPais_base_calculo_promedio> newCollectionPromedio = sdt.getgxTv_SdtPais_base_calculo_Promedio();
         web.SdtPais_base_calculo_promedio currItemPromedio;
         web.SdtPais_base_calculo_promedio newItemPromedio;
         short idx = 1;
         while ( idx <= newCollectionPromedio.size() )
         {
            newItemPromedio = (web.SdtPais_base_calculo_promedio)((web.SdtPais_base_calculo_promedio)newCollectionPromedio.elementAt(-1+idx));
            currItemPromedio = (web.SdtPais_base_calculo_promedio)gxTv_SdtPais_base_calculo_Promedio.getByKey(newItemPromedio.getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo(), newItemPromedio.getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar());
            if ( GXutil.strcmp(currItemPromedio.getgxTv_SdtPais_base_calculo_promedio_Mode(), "UPD") == 0 )
            {
               currItemPromedio.updateDirties(newItemPromedio);
               if ( GXutil.strcmp(newItemPromedio.getgxTv_SdtPais_base_calculo_promedio_Mode(), "DLT") == 0 )
               {
                  currItemPromedio.setgxTv_SdtPais_base_calculo_promedio_Mode( "DLT" );
               }
               currItemPromedio.setgxTv_SdtPais_base_calculo_promedio_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_base_calculo_Promedio.add(newItemPromedio, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public byte getgxTv_SdtPais_base_calculo_Paibaseclaseleg( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseclaseleg ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseclaseleg( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibaseclaseleg");
      gxTv_SdtPais_base_calculo_Paibaseclaseleg = value ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasetipo( )
   {
      return gxTv_SdtPais_base_calculo_Paibasetipo ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasetipo( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasetipo");
      gxTv_SdtPais_base_calculo_Paibasetipo = value ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasecod1( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod1 ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod1( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasecod1");
      gxTv_SdtPais_base_calculo_Paibasecod1 = value ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasecod2( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod2 ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod2( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasecod2");
      gxTv_SdtPais_base_calculo_Paibasecod2 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_base_calculo_Paibaseplus( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseplus ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibaseplus");
      gxTv_SdtPais_base_calculo_Paibaseplus = value ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdlim( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdlim ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdlim( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdlim");
      gxTv_SdtPais_base_calculo_Pailicdlim = value ;
   }

   public byte getgxTv_SdtPais_base_calculo_Pailicdseman( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdseman ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdseman( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdseman");
      gxTv_SdtPais_base_calculo_Pailicdseman = value ;
   }

   public byte getgxTv_SdtPais_base_calculo_Pailicdmes( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdmes ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdmes( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdmes");
      gxTv_SdtPais_base_calculo_Pailicdmes = value ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdsemes( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdsemes ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdsemes( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdsemes");
      gxTv_SdtPais_base_calculo_Pailicdsemes = value ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdanual( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdanual ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdanual( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdanual");
      gxTv_SdtPais_base_calculo_Pailicdanual = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadju( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadju ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadju( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicadju");
      gxTv_SdtPais_base_calculo_Pailicadju = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadjuobl( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadjuobl ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadjuobl( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicadjuobl");
      gxTv_SdtPais_base_calculo_Pailicadjuobl = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicnecaut( )
   {
      return gxTv_SdtPais_base_calculo_Pailicnecaut ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicnecaut( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicnecaut");
      gxTv_SdtPais_base_calculo_Pailicnecaut = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicingmot( )
   {
      return gxTv_SdtPais_base_calculo_Pailicingmot ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicingmot( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicingmot");
      gxTv_SdtPais_base_calculo_Pailicingmot = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicmotobl( )
   {
      return gxTv_SdtPais_base_calculo_Pailicmotobl ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicmotobl( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicmotobl");
      gxTv_SdtPais_base_calculo_Pailicmotobl = value ;
   }

   public short getgxTv_SdtPais_base_calculo_Paibasepromcnt1( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt1 ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt1( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromcnt1");
      gxTv_SdtPais_base_calculo_Paibasepromcnt1 = value ;
   }

   public short getgxTv_SdtPais_base_calculo_Paibasepromcnt2( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt2 ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt2( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromcnt2");
      gxTv_SdtPais_base_calculo_Paibasepromcnt2 = value ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasepromtcnt( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromtcnt ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromtcnt( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromtcnt");
      gxTv_SdtPais_base_calculo_Paibasepromtcnt = value ;
   }

   public GXBCLevelCollection<web.SdtPais_base_calculo_actual> getgxTv_SdtPais_base_calculo_Actual( )
   {
      if ( gxTv_SdtPais_base_calculo_Actual == null )
      {
         gxTv_SdtPais_base_calculo_Actual = new GXBCLevelCollection<web.SdtPais_base_calculo_actual>(web.SdtPais_base_calculo_actual.class, "Pais.base_calculo.actual", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      return gxTv_SdtPais_base_calculo_Actual ;
   }

   public void setgxTv_SdtPais_base_calculo_Actual( GXBCLevelCollection<web.SdtPais_base_calculo_actual> value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Actual");
      gxTv_SdtPais_base_calculo_Actual = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Actual_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Actual = null ;
      SetDirty("Actual");
   }

   public boolean getgxTv_SdtPais_base_calculo_Actual_IsNull( )
   {
      if ( gxTv_SdtPais_base_calculo_Actual == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_base_calculo_promedio> getgxTv_SdtPais_base_calculo_Promedio( )
   {
      if ( gxTv_SdtPais_base_calculo_Promedio == null )
      {
         gxTv_SdtPais_base_calculo_Promedio = new GXBCLevelCollection<web.SdtPais_base_calculo_promedio>(web.SdtPais_base_calculo_promedio.class, "Pais.base_calculo.promedio", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      return gxTv_SdtPais_base_calculo_Promedio ;
   }

   public void setgxTv_SdtPais_base_calculo_Promedio( GXBCLevelCollection<web.SdtPais_base_calculo_promedio> value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Promedio");
      gxTv_SdtPais_base_calculo_Promedio = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Promedio_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Promedio = null ;
      SetDirty("Promedio");
   }

   public boolean getgxTv_SdtPais_base_calculo_Promedio_IsNull( )
   {
      if ( gxTv_SdtPais_base_calculo_Promedio == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_Mode( )
   {
      return gxTv_SdtPais_base_calculo_Mode ;
   }

   public void setgxTv_SdtPais_base_calculo_Mode( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_base_calculo_Mode = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Mode_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_base_calculo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Modified( )
   {
      return gxTv_SdtPais_base_calculo_Modified ;
   }

   public void setgxTv_SdtPais_base_calculo_Modified( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_base_calculo_Modified = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Modified_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_base_calculo_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Initialized( )
   {
      return gxTv_SdtPais_base_calculo_Initialized ;
   }

   public void setgxTv_SdtPais_base_calculo_Initialized( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_base_calculo_Initialized = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Initialized_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_base_calculo_Initialized_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibaseclaseleg_Z");
      gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z = (byte)(0) ;
      SetDirty("Paibaseclaseleg_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasetipo_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasetipo_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasetipo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasetipo_Z");
      gxTv_SdtPais_base_calculo_Paibasetipo_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasetipo_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasetipo_Z = "" ;
      SetDirty("Paibasetipo_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasetipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasecod1_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod1_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod1_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasecod1_Z");
      gxTv_SdtPais_base_calculo_Paibasecod1_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod1_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasecod1_Z = "" ;
      SetDirty("Paibasecod1_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasecod1_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasecod2_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod2_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod2_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasecod2_Z");
      gxTv_SdtPais_base_calculo_Paibasecod2_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasecod2_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasecod2_Z = "" ;
      SetDirty("Paibasecod2_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasecod2_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_base_calculo_Paibaseplus_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseplus_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibaseplus_Z");
      gxTv_SdtPais_base_calculo_Paibaseplus_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibaseplus_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibaseplus_Z = DecimalUtil.ZERO ;
      SetDirty("Paibaseplus_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibaseplus_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdlim_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdlim_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdlim_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdlim_Z");
      gxTv_SdtPais_base_calculo_Pailicdlim_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdlim_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicdlim_Z = (short)(0) ;
      SetDirty("Pailicdlim_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicdlim_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_base_calculo_Pailicdseman_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdseman_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdseman_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdseman_Z");
      gxTv_SdtPais_base_calculo_Pailicdseman_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdseman_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicdseman_Z = (byte)(0) ;
      SetDirty("Pailicdseman_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicdseman_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_base_calculo_Pailicdmes_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdmes_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdmes_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdmes_Z");
      gxTv_SdtPais_base_calculo_Pailicdmes_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdmes_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicdmes_Z = (byte)(0) ;
      SetDirty("Pailicdmes_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicdmes_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdsemes_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdsemes_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdsemes_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdsemes_Z");
      gxTv_SdtPais_base_calculo_Pailicdsemes_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdsemes_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicdsemes_Z = (short)(0) ;
      SetDirty("Pailicdsemes_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicdsemes_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Pailicdanual_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdanual_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdanual_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicdanual_Z");
      gxTv_SdtPais_base_calculo_Pailicdanual_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicdanual_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicdanual_Z = (short)(0) ;
      SetDirty("Pailicdanual_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicdanual_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadju_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadju_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadju_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicadju_Z");
      gxTv_SdtPais_base_calculo_Pailicadju_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadju_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicadju_Z = false ;
      SetDirty("Pailicadju_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadju_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadjuobl_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadjuobl_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadjuobl_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicadjuobl_Z");
      gxTv_SdtPais_base_calculo_Pailicadjuobl_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicadjuobl_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicadjuobl_Z = false ;
      SetDirty("Pailicadjuobl_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicadjuobl_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicnecaut_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicnecaut_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicnecaut_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicnecaut_Z");
      gxTv_SdtPais_base_calculo_Pailicnecaut_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicnecaut_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicnecaut_Z = false ;
      SetDirty("Pailicnecaut_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicnecaut_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicingmot_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicingmot_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicingmot_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicingmot_Z");
      gxTv_SdtPais_base_calculo_Pailicingmot_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicingmot_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicingmot_Z = false ;
      SetDirty("Pailicingmot_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicingmot_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicmotobl_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicmotobl_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicmotobl_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Pailicmotobl_Z");
      gxTv_SdtPais_base_calculo_Pailicmotobl_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Pailicmotobl_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Pailicmotobl_Z = false ;
      SetDirty("Pailicmotobl_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Pailicmotobl_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromcnt1_Z");
      gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z = (short)(0) ;
      SetDirty("Paibasepromcnt1_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromcnt2_Z");
      gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z = (short)(0) ;
      SetDirty("Paibasepromcnt2_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = (short)(1) ;
      SetDirty("Paibasepromtcnt_Z");
      gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = "" ;
      SetDirty("Paibasepromtcnt_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(1) ;
      gxTv_SdtPais_base_calculo_Paibasetipo = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod1 = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod2 = "" ;
      gxTv_SdtPais_base_calculo_Paibaseplus = DecimalUtil.ZERO ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt = "" ;
      gxTv_SdtPais_base_calculo_Mode = "" ;
      gxTv_SdtPais_base_calculo_Paibasetipo_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod1_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod2_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibaseplus_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_base_calculo_N ;
   }

   public web.SdtPais_base_calculo Clone( )
   {
      return (web.SdtPais_base_calculo)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_base_calculo struct )
   {
      setgxTv_SdtPais_base_calculo_Paibaseclaseleg(struct.getPaibaseclaseleg());
      setgxTv_SdtPais_base_calculo_Paibasetipo(struct.getPaibasetipo());
      setgxTv_SdtPais_base_calculo_Paibasecod1(struct.getPaibasecod1());
      setgxTv_SdtPais_base_calculo_Paibasecod2(struct.getPaibasecod2());
      setgxTv_SdtPais_base_calculo_Paibaseplus(struct.getPaibaseplus());
      setgxTv_SdtPais_base_calculo_Pailicdlim(struct.getPailicdlim());
      setgxTv_SdtPais_base_calculo_Pailicdseman(struct.getPailicdseman());
      setgxTv_SdtPais_base_calculo_Pailicdmes(struct.getPailicdmes());
      setgxTv_SdtPais_base_calculo_Pailicdsemes(struct.getPailicdsemes());
      setgxTv_SdtPais_base_calculo_Pailicdanual(struct.getPailicdanual());
      setgxTv_SdtPais_base_calculo_Pailicadju(struct.getPailicadju());
      setgxTv_SdtPais_base_calculo_Pailicadjuobl(struct.getPailicadjuobl());
      setgxTv_SdtPais_base_calculo_Pailicnecaut(struct.getPailicnecaut());
      setgxTv_SdtPais_base_calculo_Pailicingmot(struct.getPailicingmot());
      setgxTv_SdtPais_base_calculo_Pailicmotobl(struct.getPailicmotobl());
      setgxTv_SdtPais_base_calculo_Paibasepromcnt1(struct.getPaibasepromcnt1());
      setgxTv_SdtPais_base_calculo_Paibasepromcnt2(struct.getPaibasepromcnt2());
      setgxTv_SdtPais_base_calculo_Paibasepromtcnt(struct.getPaibasepromtcnt());
      GXBCLevelCollection<web.SdtPais_base_calculo_actual> gxTv_SdtPais_base_calculo_Actual_aux = new GXBCLevelCollection<web.SdtPais_base_calculo_actual>(web.SdtPais_base_calculo_actual.class, "Pais.base_calculo.actual", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_base_calculo_actual> gxTv_SdtPais_base_calculo_Actual_aux1 = struct.getActual();
      if (gxTv_SdtPais_base_calculo_Actual_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_base_calculo_Actual_aux1.size(); i++)
         {
            gxTv_SdtPais_base_calculo_Actual_aux.add(new web.SdtPais_base_calculo_actual(remoteHandle, gxTv_SdtPais_base_calculo_Actual_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_base_calculo_Actual(gxTv_SdtPais_base_calculo_Actual_aux);
      GXBCLevelCollection<web.SdtPais_base_calculo_promedio> gxTv_SdtPais_base_calculo_Promedio_aux = new GXBCLevelCollection<web.SdtPais_base_calculo_promedio>(web.SdtPais_base_calculo_promedio.class, "Pais.base_calculo.promedio", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_base_calculo_promedio> gxTv_SdtPais_base_calculo_Promedio_aux1 = struct.getPromedio();
      if (gxTv_SdtPais_base_calculo_Promedio_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_base_calculo_Promedio_aux1.size(); i++)
         {
            gxTv_SdtPais_base_calculo_Promedio_aux.add(new web.SdtPais_base_calculo_promedio(remoteHandle, gxTv_SdtPais_base_calculo_Promedio_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_base_calculo_Promedio(gxTv_SdtPais_base_calculo_Promedio_aux);
      setgxTv_SdtPais_base_calculo_Mode(struct.getMode());
      setgxTv_SdtPais_base_calculo_Modified(struct.getModified());
      setgxTv_SdtPais_base_calculo_Initialized(struct.getInitialized());
      setgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z(struct.getPaibaseclaseleg_Z());
      setgxTv_SdtPais_base_calculo_Paibasetipo_Z(struct.getPaibasetipo_Z());
      setgxTv_SdtPais_base_calculo_Paibasecod1_Z(struct.getPaibasecod1_Z());
      setgxTv_SdtPais_base_calculo_Paibasecod2_Z(struct.getPaibasecod2_Z());
      setgxTv_SdtPais_base_calculo_Paibaseplus_Z(struct.getPaibaseplus_Z());
      setgxTv_SdtPais_base_calculo_Pailicdlim_Z(struct.getPailicdlim_Z());
      setgxTv_SdtPais_base_calculo_Pailicdseman_Z(struct.getPailicdseman_Z());
      setgxTv_SdtPais_base_calculo_Pailicdmes_Z(struct.getPailicdmes_Z());
      setgxTv_SdtPais_base_calculo_Pailicdsemes_Z(struct.getPailicdsemes_Z());
      setgxTv_SdtPais_base_calculo_Pailicdanual_Z(struct.getPailicdanual_Z());
      setgxTv_SdtPais_base_calculo_Pailicadju_Z(struct.getPailicadju_Z());
      setgxTv_SdtPais_base_calculo_Pailicadjuobl_Z(struct.getPailicadjuobl_Z());
      setgxTv_SdtPais_base_calculo_Pailicnecaut_Z(struct.getPailicnecaut_Z());
      setgxTv_SdtPais_base_calculo_Pailicingmot_Z(struct.getPailicingmot_Z());
      setgxTv_SdtPais_base_calculo_Pailicmotobl_Z(struct.getPailicmotobl_Z());
      setgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z(struct.getPaibasepromcnt1_Z());
      setgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z(struct.getPaibasepromcnt2_Z());
      setgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z(struct.getPaibasepromtcnt_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_base_calculo getStruct( )
   {
      web.StructSdtPais_base_calculo struct = new web.StructSdtPais_base_calculo ();
      struct.setPaibaseclaseleg(getgxTv_SdtPais_base_calculo_Paibaseclaseleg());
      struct.setPaibasetipo(getgxTv_SdtPais_base_calculo_Paibasetipo());
      struct.setPaibasecod1(getgxTv_SdtPais_base_calculo_Paibasecod1());
      struct.setPaibasecod2(getgxTv_SdtPais_base_calculo_Paibasecod2());
      struct.setPaibaseplus(getgxTv_SdtPais_base_calculo_Paibaseplus());
      struct.setPailicdlim(getgxTv_SdtPais_base_calculo_Pailicdlim());
      struct.setPailicdseman(getgxTv_SdtPais_base_calculo_Pailicdseman());
      struct.setPailicdmes(getgxTv_SdtPais_base_calculo_Pailicdmes());
      struct.setPailicdsemes(getgxTv_SdtPais_base_calculo_Pailicdsemes());
      struct.setPailicdanual(getgxTv_SdtPais_base_calculo_Pailicdanual());
      struct.setPailicadju(getgxTv_SdtPais_base_calculo_Pailicadju());
      struct.setPailicadjuobl(getgxTv_SdtPais_base_calculo_Pailicadjuobl());
      struct.setPailicnecaut(getgxTv_SdtPais_base_calculo_Pailicnecaut());
      struct.setPailicingmot(getgxTv_SdtPais_base_calculo_Pailicingmot());
      struct.setPailicmotobl(getgxTv_SdtPais_base_calculo_Pailicmotobl());
      struct.setPaibasepromcnt1(getgxTv_SdtPais_base_calculo_Paibasepromcnt1());
      struct.setPaibasepromcnt2(getgxTv_SdtPais_base_calculo_Paibasepromcnt2());
      struct.setPaibasepromtcnt(getgxTv_SdtPais_base_calculo_Paibasepromtcnt());
      struct.setActual(getgxTv_SdtPais_base_calculo_Actual().getStruct());
      struct.setPromedio(getgxTv_SdtPais_base_calculo_Promedio().getStruct());
      struct.setMode(getgxTv_SdtPais_base_calculo_Mode());
      struct.setModified(getgxTv_SdtPais_base_calculo_Modified());
      struct.setInitialized(getgxTv_SdtPais_base_calculo_Initialized());
      struct.setPaibaseclaseleg_Z(getgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z());
      struct.setPaibasetipo_Z(getgxTv_SdtPais_base_calculo_Paibasetipo_Z());
      struct.setPaibasecod1_Z(getgxTv_SdtPais_base_calculo_Paibasecod1_Z());
      struct.setPaibasecod2_Z(getgxTv_SdtPais_base_calculo_Paibasecod2_Z());
      struct.setPaibaseplus_Z(getgxTv_SdtPais_base_calculo_Paibaseplus_Z());
      struct.setPailicdlim_Z(getgxTv_SdtPais_base_calculo_Pailicdlim_Z());
      struct.setPailicdseman_Z(getgxTv_SdtPais_base_calculo_Pailicdseman_Z());
      struct.setPailicdmes_Z(getgxTv_SdtPais_base_calculo_Pailicdmes_Z());
      struct.setPailicdsemes_Z(getgxTv_SdtPais_base_calculo_Pailicdsemes_Z());
      struct.setPailicdanual_Z(getgxTv_SdtPais_base_calculo_Pailicdanual_Z());
      struct.setPailicadju_Z(getgxTv_SdtPais_base_calculo_Pailicadju_Z());
      struct.setPailicadjuobl_Z(getgxTv_SdtPais_base_calculo_Pailicadjuobl_Z());
      struct.setPailicnecaut_Z(getgxTv_SdtPais_base_calculo_Pailicnecaut_Z());
      struct.setPailicingmot_Z(getgxTv_SdtPais_base_calculo_Pailicingmot_Z());
      struct.setPailicmotobl_Z(getgxTv_SdtPais_base_calculo_Pailicmotobl_Z());
      struct.setPaibasepromcnt1_Z(getgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z());
      struct.setPaibasepromcnt2_Z(getgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z());
      struct.setPaibasepromtcnt_Z(getgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_base_calculo_Paibaseclaseleg ;
   private byte gxTv_SdtPais_base_calculo_N ;
   private byte gxTv_SdtPais_base_calculo_Pailicdseman ;
   private byte gxTv_SdtPais_base_calculo_Pailicdmes ;
   private byte gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z ;
   private byte gxTv_SdtPais_base_calculo_Pailicdseman_Z ;
   private byte gxTv_SdtPais_base_calculo_Pailicdmes_Z ;
   private short gxTv_SdtPais_base_calculo_Pailicdlim ;
   private short gxTv_SdtPais_base_calculo_Pailicdsemes ;
   private short gxTv_SdtPais_base_calculo_Pailicdanual ;
   private short gxTv_SdtPais_base_calculo_Paibasepromcnt1 ;
   private short gxTv_SdtPais_base_calculo_Paibasepromcnt2 ;
   private short gxTv_SdtPais_base_calculo_Modified ;
   private short gxTv_SdtPais_base_calculo_Initialized ;
   private short gxTv_SdtPais_base_calculo_Pailicdlim_Z ;
   private short gxTv_SdtPais_base_calculo_Pailicdsemes_Z ;
   private short gxTv_SdtPais_base_calculo_Pailicdanual_Z ;
   private short gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z ;
   private short gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtPais_base_calculo_Paibaseplus ;
   private java.math.BigDecimal gxTv_SdtPais_base_calculo_Paibaseplus_Z ;
   private String gxTv_SdtPais_base_calculo_Paibasetipo ;
   private String gxTv_SdtPais_base_calculo_Paibasecod1 ;
   private String gxTv_SdtPais_base_calculo_Paibasecod2 ;
   private String gxTv_SdtPais_base_calculo_Paibasepromtcnt ;
   private String gxTv_SdtPais_base_calculo_Mode ;
   private String gxTv_SdtPais_base_calculo_Paibasetipo_Z ;
   private String gxTv_SdtPais_base_calculo_Paibasecod1_Z ;
   private String gxTv_SdtPais_base_calculo_Paibasecod2_Z ;
   private String gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_base_calculo_Pailicadju ;
   private boolean gxTv_SdtPais_base_calculo_Pailicadjuobl ;
   private boolean gxTv_SdtPais_base_calculo_Pailicnecaut ;
   private boolean gxTv_SdtPais_base_calculo_Pailicingmot ;
   private boolean gxTv_SdtPais_base_calculo_Pailicmotobl ;
   private boolean gxTv_SdtPais_base_calculo_Pailicadju_Z ;
   private boolean gxTv_SdtPais_base_calculo_Pailicadjuobl_Z ;
   private boolean gxTv_SdtPais_base_calculo_Pailicnecaut_Z ;
   private boolean gxTv_SdtPais_base_calculo_Pailicingmot_Z ;
   private boolean gxTv_SdtPais_base_calculo_Pailicmotobl_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private GXBCLevelCollection<web.SdtPais_base_calculo_actual> gxTv_SdtPais_base_calculo_Actual_aux ;
   private GXBCLevelCollection<web.SdtPais_base_calculo_promedio> gxTv_SdtPais_base_calculo_Promedio_aux ;
   private GXBCLevelCollection<web.SdtPais_base_calculo_actual> gxTv_SdtPais_base_calculo_Actual=null ;
   private GXBCLevelCollection<web.SdtPais_base_calculo_promedio> gxTv_SdtPais_base_calculo_Promedio=null ;
}

