package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPaisbase_old extends GxUserType
{
   public SdtPaisbase_old( )
   {
      this(  new ModelContext(SdtPaisbase_old.class));
   }

   public SdtPaisbase_old( ModelContext context )
   {
      super( context, "SdtPaisbase_old");
   }

   public SdtPaisbase_old( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtPaisbase_old");
   }

   public SdtPaisbase_old( StructSdtPaisbase_old struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePlus") )
            {
               gxTv_SdtPaisbase_old_Paibaseplus = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDLim") )
            {
               gxTv_SdtPaisbase_old_Pailicdlim = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSeman") )
            {
               gxTv_SdtPaisbase_old_Pailicdseman = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDMes") )
            {
               gxTv_SdtPaisbase_old_Pailicdmes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDSemes") )
            {
               gxTv_SdtPaisbase_old_Pailicdsemes = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicDAnual") )
            {
               gxTv_SdtPaisbase_old_Pailicdanual = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdju") )
            {
               gxTv_SdtPaisbase_old_Pailicadju = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicAdjuObl") )
            {
               gxTv_SdtPaisbase_old_Pailicadjuobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicNecAut") )
            {
               gxTv_SdtPaisbase_old_Pailicnecaut = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicIngMot") )
            {
               gxTv_SdtPaisbase_old_Pailicingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiLicMotObl") )
            {
               gxTv_SdtPaisbase_old_Pailicmotobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt1") )
            {
               gxTv_SdtPaisbase_old_Paibasepromcnt1 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCnt2") )
            {
               gxTv_SdtPaisbase_old_Paibasepromcnt2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromTCnt") )
            {
               gxTv_SdtPaisbase_old_Paibasepromtcnt = oReader.getValue() ;
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
         sName = "Paisbase_old" ;
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
      oWriter.writeElement("PaiBasePlus", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisbase_old_Paibaseplus, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDLim", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Pailicdlim, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDSeman", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Pailicdseman, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDMes", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Pailicdmes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDSemes", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Pailicdsemes, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicDAnual", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Pailicdanual, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicAdju", GXutil.booltostr( gxTv_SdtPaisbase_old_Pailicadju));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicAdjuObl", GXutil.booltostr( gxTv_SdtPaisbase_old_Pailicadjuobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicNecAut", GXutil.booltostr( gxTv_SdtPaisbase_old_Pailicnecaut));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicIngMot", GXutil.booltostr( gxTv_SdtPaisbase_old_Pailicingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiLicMotObl", GXutil.booltostr( gxTv_SdtPaisbase_old_Pailicmotobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromCnt1", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Paibasepromcnt1, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromCnt2", GXutil.trim( GXutil.str( gxTv_SdtPaisbase_old_Paibasepromcnt2, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromTCnt", gxTv_SdtPaisbase_old_Paibasepromtcnt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("PaiBasePlus", gxTv_SdtPaisbase_old_Paibaseplus, false, false);
      AddObjectProperty("PaiLicDLim", gxTv_SdtPaisbase_old_Pailicdlim, false, false);
      AddObjectProperty("PaiLicDSeman", gxTv_SdtPaisbase_old_Pailicdseman, false, false);
      AddObjectProperty("PaiLicDMes", gxTv_SdtPaisbase_old_Pailicdmes, false, false);
      AddObjectProperty("PaiLicDSemes", gxTv_SdtPaisbase_old_Pailicdsemes, false, false);
      AddObjectProperty("PaiLicDAnual", gxTv_SdtPaisbase_old_Pailicdanual, false, false);
      AddObjectProperty("PaiLicAdju", gxTv_SdtPaisbase_old_Pailicadju, false, false);
      AddObjectProperty("PaiLicAdjuObl", gxTv_SdtPaisbase_old_Pailicadjuobl, false, false);
      AddObjectProperty("PaiLicNecAut", gxTv_SdtPaisbase_old_Pailicnecaut, false, false);
      AddObjectProperty("PaiLicIngMot", gxTv_SdtPaisbase_old_Pailicingmot, false, false);
      AddObjectProperty("PaiLicMotObl", gxTv_SdtPaisbase_old_Pailicmotobl, false, false);
      AddObjectProperty("PaiBasePromCnt1", gxTv_SdtPaisbase_old_Paibasepromcnt1, false, false);
      AddObjectProperty("PaiBasePromCnt2", gxTv_SdtPaisbase_old_Paibasepromcnt2, false, false);
      AddObjectProperty("PaiBasePromTCnt", gxTv_SdtPaisbase_old_Paibasepromtcnt, false, false);
   }

   public java.math.BigDecimal getgxTv_SdtPaisbase_old_Paibaseplus( )
   {
      return gxTv_SdtPaisbase_old_Paibaseplus ;
   }

   public void setgxTv_SdtPaisbase_old_Paibaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Paibaseplus = value ;
   }

   public short getgxTv_SdtPaisbase_old_Pailicdlim( )
   {
      return gxTv_SdtPaisbase_old_Pailicdlim ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicdlim( short value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicdlim = value ;
   }

   public byte getgxTv_SdtPaisbase_old_Pailicdseman( )
   {
      return gxTv_SdtPaisbase_old_Pailicdseman ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicdseman( byte value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicdseman = value ;
   }

   public byte getgxTv_SdtPaisbase_old_Pailicdmes( )
   {
      return gxTv_SdtPaisbase_old_Pailicdmes ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicdmes( byte value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicdmes = value ;
   }

   public short getgxTv_SdtPaisbase_old_Pailicdsemes( )
   {
      return gxTv_SdtPaisbase_old_Pailicdsemes ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicdsemes( short value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicdsemes = value ;
   }

   public short getgxTv_SdtPaisbase_old_Pailicdanual( )
   {
      return gxTv_SdtPaisbase_old_Pailicdanual ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicdanual( short value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicdanual = value ;
   }

   public boolean getgxTv_SdtPaisbase_old_Pailicadju( )
   {
      return gxTv_SdtPaisbase_old_Pailicadju ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicadju( boolean value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicadju = value ;
   }

   public boolean getgxTv_SdtPaisbase_old_Pailicadjuobl( )
   {
      return gxTv_SdtPaisbase_old_Pailicadjuobl ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicadjuobl( boolean value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicadjuobl = value ;
   }

   public boolean getgxTv_SdtPaisbase_old_Pailicnecaut( )
   {
      return gxTv_SdtPaisbase_old_Pailicnecaut ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicnecaut( boolean value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicnecaut = value ;
   }

   public boolean getgxTv_SdtPaisbase_old_Pailicingmot( )
   {
      return gxTv_SdtPaisbase_old_Pailicingmot ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicingmot( boolean value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicingmot = value ;
   }

   public boolean getgxTv_SdtPaisbase_old_Pailicmotobl( )
   {
      return gxTv_SdtPaisbase_old_Pailicmotobl ;
   }

   public void setgxTv_SdtPaisbase_old_Pailicmotobl( boolean value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Pailicmotobl = value ;
   }

   public short getgxTv_SdtPaisbase_old_Paibasepromcnt1( )
   {
      return gxTv_SdtPaisbase_old_Paibasepromcnt1 ;
   }

   public void setgxTv_SdtPaisbase_old_Paibasepromcnt1( short value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Paibasepromcnt1 = value ;
   }

   public short getgxTv_SdtPaisbase_old_Paibasepromcnt2( )
   {
      return gxTv_SdtPaisbase_old_Paibasepromcnt2 ;
   }

   public void setgxTv_SdtPaisbase_old_Paibasepromcnt2( short value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Paibasepromcnt2 = value ;
   }

   public String getgxTv_SdtPaisbase_old_Paibasepromtcnt( )
   {
      return gxTv_SdtPaisbase_old_Paibasepromtcnt ;
   }

   public void setgxTv_SdtPaisbase_old_Paibasepromtcnt( String value )
   {
      gxTv_SdtPaisbase_old_N = (byte)(0) ;
      gxTv_SdtPaisbase_old_Paibasepromtcnt = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPaisbase_old_Paibaseplus = DecimalUtil.ZERO ;
      gxTv_SdtPaisbase_old_N = (byte)(1) ;
      gxTv_SdtPaisbase_old_Paibasepromtcnt = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPaisbase_old_N ;
   }

   public web.SdtPaisbase_old Clone( )
   {
      return (web.SdtPaisbase_old)(clone()) ;
   }

   public void setStruct( web.StructSdtPaisbase_old struct )
   {
      setgxTv_SdtPaisbase_old_Paibaseplus(struct.getPaibaseplus());
      setgxTv_SdtPaisbase_old_Pailicdlim(struct.getPailicdlim());
      setgxTv_SdtPaisbase_old_Pailicdseman(struct.getPailicdseman());
      setgxTv_SdtPaisbase_old_Pailicdmes(struct.getPailicdmes());
      setgxTv_SdtPaisbase_old_Pailicdsemes(struct.getPailicdsemes());
      setgxTv_SdtPaisbase_old_Pailicdanual(struct.getPailicdanual());
      setgxTv_SdtPaisbase_old_Pailicadju(struct.getPailicadju());
      setgxTv_SdtPaisbase_old_Pailicadjuobl(struct.getPailicadjuobl());
      setgxTv_SdtPaisbase_old_Pailicnecaut(struct.getPailicnecaut());
      setgxTv_SdtPaisbase_old_Pailicingmot(struct.getPailicingmot());
      setgxTv_SdtPaisbase_old_Pailicmotobl(struct.getPailicmotobl());
      setgxTv_SdtPaisbase_old_Paibasepromcnt1(struct.getPaibasepromcnt1());
      setgxTv_SdtPaisbase_old_Paibasepromcnt2(struct.getPaibasepromcnt2());
      setgxTv_SdtPaisbase_old_Paibasepromtcnt(struct.getPaibasepromtcnt());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPaisbase_old getStruct( )
   {
      web.StructSdtPaisbase_old struct = new web.StructSdtPaisbase_old ();
      struct.setPaibaseplus(getgxTv_SdtPaisbase_old_Paibaseplus());
      struct.setPailicdlim(getgxTv_SdtPaisbase_old_Pailicdlim());
      struct.setPailicdseman(getgxTv_SdtPaisbase_old_Pailicdseman());
      struct.setPailicdmes(getgxTv_SdtPaisbase_old_Pailicdmes());
      struct.setPailicdsemes(getgxTv_SdtPaisbase_old_Pailicdsemes());
      struct.setPailicdanual(getgxTv_SdtPaisbase_old_Pailicdanual());
      struct.setPailicadju(getgxTv_SdtPaisbase_old_Pailicadju());
      struct.setPailicadjuobl(getgxTv_SdtPaisbase_old_Pailicadjuobl());
      struct.setPailicnecaut(getgxTv_SdtPaisbase_old_Pailicnecaut());
      struct.setPailicingmot(getgxTv_SdtPaisbase_old_Pailicingmot());
      struct.setPailicmotobl(getgxTv_SdtPaisbase_old_Pailicmotobl());
      struct.setPaibasepromcnt1(getgxTv_SdtPaisbase_old_Paibasepromcnt1());
      struct.setPaibasepromcnt2(getgxTv_SdtPaisbase_old_Paibasepromcnt2());
      struct.setPaibasepromtcnt(getgxTv_SdtPaisbase_old_Paibasepromtcnt());
      return struct ;
   }

   protected byte gxTv_SdtPaisbase_old_N ;
   protected byte gxTv_SdtPaisbase_old_Pailicdseman ;
   protected byte gxTv_SdtPaisbase_old_Pailicdmes ;
   protected short gxTv_SdtPaisbase_old_Pailicdlim ;
   protected short gxTv_SdtPaisbase_old_Pailicdsemes ;
   protected short gxTv_SdtPaisbase_old_Pailicdanual ;
   protected short gxTv_SdtPaisbase_old_Paibasepromcnt1 ;
   protected short gxTv_SdtPaisbase_old_Paibasepromcnt2 ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtPaisbase_old_Paibaseplus ;
   protected String gxTv_SdtPaisbase_old_Paibasepromtcnt ;
   protected String sTagName ;
   protected boolean gxTv_SdtPaisbase_old_Pailicadju ;
   protected boolean gxTv_SdtPaisbase_old_Pailicadjuobl ;
   protected boolean gxTv_SdtPaisbase_old_Pailicnecaut ;
   protected boolean gxTv_SdtPaisbase_old_Pailicingmot ;
   protected boolean gxTv_SdtPaisbase_old_Pailicmotobl ;
   protected boolean readElement ;
   protected boolean formatError ;
}

