package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtmonaco_suggestion_monaco_suggestionItem extends GxUserType
{
   public Sdtmonaco_suggestion_monaco_suggestionItem( )
   {
      this(  new ModelContext(Sdtmonaco_suggestion_monaco_suggestionItem.class));
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem( ModelContext context )
   {
      super( context, "Sdtmonaco_suggestion_monaco_suggestionItem");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtmonaco_suggestion_monaco_suggestionItem");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem( StructSdtmonaco_suggestion_monaco_suggestionItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "label") )
            {
               if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label == null )
               {
                  gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label = new web.Sdtmonaco_suggestion_monaco_suggestionItem_label(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label.readxml(oReader, "label") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "kind") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "insertText") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "insertTextRules") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "hover_value") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "label2") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documentation") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sortText") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parametros") )
            {
               if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros == null )
               {
                  gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros = new GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem>(web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem.class, "monaco_suggestion.monaco_suggestionItem.parametrosItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros.readxmlcollection(oReader, "parametros", "parametrosItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "parametros") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "monaco_suggestion.monaco_suggestionItem" ;
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
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label != null )
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
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label.writexml(oWriter, "label", sNameSpace1);
      }
      oWriter.writeElement("kind", GXutil.trim( GXutil.str( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("insertText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("insertTextRules", GXutil.trim( GXutil.str( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("hover_value", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("label2", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("documentation", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("sortText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros != null )
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
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros.writexmlcollection(oWriter, "parametros", sNameSpace1, "parametrosItem", sNameSpace1);
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
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label != null )
      {
         AddObjectProperty("label", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label, false, false);
      }
      AddObjectProperty("kind", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind, false, false);
      AddObjectProperty("insertText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext, false, false);
      AddObjectProperty("insertTextRules", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules, false, false);
      AddObjectProperty("hover_value", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value, false, false);
      AddObjectProperty("label2", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2, false, false);
      AddObjectProperty("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail, false, false);
      AddObjectProperty("documentation", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation, false, false);
      AddObjectProperty("sortText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext, false, false);
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros != null )
      {
         AddObjectProperty("parametros", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros, false, false);
      }
   }

   public web.Sdtmonaco_suggestion_monaco_suggestionItem_label getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label == null )
      {
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label = new web.Sdtmonaco_suggestion_monaco_suggestionItem_label(remoteHandle, context);
      }
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label( web.Sdtmonaco_suggestion_monaco_suggestionItem_label value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label = value;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_SetNull( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label = (web.Sdtmonaco_suggestion_monaco_suggestionItem_label)null;
   }

   public boolean getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_IsNull( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N ;
   }

   public short getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext = value ;
   }

   public short getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext = value ;
   }

   public GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros == null )
      {
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros = new GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem>(web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem.class, "monaco_suggestion.monaco_suggestionItem.parametrosItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros( GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros = value ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_SetNull( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros = null ;
   }

   public boolean getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_IsNull( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N ;
   }

   public web.Sdtmonaco_suggestion_monaco_suggestionItem Clone( )
   {
      return (web.Sdtmonaco_suggestion_monaco_suggestionItem)(clone()) ;
   }

   public void setStruct( web.StructSdtmonaco_suggestion_monaco_suggestionItem struct )
   {
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label(new web.Sdtmonaco_suggestion_monaco_suggestionItem_label(struct.getLabel()));
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind(struct.getKind());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext(struct.getInserttext());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules(struct.getInserttextrules());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value(struct.getHover_value());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2(struct.getLabel2());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail(struct.getDetail());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation(struct.getDocumentation());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext(struct.getSorttext());
      GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux = new GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem>(web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem.class, "monaco_suggestion.monaco_suggestionItem.parametrosItem", "PayDay", remoteHandle);
      Vector<web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux1 = struct.getParametros();
      if (gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux1.size(); i++)
         {
            gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux.add(new web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem(gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros(gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtmonaco_suggestion_monaco_suggestionItem getStruct( )
   {
      web.StructSdtmonaco_suggestion_monaco_suggestionItem struct = new web.StructSdtmonaco_suggestion_monaco_suggestionItem ();
      struct.setLabel(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label().getStruct());
      struct.setKind(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind());
      struct.setInserttext(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext());
      struct.setInserttextrules(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules());
      struct.setHover_value(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value());
      struct.setLabel2(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2());
      struct.setDetail(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail());
      struct.setDocumentation(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation());
      struct.setSorttext(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext());
      struct.setParametros(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation ;
   protected GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_aux ;
   protected GXBaseCollection<web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros=null ;
   protected web.Sdtmonaco_suggestion_monaco_suggestionItem_label gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label=null ;
}

