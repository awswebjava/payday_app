package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_situacion_sdt_situacionItem extends GxUserType
{
   public Sdtsdt_situacion_sdt_situacionItem( )
   {
      this(  new ModelContext(Sdtsdt_situacion_sdt_situacionItem.class));
   }

   public Sdtsdt_situacion_sdt_situacionItem( ModelContext context )
   {
      super( context, "Sdtsdt_situacion_sdt_situacionItem");
   }

   public Sdtsdt_situacion_sdt_situacionItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_situacion_sdt_situacionItem");
   }

   public Sdtsdt_situacion_sdt_situacionItem( StructSdtsdt_situacion_sdt_situacionItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitCodigo") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescrip") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsLicencia") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicCuentaTrab") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsAusencia") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sItDescAbrev") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm2") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2 = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDiasDivision") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsRevistaAFip") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAplicaPlus") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAbsorbeFer") )
            {
               gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdt_situacion.sdt_situacionItem" ;
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
      oWriter.writeElement("SitCodigo", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDescrip", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitEsLicencia", GXutil.booltostr( gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicCuentaTrab", GXutil.booltostr( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitEsAusencia", GXutil.booltostr( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("sItDescAbrev", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicMesesProm", GXutil.trim( GXutil.str( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicMesesProm2", GXutil.trim( GXutil.str( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDiasDivision", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitEsRevistaAFip", GXutil.booltostr( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitAplicaPlus", GXutil.trim( GXutil.str( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitAbsorbeFer", GXutil.booltostr( gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer));
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
      AddObjectProperty("SitCodigo", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo, false, false);
      AddObjectProperty("SitDescrip", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip, false, false);
      AddObjectProperty("SitEsLicencia", gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia, false, false);
      AddObjectProperty("SitLicCuentaTrab", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab, false, false);
      AddObjectProperty("SitEsAusencia", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia, false, false);
      AddObjectProperty("sItDescAbrev", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev, false, false);
      AddObjectProperty("SitLicMesesProm", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom, false, false);
      AddObjectProperty("SitLicMesesProm2", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2, false, false);
      AddObjectProperty("SitDiasDivision", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision, false, false);
      AddObjectProperty("SitEsRevistaAFip", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip, false, false);
      AddObjectProperty("SitAplicaPlus", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus, false, false);
      AddObjectProperty("SitAbsorbeFer", gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer, false, false);
   }

   public String getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo( String value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo = value ;
   }

   public String getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip( String value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia( boolean value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab( boolean value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia( boolean value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia = value ;
   }

   public String getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev( String value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev = value ;
   }

   public byte getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom( byte value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom = value ;
   }

   public byte getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2 ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2( byte value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2 = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip( boolean value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip = value ;
   }

   public byte getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus( byte value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer ;
   }

   public void setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer( boolean value )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo = "" ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_N = (byte)(1) ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip = "" ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev = "" ;
      gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_situacion_sdt_situacionItem_N ;
   }

   public web.Sdtsdt_situacion_sdt_situacionItem Clone( )
   {
      return (web.Sdtsdt_situacion_sdt_situacionItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_situacion_sdt_situacionItem struct )
   {
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo(struct.getSitcodigo());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip(struct.getSitdescrip());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia(struct.getSiteslicencia());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab(struct.getSitliccuentatrab());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia(struct.getSitesausencia());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev(struct.getSitdescabrev());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom(struct.getSitlicmesesprom());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2(struct.getSitlicmesesprom2());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision(struct.getSitdiasdivision());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip(struct.getSitesrevistaafip());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus(struct.getSitaplicaplus());
      setgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer(struct.getSitabsorbefer());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_situacion_sdt_situacionItem getStruct( )
   {
      web.StructSdtsdt_situacion_sdt_situacionItem struct = new web.StructSdtsdt_situacion_sdt_situacionItem ();
      struct.setSitcodigo(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo());
      struct.setSitdescrip(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip());
      struct.setSiteslicencia(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia());
      struct.setSitliccuentatrab(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab());
      struct.setSitesausencia(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia());
      struct.setSitdescabrev(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev());
      struct.setSitlicmesesprom(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom());
      struct.setSitlicmesesprom2(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2());
      struct.setSitdiasdivision(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision());
      struct.setSitesrevistaafip(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip());
      struct.setSitaplicaplus(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus());
      struct.setSitabsorbefer(getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_situacion_sdt_situacionItem_N ;
   protected byte gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom ;
   protected byte gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2 ;
   protected byte gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision ;
   protected String gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia ;
   protected boolean gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab ;
   protected boolean gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia ;
   protected boolean gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesrevistaafip ;
   protected boolean gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip ;
   protected String gxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev ;
}

