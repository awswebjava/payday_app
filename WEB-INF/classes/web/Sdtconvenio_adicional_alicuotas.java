package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconvenio_adicional_alicuotas extends GxSilentTrnSdt
{
   public Sdtconvenio_adicional_alicuotas( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtconvenio_adicional_alicuotas.class));
   }

   public Sdtconvenio_adicional_alicuotas( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "Sdtconvenio_adicional_alicuotas");
      initialize( remoteHandle) ;
   }

   public Sdtconvenio_adicional_alicuotas( int remoteHandle ,
                                           StructSdtconvenio_adicional_alicuotas struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public Sdtconvenio_adicional_alicuotas( )
   {
      super( new ModelContext(Sdtconvenio_adicional_alicuotas.class), "Sdtconvenio_adicional_alicuotas");
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
      return (Object[][])(new Object[][]{new Object[]{"ConveAdiOpcCod", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "alicuotas");
      metadata.set("BT", "convenio_adicionalalicuotas");
      metadata.set("PK", "[ \"ConveAdiOpcCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"ConveAdicod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcCod") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcFor") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcDes") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcAli") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcRelSec") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcCod_Z") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcFor_Z") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcDes_Z") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcAli_Z") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcRelSec_Z") )
            {
               gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "convenio_adicional.alicuotas" ;
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
      oWriter.writeElement("ConveAdiOpcCod", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcFor", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcDes", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcAli", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcRelSec", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtconvenio_adicional_alicuotas_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiOpcCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiOpcFor_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiOpcDes_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiOpcAli_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiOpcRelSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z, 6, 0)));
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
      AddObjectProperty("ConveAdiOpcCod", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod, false, includeNonInitialized);
      AddObjectProperty("ConveAdiOpcFor", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor, false, includeNonInitialized);
      AddObjectProperty("ConveAdiOpcDes", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes, false, includeNonInitialized);
      AddObjectProperty("ConveAdiOpcAli", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali, false, includeNonInitialized);
      AddObjectProperty("ConveAdiOpcRelSec", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtconvenio_adicional_alicuotas_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_Sdtconvenio_adicional_alicuotas_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtconvenio_adicional_alicuotas_Initialized, false, includeNonInitialized);
         AddObjectProperty("ConveAdiOpcCod_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiOpcFor_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiOpcDes_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiOpcAli_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiOpcRelSec_Z", gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtconvenio_adicional_alicuotas sdt )
   {
      if ( sdt.IsDirty("ConveAdiOpcCod") )
      {
         gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod = sdt.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod() ;
      }
      if ( sdt.IsDirty("ConveAdiOpcFor") )
      {
         gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor = sdt.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor() ;
      }
      if ( sdt.IsDirty("ConveAdiOpcDes") )
      {
         gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes = sdt.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes() ;
      }
      if ( sdt.IsDirty("ConveAdiOpcAli") )
      {
         gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali = sdt.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali() ;
      }
      if ( sdt.IsDirty("ConveAdiOpcRelSec") )
      {
         gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec = sdt.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec() ;
      }
   }

   public short getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod( short value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopccod");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor( String value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcfor");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes( String value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcdes");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcali");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali = value ;
   }

   public int getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcrelsec");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_alicuotas_Mode( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Mode ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Mode( String value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtconvenio_adicional_alicuotas_Mode = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Mode_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_alicuotas_Modified( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Modified ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Modified( short value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Modified_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_alicuotas_Initialized( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Initialized ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Initialized( short value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_Sdtconvenio_adicional_alicuotas_Initialized = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Initialized_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z( short value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopccod_Z");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z = (short)(0) ;
      SetDirty("Conveadiopccod_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcfor_Z");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z = "" ;
      SetDirty("Conveadiopcfor_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcdes_Z");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z = "" ;
      SetDirty("Conveadiopcdes_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcali_Z");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z = DecimalUtil.ZERO ;
      SetDirty("Conveadiopcali_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Modified = (short)(1) ;
      SetDirty("Conveadiopcrelsec_Z");
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z = 0 ;
      SetDirty("Conveadiopcrelsec_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtconvenio_adicional_alicuotas_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor = "" ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes = "" ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_adicional_alicuotas_Mode = "" ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z = "" ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z = "" ;
      gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconvenio_adicional_alicuotas_N ;
   }

   public web.Sdtconvenio_adicional_alicuotas Clone( )
   {
      return (web.Sdtconvenio_adicional_alicuotas)(clone()) ;
   }

   public void setStruct( web.StructSdtconvenio_adicional_alicuotas struct )
   {
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod(struct.getConveadiopccod());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor(struct.getConveadiopcfor());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes(struct.getConveadiopcdes());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali(struct.getConveadiopcali());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec(struct.getConveadiopcrelsec());
      setgxTv_Sdtconvenio_adicional_alicuotas_Mode(struct.getMode());
      setgxTv_Sdtconvenio_adicional_alicuotas_Modified(struct.getModified());
      setgxTv_Sdtconvenio_adicional_alicuotas_Initialized(struct.getInitialized());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z(struct.getConveadiopccod_Z());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z(struct.getConveadiopcfor_Z());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z(struct.getConveadiopcdes_Z());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z(struct.getConveadiopcali_Z());
      setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z(struct.getConveadiopcrelsec_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconvenio_adicional_alicuotas getStruct( )
   {
      web.StructSdtconvenio_adicional_alicuotas struct = new web.StructSdtconvenio_adicional_alicuotas ();
      struct.setConveadiopccod(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod());
      struct.setConveadiopcfor(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor());
      struct.setConveadiopcdes(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes());
      struct.setConveadiopcali(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali());
      struct.setConveadiopcrelsec(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec());
      struct.setMode(getgxTv_Sdtconvenio_adicional_alicuotas_Mode());
      struct.setModified(getgxTv_Sdtconvenio_adicional_alicuotas_Modified());
      struct.setInitialized(getgxTv_Sdtconvenio_adicional_alicuotas_Initialized());
      struct.setConveadiopccod_Z(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z());
      struct.setConveadiopcfor_Z(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z());
      struct.setConveadiopcdes_Z(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z());
      struct.setConveadiopcali_Z(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z());
      struct.setConveadiopcrelsec_Z(getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z());
      return struct ;
   }

   private byte gxTv_Sdtconvenio_adicional_alicuotas_N ;
   private short gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod ;
   private short gxTv_Sdtconvenio_adicional_alicuotas_Modified ;
   private short gxTv_Sdtconvenio_adicional_alicuotas_Initialized ;
   private short gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec ;
   private int gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z ;
   private String gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor ;
   private String gxTv_Sdtconvenio_adicional_alicuotas_Mode ;
   private String gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes ;
   private String gxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z ;
}

